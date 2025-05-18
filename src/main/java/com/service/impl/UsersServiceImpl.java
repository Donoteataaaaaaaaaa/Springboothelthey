package com.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.UsersDao;
import com.entity.UsersEntity;
import com.service.UsersService;
import com.utils.PageUtils;
import com.utils.Query;

@Service("usersService")
public class UsersServiceImpl extends ServiceImpl<UsersDao, UsersEntity> implements UsersService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<UsersEntity> page = this.selectPage(
				new Query<UsersEntity>(params).getPage(),
				new EntityWrapper<UsersEntity>()
		);
		return new PageUtils(page);
	}

	@Override
	public List<UsersEntity> selectListView(Wrapper<UsersEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<UsersEntity> wrapper) {
		Page<UsersEntity> page = new Query<UsersEntity>(params).getPage();
		page.setRecords(baseMapper.selectListView(page, wrapper));
		return new PageUtils(page);
	}

	// ✅ 新增业务实现

	@Override
	@Transactional
	public int batchUpdateRemindFlag(List<Long> ids) {
		if (ids == null || ids.isEmpty()) return 0;
		return baseMapper.batchUpdateRemindFlag(ids);
	}

	@Override
	@Transactional
	public boolean updateUserStatus(Long userId, String status) {
		UsersEntity user = this.selectById(userId);
		if (user == null) return false;
		user.setRole(status); // 假设使用 role 字段存储状态，如需单独字段请调整
		return this.updateById(user);
	}

	@Override
	public List<UsersEntity> getUsersToRemind() {
		return baseMapper.selectUsersToRemind();
	}
}
