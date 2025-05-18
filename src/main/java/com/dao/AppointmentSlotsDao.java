package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.entity.AppointmentSlotsEntity;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 预约时间段管理 DAO 接口
 * 专门负责时间段的预约名额管理
 */
public interface AppointmentSlotsDao extends BaseMapper<AppointmentSlotsEntity> {

    /**
     * 查询某套餐某日期某时间段的剩余名额
     * @param packageId 套餐ID
     * @param appointmentDate 预约日期 (格式：yyyy-MM-dd)
     * @param timeslot 时间段 (如 "09:00-10:00")
     * @return 剩余名额
     */
    Integer getRemainingSlots(@Param("packageId") Long packageId,
                              @Param("appointmentDate") String appointmentDate,
                              @Param("timeslot") String timeslot);

    /**
     * 查询某套餐某日期某时间段的最大预约名额
     * @param packageId 套餐ID
     * @param appointmentDate 预约日期
     * @param timeslot 时间段
     * @return 最大名额
     */
    Integer getMaxSlots(@Param("packageId") Long packageId,
                        @Param("appointmentDate") String appointmentDate,
                        @Param("timeslot") String timeslot);

    /**
     * 扣减剩余名额（用户预约时调用）
     * @param packageId 套餐ID
     * @param appointmentDate 预约日期
     * @param timeslot 时间段
     * @return 影响行数（成功 1，失败 0）
     */
    int decreaseRemainingSlots(@Param("packageId") Long packageId,
                               @Param("appointmentDate") String appointmentDate,
                               @Param("timeslot") String timeslot);

    /**
     * 恢复剩余名额（用户取消预约时调用）
     * @param packageId 套餐ID
     * @param appointmentDate 预约日期
     * @param timeslot 时间段
     * @return 影响行数
     */
    int increaseRemainingSlots(@Param("packageId") Long packageId,
                               @Param("appointmentDate") String appointmentDate,
                               @Param("timeslot") String timeslot);
}
