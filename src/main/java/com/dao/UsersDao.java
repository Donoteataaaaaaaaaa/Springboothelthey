package com.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.UsersEntity;

/**
 * 用户 DAO 接口
 */
public interface UsersDao extends BaseMapper<UsersEntity> {

	List<UsersEntity> selectListView(@Param("ew") Wrapper<UsersEntity> wrapper);

	List<UsersEntity> selectListView(Pagination page, @Param("ew") Wrapper<UsersEntity> wrapper);

	// ✅ 新增方法

	/**
	 * 更新用户状态（如：启用/禁用）
	 * @param userId 用户ID
	 * @param status 状态值
	 * @return 更新记录数
	 */
	int updateUserStatus(@Param("userId") Long userId, @Param("status") String status);

	/**
	 * 批量更新用户提醒标记
	 * @param userIds 用户ID列表
	 * @return 更新记录数
	 */
	int batchUpdateRemindFlag(@Param("userIds") List<Long> userIds);

	/**
	 * 查询需要发送提醒的用户
	 * @return 用户列表
	 */
	List<UsersEntity> selectUsersToRemind();
}
