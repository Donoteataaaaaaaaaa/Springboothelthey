package com.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;

import com.dao.TijianyuyueDao;
import com.entity.TijianyuyueEntity;
import com.service.TijianyuyueService;
import com.entity.vo.TijianyuyueVO;
import com.entity.view.TijianyuyueView;

@Service("tijianyuyueService")
public class TijianyuyueServiceImpl extends ServiceImpl<TijianyuyueDao, TijianyuyueEntity> implements TijianyuyueService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<TijianyuyueEntity> page = this.selectPage(
				new Query<TijianyuyueEntity>(params).getPage(),
				new EntityWrapper<TijianyuyueEntity>()
		);
		return new PageUtils(page);
	}

	@Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<TijianyuyueEntity> wrapper) {
		Page<TijianyuyueView> page = new Query<TijianyuyueView>(params).getPage();
		page.setRecords(baseMapper.selectListView(page, wrapper));
		return new PageUtils(page);
	}

	@Override
	public List<TijianyuyueVO> selectListVO(Wrapper<TijianyuyueEntity> wrapper) {
		return baseMapper.selectListVO(wrapper);
	}

	@Override
	public TijianyuyueVO selectVO(Wrapper<TijianyuyueEntity> wrapper) {
		return baseMapper.selectVO(wrapper);
	}

	@Override
	public List<TijianyuyueView> selectListView(Wrapper<TijianyuyueEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public TijianyuyueView selectView(Wrapper<TijianyuyueEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

	// ✅ 新增业务核心实现

	@Override
	@Transactional
	public boolean submitAppointment(TijianyuyueEntity entity) {
		// 检查预约时间冲突
		int conflictCount = baseMapper.checkTimeConflict(
				Long.parseLong(entity.getYonghuzhanghao()),
				entity.getYuyueshijian().toString(),
				entity.getTimeslot()
		);
		if (conflictCount > 0) {
			return false; // 存在冲突，无法预约
		}

		// 设置预约默认值
		entity.setSfsh("未审核");
		entity.setIspay("未支付");
		entity.setAddtime(new Date());
		return this.insert(entity);
	}

	@Override
	@Transactional
	public boolean cancelAppointment(Long appointmentId) {
		TijianyuyueEntity appointment = this.selectById(appointmentId);
		if (appointment == null) return false;

		Date now = new Date();
		long daysDiff = (appointment.getYuyueshijian().getTime() - now.getTime()) / (1000 * 60 * 60 * 24);
		if (daysDiff < 3) {
			return false; // 距离预约不足3天，不能取消
		}

		// 设置状态为已取消
		appointment.setSfsh("已取消");
		appointment.setCancelTime(now);
		return this.updateById(appointment);
	}

	@Override
	public boolean checkTimeConflict(Long userId, String appointmentDate, String timeslot) {
		int conflictCount = baseMapper.checkTimeConflict(userId, appointmentDate, timeslot);
		return conflictCount > 0;
	}

	@Override
	public List<TijianyuyueEntity> getRemindAppointments() {
		return baseMapper.selectRemindList();
	}

	@Override
	@Transactional
	public int batchUpdateRemindFlag(List<Long> ids) {
		return baseMapper.batchUpdateRemindFlag(ids);
	}
}
