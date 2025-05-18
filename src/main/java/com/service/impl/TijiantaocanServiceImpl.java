package com.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;

import com.dao.TijiantaocanDao;
import com.entity.TijiantaocanEntity;
import com.service.TijiantaocanService;
import com.entity.vo.TijiantaocanVO;
import com.entity.view.TijiantaocanView;

@Service("tijiantaocanService")
public class TijiantaocanServiceImpl extends ServiceImpl<TijiantaocanDao, TijiantaocanEntity> implements TijiantaocanService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<TijiantaocanEntity> page = this.selectPage(
				new Query<TijiantaocanEntity>(params).getPage(),
				new EntityWrapper<TijiantaocanEntity>()
		);
		return new PageUtils(page);
	}

	@Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<TijiantaocanEntity> wrapper) {
		Page<TijiantaocanView> page = new Query<TijiantaocanView>(params).getPage();
		page.setRecords(baseMapper.selectListView(page, wrapper));
		return new PageUtils(page);
	}

	@Override
	public List<TijiantaocanVO> selectListVO(Wrapper<TijiantaocanEntity> wrapper) {
		return baseMapper.selectListVO(wrapper);
	}

	@Override
	public TijiantaocanVO selectVO(Wrapper<TijiantaocanEntity> wrapper) {
		return baseMapper.selectVO(wrapper);
	}

	@Override
	public List<TijiantaocanView> selectListView(Wrapper<TijiantaocanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public TijiantaocanView selectView(Wrapper<TijiantaocanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

	// ✅ 名额相关业务实现

	@Override
	public Integer getRemainingReserveCount(Long packageId) {
		return baseMapper.getRemainingReserveCount(packageId);
	}

	@Override
	public Integer getMaxReserveCount(Long packageId) {
		return baseMapper.getMaxReserveCount(packageId);
	}

	@Override
	@Transactional
	public boolean decreaseReserveCount(Long packageId) {
		Integer remaining = baseMapper.getRemainingReserveCount(packageId);
		if (remaining != null && remaining > 0) {
			int updated = baseMapper.updateRemainingReserveCount(packageId, -1);
			return updated > 0;
		}
		return false;
	}

	@Override
	@Transactional
	public boolean increaseReserveCount(Long packageId) {
		int updated = baseMapper.updateRemainingReserveCount(packageId, 1);
		return updated > 0;
	}
}
