package com.wisdommee.cloud2.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ReflectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wisdommee.cloud2.annotation.SearchField;
import com.wisdommee.cloud2.entity.bo.CompareType;
import com.wisdommee.cloud2.entity.vo.CarQueryVO;
import com.wisdommee.cloud2.service.CarInfoTableService;
import com.wisdommee.cloud2.entity.po.CarInfoTable;
import com.wisdommee.cloud2.mapper.CarInfoTableMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.Objects;

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
            if (field.getName().equals("page") || field.getName().equals("limit")){
                continue;
            }
            Object fieldValue = BeanUtil.getFieldValue(carQueryVO, field.getName());
            if (fieldValue == null){
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
        return carInfoTableMapper.selectPage(Objects.requireNonNullElseGet(page, () -> new Page<>(0, 10000)), queryWrapper);
    }
}




