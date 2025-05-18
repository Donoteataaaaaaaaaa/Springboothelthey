package com.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.AppointmentSlotsDao;
import com.entity.AppointmentSlotsEntity;
import com.service.AppointmentSlotsService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 预约时间段 Service 实现类
 */
@Service("appointmentSlotsService")
public class AppointmentSlotsServiceImpl extends ServiceImpl<AppointmentSlotsDao, AppointmentSlotsEntity>
        implements AppointmentSlotsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<AppointmentSlotsEntity> page = this.selectPage(
                new Query<AppointmentSlotsEntity>(params).getPage(),
                new EntityWrapper<AppointmentSlotsEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public Integer getRemainingSlots(Long packageId, String appointmentDate, String timeslot) {
        return baseMapper.getRemainingSlots(packageId, appointmentDate, timeslot);
    }

    @Override
    public Integer getMaxSlots(Long packageId, String appointmentDate, String timeslot) {
        return baseMapper.getMaxSlots(packageId, appointmentDate, timeslot);
    }

    @Override
    @Transactional
    public boolean decreaseRemainingSlots(Long packageId, String appointmentDate, String timeslot) {
        int result = baseMapper.decreaseRemainingSlots(packageId, appointmentDate, timeslot);
        return result > 0;
    }

    @Override
    @Transactional
    public boolean increaseRemainingSlots(Long packageId, String appointmentDate, String timeslot) {
        int result = baseMapper.increaseRemainingSlots(packageId, appointmentDate, timeslot);
        return result > 0;
    }
}
