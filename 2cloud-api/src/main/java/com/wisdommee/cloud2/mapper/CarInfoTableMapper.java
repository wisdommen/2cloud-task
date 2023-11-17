package com.wisdommee.cloud2.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wisdommee.cloud2.entity.po.CarInfoTable;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.Set;

/**
* @author Ling Bao
* @description 针对表【car_info_table】的数据库操作Mapper
* @createDate 2023-11-16 13:19:52
* @Entity com.wisdommee.cloud2.entity.po.CarInfoTable
*/
public interface CarInfoTableMapper extends BaseMapper<CarInfoTable> {

    Page<CarInfoTable> getUserList(Page<CarInfoTable> page);

    @Select("SELECT DISTINCT make FROM car_info_table")
    Set<String> getDistinctMake();

    @Select("SELECT DISTINCT model FROM car_info_table WHERE make = #{make}")
    Set<String> getDistinctModel(String make);

    @Select("SELECT DISTINCT fuel_type_description FROM car_info_table WHERE make = #{make} AND model = #{model}")
    Set<String> getDistinctFuelType(String make, String model);

    @Select("SELECT DISTINCT sale_category FROM car_info_table WHERE make = #{make} AND model = #{model}")
    Set<String> getDistinctSaleCategory(String make, String model);

    @Select("SELECT DISTINCT gear_type_description FROM car_info_table WHERE make = #{make} AND model = #{model}")
    Set<String> getDistinctGearType(String make, String model);

    @Select("SELECT DISTINCT badge_description FROM car_info_table WHERE make = #{make} AND model = #{model}")
    Set<String> getDistinctBadgeDescription(String make, String model);

    @Select("SELECT DISTINCT body_style_description FROM car_info_table WHERE make = #{make} AND model = #{model}")
    Set<String> getDistinctBodyFilter(String make, String model);

    @Select("SELECT DISTINCT seat_num FROM car_info_table WHERE make = #{make} AND model = #{model}")
    Set<Integer> getDistinctSeatNum(String make, String model);

    @Select("SELECT DISTINCT drive_description FROM car_info_table WHERE make = #{make} AND model = #{model}")
    Set<String> getDistinctDriveDescription(String make, String model);

    @Select("SELECT DISTINCT engine_description FROM car_info_table WHERE make = #{make} AND model = #{model}")
    Set<String> getDistinctEngineDescription(String make, String model);

    @Select("SELECT DISTINCT division FROM car_info_table WHERE make = #{make} AND model = #{model}")
    Set<String> getDistinctDivision(String make, String model);

    @Select("SELECT DISTINCT door_num FROM car_info_table WHERE make = #{make} AND model = #{model}")
    Set<Integer> getDistinctDoorNum(String make, String model);

    @Select("SELECT DISTINCT cylinders FROM car_info_table WHERE make = #{make} AND model = #{model}")
    Set<Integer> getDistinctCylinder(String make, String model);

    @Select("SELECT MAX(year_group) FROM car_info_table WHERE make = #{make} AND model = #{model}")
    Integer getMaxYear(String make, String model);

    @Select("SELECT MIN(year_group) FROM car_info_table WHERE make = #{make} AND model = #{model}")
    Integer getMinYear(String make, String model);

    @Select("SELECT MAX(odometer) FROM car_info_table WHERE make = #{make} AND model = #{model}")
    Integer getMaxOdometer(String make, String model);

    @Select("SELECT MIN(odometer) FROM car_info_table WHERE make = #{make} AND model = #{model}")
    Integer getMinOdometer(String make, String model);

    @Select("SELECT MAX(sold_date) FROM car_info_table WHERE make = #{make} AND model = #{model}")
    Date getMaxSoldDate(String make, String model);

    @Select("SELECT MIN(sold_date) FROM car_info_table WHERE make = #{make} AND model = #{model}")
    Date getMinSoldDate(String make, String model);

    @Select("SELECT DISTINCT branch FROM car_info_table WHERE make = #{make} AND model = #{model}")
    Set<String> getAllBranch(String make, String model);
}




