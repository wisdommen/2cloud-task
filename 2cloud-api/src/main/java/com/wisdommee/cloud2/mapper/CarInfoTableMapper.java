package com.wisdommee.cloud2.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wisdommee.cloud2.entity.po.CarInfoTable;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author Ling Bao
* @description 针对表【car_info_table】的数据库操作Mapper
* @createDate 2023-11-16 13:19:52
* @Entity com.wisdommee.cloud2.entity.po.CarInfoTable
*/
public interface CarInfoTableMapper extends BaseMapper<CarInfoTable> {

    Page<CarInfoTable> getUserList(Page<CarInfoTable> page);
}




