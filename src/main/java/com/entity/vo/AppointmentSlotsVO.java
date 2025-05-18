
package com.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 预约时间段名额管理 VO 类（标准版）
 */
@Data
@ApiModel(value = "AppointmentSlotsVO", description = "预约时间段名额管理传输对象")
public class AppointmentSlotsVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键ID")
    private Long id;

    @ApiModelProperty(value = "套餐ID")
    private Long packageId;

    @ApiModelProperty(value = "预约日期（格式：yyyy-MM-dd）")
    private String appointmentDate;

    @ApiModelProperty(value = "预约时间段（如 9-10）")
    private String timeslot;

    @ApiModelProperty(value = "最大名额")
    private Integer maxSlots;

    @ApiModelProperty(value = "已预约人数")
    private Integer reservedSlots;

    @ApiModelProperty(value = "剩余名额")
    private Integer remainingSlots;

    @ApiModelProperty(value = "记录创建时间")
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date addtime;
}
