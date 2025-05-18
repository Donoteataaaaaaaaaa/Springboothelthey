
package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 预约时间段名额管理实体类（MyBatis-Plus 2.3 兼容版）
 */
@Data
@TableName("appointment_slots")
public class AppointmentSlotsEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Long id;

    private Long packageId;         // 套餐ID
    private String appointmentDate; // 预约日期（yyyy-MM-dd）
    private String timeslot;        // 预约时间段（如 9-10）

    private Integer maxSlots;       // 最大名额
    private Integer reservedSlots;  // 已预约人数
    private Integer remainingSlots; // 剩余名额

    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date addtime;           // 创建时间
}
