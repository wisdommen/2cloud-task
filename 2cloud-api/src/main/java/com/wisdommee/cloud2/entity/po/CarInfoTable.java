package com.wisdommee.cloud2.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 *
 * @TableName car_info_table
 */
@TableName(value ="car_info_table")
@Data
public class CarInfoTable implements Serializable {
    /**
     *
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     *
     */
    @TableField(value = "sale_category")
    private String saleCategory;

    /**
     *
     */
    @TableField(value = "make")
    private String make;

    /**
     *
     */
    @TableField(value = "model")
    private String model;

    /**
     *
     */
    @TableField(value = "branch")
    private String branch;

    /**
     *
     */
    @TableField(value = "odometer")
    private Integer odometer;

    /**
     *
     */
    @TableField(value = "overall_condition")
    private String overallCondition;

    /**
     *
     */
    @TableField(value = "year_group")
    private Integer yearGroup;

    /**
     *
     */
    @TableField(value = "sold_date")
    private LocalDateTime soldDate;

    /**
     *
     */
    @TableField(value = "fuel_type_description")
    private String fuelTypeDescription;

    /**
     *
     */
    @TableField(value = "gear_type_description")
    private String gearTypeDescription;

    /**
     *
     */
    @TableField(value = "description")
    private String description;

    /**
     *
     */
    @TableField(value = "body_style_description")
    private String bodyStyleDescription;

    /**
     *
     */
    @TableField(value = "drive_description")
    private String driveDescription;

    /**
     *
     */
    @TableField(value = "vehicle_description")
    private String vehicleDescription;

    /**
     *
     */
    @TableField(value = "condition_description")
    private String conditionDescription;

    /**
     *
     */
    @TableField(value = "options_accessories")
    private String optionsAccessories;

    /**
     *
     */
    @TableField(value = "log_books")
    private String logBooks;

    /**
     *
     */
    @TableField(value = "keys_status")
    private String keysStatus;

    /**
     *
     */
    @TableField(value = "tyre_front_near_condition")
    private String tyreFrontNearCondition;

    /**
     *
     */
    @TableField(value = "tyre_front_off_condition")
    private String tyreFrontOffCondition;

    /**
     *
     */
    @TableField(value = "tyre_rear_near_condition")
    private String tyreRearNearCondition;

    /**
     *
     */
    @TableField(value = "tyre_rear_off_condition")
    private String tyreRearOffCondition;

    /**
     *
     */
    @TableField(value = "tyre_spare_condition")
    private String tyreSpareCondition;

    /**
     *
     */
    @TableField(value = "color")
    private String color;

    /**
     *
     */
    @TableField(value = "engine_description")
    private String engineDescription;

    /**
     *
     */
    @TableField(value = "gear_num")
    private Integer gearNum;
    /**
     *
     */
    @TableField(value = "seat_num")
    private Integer seatNum;
    /**
     *
     */
    @TableField(value = "cylinders")
    private Integer cylinders;
    /**
     *
     */
    @TableField(value = "door_num")
    private Integer doorNum;

    /**
     *
     */
    @TableField(value = "badge_description")
    private String badgeDescription;

    /**
     *
     */
    @TableField(value = "fuel_delivery_description")
    private String fuelDeliveryDescription;

    /**
     *
     */
    @TableField(value = "induction_description")
    private String inductionDescription;

    /**
     *
     */
    @TableField(value = "owner_manual_status")
    private String ownerManualStatus;

    /**
     *
     */
    @TableField(value = "sale_type")
    private String saleType;

    /**
     *
     */
    @TableField(value = "division")
    private String division;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
