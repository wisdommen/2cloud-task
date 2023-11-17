package com.wisdommee.cloud2.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wisdommee.cloud2.entity.po.CarInfoTable;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wisdommee.cloud2.entity.vo.CarQueryVO;
import com.wisdommee.cloud2.entity.vo.FilterQueryVO;

import java.util.List;
import java.util.Set;

/**
* @author Ling Bao
* @description 针对表【car_info_table】的数据库操作Service
* @createDate 2023-11-16 13:19:52
*/
public interface CarInfoTableService extends IService<CarInfoTable> {

    Page<CarInfoTable> getCarList(Page<CarInfoTable> page);

    Page<CarInfoTable> searchCarInfo(Page<CarInfoTable> page, CarQueryVO carQueryVO);

    FilterQueryVO searchFilters(String make, String model);

    Set<String> getMakes();

    Set<String> getModels(String make);
}
