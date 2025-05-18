package com.dao;

import com.entity.TijianyuyueEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.TijianyuyueVO;
import com.entity.view.TijianyuyueView;

/**
 * 体检预约 DAO 接口
 *
 * @author
 */
public interface TijianyuyueDao extends BaseMapper<TijianyuyueEntity> {

	// 已有查询方法
	List<TijianyuyueVO> selectListVO(@Param("ew") Wrapper<TijianyuyueEntity> wrapper);
	TijianyuyueVO selectVO(@Param("ew") Wrapper<TijianyuyueEntity> wrapper);
	List<TijianyuyueView> selectListView(@Param("ew") Wrapper<TijianyuyueEntity> wrapper);
	List<TijianyuyueView> selectListView(Pagination page, @Param("ew") Wrapper<TijianyuyueEntity> wrapper);
	TijianyuyueView selectView(@Param("ew") Wrapper<TijianyuyueEntity> wrapper);

	// ✅ 新增业务方法

	/**
	 * 检查预约时间冲突
	 * @param userId 用户ID
	 * @param appointmentDate 预约日期
	 * @param timeslot 预约时间段
	 * @return 冲突记录数量
	 */
	int checkTimeConflict(@Param("userId") Long userId,
						  @Param("appointmentDate") String appointmentDate,
						  @Param("timeslot") String timeslot);

	/**
	 * 查询需要提醒的预约记录
	 * @return 预约提醒列表
	 */
	List<TijianyuyueEntity> selectRemindList();

	/**
	 * 批量更新提醒标记
	 * @param ids 预约ID列表
	 * @return 更新记录数
	 */
	int batchUpdateRemindFlag(@Param("ids") List<Long> ids);
}
