package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.TijianyuyueEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.TijianyuyueVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.TijianyuyueView;

/**
 * 体检预约 Service 接口
 */
public interface TijianyuyueService extends IService<TijianyuyueEntity> {

	PageUtils queryPage(Map<String, Object> params);

	List<TijianyuyueVO> selectListVO(Wrapper<TijianyuyueEntity> wrapper);

	TijianyuyueVO selectVO(@Param("ew") Wrapper<TijianyuyueEntity> wrapper);

	List<TijianyuyueView> selectListView(Wrapper<TijianyuyueEntity> wrapper);

	TijianyuyueView selectView(@Param("ew") Wrapper<TijianyuyueEntity> wrapper);

	PageUtils queryPage(Map<String, Object> params, Wrapper<TijianyuyueEntity> wrapper);

	// ✅ 新增业务方法

	/**
	 * 提交预约
	 * @param entity 预约信息实体
	 * @return 是否成功
	 */
	boolean submitAppointment(TijianyuyueEntity entity);

	/**
	 * 取消预约
	 * @param appointmentId 预约ID
	 * @return 是否成功
	 */
	boolean cancelAppointment(Long appointmentId);

	/**
	 * 检查预约时间冲突
	 * @param userId 用户ID
	 * @param appointmentDate 预约日期
	 * @param timeslot 时间段
	 * @return 是否存在冲突
	 */
	boolean checkTimeConflict(Long userId, String appointmentDate, String timeslot);

	/**
	 * 查询需要提醒的预约记录
	 * @return 需要提醒的预约列表
	 */
	List<TijianyuyueEntity> getRemindAppointments();

	/**
	 * 批量更新提醒标记
	 * @param ids 预约ID列表
	 * @return 更新成功的记录数
	 */
	int batchUpdateRemindFlag(List<Long> ids);
}
