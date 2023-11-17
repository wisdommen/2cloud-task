package com.wisdommee.cloud2.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ReflectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wisdommee.cloud2.annotation.SearchField;
import com.wisdommee.cloud2.entity.vo.CarQueryVO;
import com.wisdommee.cloud2.entity.vo.FilterQueryVO;
import com.wisdommee.cloud2.service.CarInfoTableService;
import com.wisdommee.cloud2.entity.po.CarInfoTable;
import com.wisdommee.cloud2.mapper.CarInfoTableMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
* @author Ling Bao
* @description 针对表【car_info_table】的数据库操作Service实现
* @createDate 2023-11-16 13:19:52
*/
@Service
public class CarInfoTableServiceImpl extends ServiceImpl<CarInfoTableMapper, CarInfoTable>
    implements CarInfoTableService {
    @Resource
    private CarInfoTableMapper carInfoTableMapper;


    @Override
    public Page<CarInfoTable> getCarList(Page<CarInfoTable> page) {
        return carInfoTableMapper.getUserList(page);
    }

    @Override
    public Page<CarInfoTable> searchCarInfo(Page<CarInfoTable> page, CarQueryVO carQueryVO) {
        QueryWrapper<CarInfoTable> queryWrapper = new QueryWrapper<>();
        Field[] fields = ReflectUtil.getFields(CarQueryVO.class);
        for (Field field : fields){
            if (field.getName().equals("page") ||
                    field.getName().equals("limit") ||
                    field.getName().equals("orderBy")){
                continue;
            }
            Object fieldValue = BeanUtil.getFieldValue(carQueryVO, field.getName());
            if (fieldValue == null){
                continue;
            }
            if (field.getName().equals("sort_by")){
                if (carQueryVO.getSort_by() == null){
                    continue;
                }
                queryWrapper.orderBy(true, carQueryVO.getOrder_by().equals("ASC"), carQueryVO.getSort_by());
                continue;
            }
            if (fieldValue.equals("(Blank)")){
                queryWrapper.eq(field.getName(), "");
                continue;
            }
            if (field.isAnnotationPresent(SearchField.class)){
                SearchField annotation = field.getAnnotation(SearchField.class);
                switch (annotation.type()){
                    case EQUALS -> queryWrapper.eq(annotation.value(), fieldValue);
                    case GT -> queryWrapper.gt(annotation.value(), fieldValue);
                    case LT -> queryWrapper.lt(annotation.value(), fieldValue);
                    case GTE -> queryWrapper.ge(annotation.value(), fieldValue);
                    case LTE -> queryWrapper.le(annotation.value(), fieldValue);
                    case LIKE -> queryWrapper.like(annotation.value(), fieldValue);
                }
            }
        }
        page.setTotal(carInfoTableMapper.selectCount(queryWrapper));
        return carInfoTableMapper.selectPage(Objects.requireNonNullElseGet(page, () -> new Page<>(0, 10000)), queryWrapper);
    }

    @Override
    public FilterQueryVO searchFilters(String make, String model) {
        FilterQueryVO filterQueryVO = new FilterQueryVO();
        filterQueryVO.setBodyFilter(carInfoTableMapper.getDistinctBodyFilter(make, model));
        filterQueryVO.setBadge(carInfoTableMapper.getDistinctBadgeDescription(make, model));
        filterQueryVO.setCylinders(carInfoTableMapper.getDistinctCylinder(make, model));
        filterQueryVO.setDivision(carInfoTableMapper.getDistinctDivision(make, model));
        filterQueryVO.setDoorNum(carInfoTableMapper.getDistinctDoorNum(make, model));
        filterQueryVO.setDriveDescription(carInfoTableMapper.getDistinctDriveDescription(make, model));
        filterQueryVO.setEngineDescription(carInfoTableMapper.getDistinctEngineDescription(make, model));
        filterQueryVO.setFuelType(carInfoTableMapper.getDistinctFuelType(make, model));
        filterQueryVO.setTransmissionType(carInfoTableMapper.getDistinctGearType(make, model));
        filterQueryVO.setSaleCategory(carInfoTableMapper.getDistinctSaleCategory(make, model));
        filterQueryVO.setSeatFilter(carInfoTableMapper.getDistinctSeatNum(make, model));
        filterQueryVO.setMax_year(carInfoTableMapper.getMaxYear(make, model));
        filterQueryVO.setMin_year(carInfoTableMapper.getMinYear(make, model));
        filterQueryVO.setMax_odometer(carInfoTableMapper.getMaxOdometer(make, model));
        filterQueryVO.setMin_odometer(carInfoTableMapper.getMinOdometer(make, model));
        filterQueryVO.setMax_sold_date(carInfoTableMapper.getMaxSoldDate(make, model));
        filterQueryVO.setMin_sold_date(carInfoTableMapper.getMinSoldDate(make, model));
        Set<String> allBranch = carInfoTableMapper.getAllBranch(make, model);
        Set<String> states = new HashSet<>();
        if (!allBranch.isEmpty()){
            Pattern pattern = Pattern.compile("\\(([^)]+)\\)");
            for (String branch : allBranch){
                if (branch == null){
                    continue;
                }
                Matcher matcher = pattern.matcher(branch);
                if (matcher.find()){
                    states.add(matcher.group(1));
                }
            }
        }
        filterQueryVO.setStateType(states);
        return filterQueryVO;
    }

    @Override
    public Set<String> getMakes() {
        return carInfoTableMapper.getDistinctMake();
    }

    @Override
    public Set<String> getModels(String make) {
        return carInfoTableMapper.getDistinctModel(make);
    }
}




