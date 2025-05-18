package com.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.UsersEntity;
import com.utils.PageUtils;

/**
 * 系统用户 Service 接口
 */
public interface UsersService extends IService<UsersEntity> {

	PageUtils queryPage(Map<String, Object> params);

	List<UsersEntity> selectListView(Wrapper<UsersEntity> wrapper);

	PageUtils queryPage(Map<String, Object> params, Wrapper<UsersEntity> wrapper);

	// ✅ 新增业务方法

	/**
	 * 批量更新用户提醒标记
	 * @param ids 用户ID列表
	 * @return 更新记录数
	 */
	int batchUpdateRemindFlag(List<Long> ids);

	/**
	 * 根据用户ID更新状态
	 * @param userId 用户ID
	 * @param status 新状态
	 * @return 是否成功
	 */
	boolean updateUserStatus(Long userId, String status);

	/**
	 * 查询需要发送提醒的用户列表
	 * @return 用户列表
	 */
	List<UsersEntity> getUsersToRemind();
}
