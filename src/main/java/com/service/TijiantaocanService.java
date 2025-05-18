package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.TijiantaocanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.TijiantaocanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.TijiantaocanView;

/**
 * 体检套餐 Service 接口
 */
public interface TijiantaocanService extends IService<TijiantaocanEntity> {

	PageUtils queryPage(Map<String, Object> params);

	List<TijiantaocanVO> selectListVO(Wrapper<TijiantaocanEntity> wrapper);

	TijiantaocanVO selectVO(@Param("ew") Wrapper<TijiantaocanEntity> wrapper);

	List<TijiantaocanView> selectListView(Wrapper<TijiantaocanEntity> wrapper);

	TijiantaocanView selectView(@Param("ew") Wrapper<TijiantaocanEntity> wrapper);

	PageUtils queryPage(Map<String, Object> params, Wrapper<TijiantaocanEntity> wrapper);

	// ✅ 新增业务方法

	/**
	 * 获取套餐剩余可预约人数
	 * @param packageId 套餐ID
	 * @return 剩余人数
	 */
	Integer getRemainingReserveCount(Long packageId);

	/**
	 * 获取套餐最大可预约人数
	 * @param packageId 套餐ID
	 * @return 最大预约人数
	 */
	Integer getMaxReserveCount(Long packageId);

	/**
	 * 扣减套餐剩余可预约人数（预约成功时调用）
	 * @param packageId 套餐ID
	 * @return 是否扣减成功
	 */
	boolean decreaseReserveCount(Long packageId);

	/**
	 * 恢复套餐剩余可预约人数（取消预约时调用）
	 * @param packageId 套餐ID
	 * @return 是否恢复成功
	 */
	boolean increaseReserveCount(Long packageId);
}
