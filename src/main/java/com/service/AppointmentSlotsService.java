package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.AppointmentSlotsEntity;
import com.utils.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * 预约时间段 Service 接口
 * 专门负责时间段的预约名额管理
 */
public interface AppointmentSlotsService extends IService<AppointmentSlotsEntity> {

    /**
     * 分页查询预约时间段信息
     * @param params 查询参数
     * @return 分页工具类
     */
    PageUtils queryPage(Map<String, Object> params);

    /**
     * 查询某套餐某日期某时间段的剩余名额
     * @param packageId 套餐ID
     * @param appointmentDate 预约日期
     * @param timeslot 时间段
     * @return 剩余名额
     */
    Integer getRemainingSlots(Long packageId, String appointmentDate, String timeslot);

    /**
     * 查询某套餐某日期某时间段的最大名额
     * @param packageId 套餐ID
     * @param appointmentDate 预约日期
     * @param timeslot 时间段
     * @return 最大名额
     */
    Integer getMaxSlots(Long packageId, String appointmentDate, String timeslot);

    /**
     * 扣减剩余名额（用户预约时调用）
     * @param packageId 套餐ID
     * @param appointmentDate 预约日期
     * @param timeslot 时间段
     * @return 是否成功扣减
     */
    boolean decreaseRemainingSlots(Long packageId, String appointmentDate, String timeslot);

    /**
     * 恢复剩余名额（用户取消预约时调用）
     * @param packageId 套餐ID
     * @param appointmentDate 预约日期
     * @param timeslot 时间段
     * @return 是否成功恢复
     */
    boolean increaseRemainingSlots(Long packageId, String appointmentDate, String timeslot);
}
