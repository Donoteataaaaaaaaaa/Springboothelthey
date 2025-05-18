package com.dao;

import com.entity.TijiantaocanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.TijiantaocanVO;
import com.entity.view.TijiantaocanView;

/**
 * 体检套餐 DAO 接口
 *
 */
public interface TijiantaocanDao extends BaseMapper<TijiantaocanEntity> {

	// 已有基础查询方法
	List<TijiantaocanVO> selectListVO(@Param("ew") Wrapper<TijiantaocanEntity> wrapper);
	TijiantaocanVO selectVO(@Param("ew") Wrapper<TijiantaocanEntity> wrapper);
	List<TijiantaocanView> selectListView(@Param("ew") Wrapper<TijiantaocanEntity> wrapper);
	List<TijiantaocanView> selectListView(Pagination page, @Param("ew") Wrapper<TijiantaocanEntity> wrapper);
	TijiantaocanView selectView(@Param("ew") Wrapper<TijiantaocanEntity> wrapper);

	// ✅ 新增方法

	/**
	 * 获取套餐剩余可预约人数
	 * @param packageId 套餐ID
	 * @return 剩余人数
	 */
	Integer getRemainingReserveCount(@Param("packageId") Long packageId);

	/**
	 * 获取套餐最大可预约人数
	 * @param packageId 套餐ID
	 * @return 最大预约人数
	 */
	Integer getMaxReserveCount(@Param("packageId") Long packageId);
}
