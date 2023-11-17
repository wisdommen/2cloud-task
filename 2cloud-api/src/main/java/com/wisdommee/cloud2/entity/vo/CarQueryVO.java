package com.wisdommee.cloud2.entity.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.wisdommee.cloud2.annotation.SearchField;
import com.wisdommee.cloud2.entity.bo.CompareType;
import lombok.Data;

@Data
public class CarQueryVO {
    private int limit;
    @SearchField("make")
    private String make;
    @SearchField("model")
    private String model;
    @SearchField("fuel_type_description")
    private String fuel_type;
    @SearchField("sale_category")
    private String sale_category;
    @SearchField("gear_type_description")
    private String transmission;
    @SearchField("badge_description")
    private String badge;
    @SearchField(value = "branch", type = CompareType.LIKE)
    private String state;
    @SearchField("body_style_description")
    private String bodyFilter;
    @SearchField("seat_num")
    private String seatFilter;
    @SearchField(value = "year_group", type = CompareType.GTE)
    private String min_year;
    @SearchField(value = "year_group", type = CompareType.LTE)
    private String max_year;
    @SearchField(value = "odometer", type = CompareType.GTE)
    private String min_odometer;
    @SearchField(value = "odometer", type = CompareType.LTE)
    private String max_odometer;
    private int page;
    private String sort_by;
    private String order_by;
    @SearchField("drive_description")
    private String driveDescription;
    @SearchField("engine_description")
    private String engine;
    @SearchField(value = "sold_date", type = CompareType.GTE)
    private String min_sold_date;
    @SearchField(value = "sold_date", type = CompareType.LTE)
    private String max_sold_date;
    @SearchField(value = "description", type = CompareType.LIKE)
    private String keyword;
    @SearchField("division")
    private String division;
    @SearchField("door_num")
    private String doorNum;
    @SearchField("cylinders")
    private String cylinders;
}
