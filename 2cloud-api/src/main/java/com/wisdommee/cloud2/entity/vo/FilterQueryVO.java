package com.wisdommee.cloud2.entity.vo;

import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
public class FilterQueryVO {
    private int min_year;
    private int max_year;
    private Set<String> fuelType;
    private int min_odometer;
    private int max_odometer;
    private Set<String> saleCategory;
    private Set<String> transmissionType;
    private Set<String> stateType;
    private Set<String> badge;
    private Set<String> bodyFilter;
    private Set<Integer> seatFilter;
    private Set<String> driveDescription;
    private Set<String> engineDescription;
    private Date min_sold_date;
    private Date max_sold_date;
    private Set<String> division;
    private Set<Integer> doorNum;
    private Set<Integer> cylinders;
}
