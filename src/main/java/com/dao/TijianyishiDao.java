package com.dao;

import com.entity.TijianyishiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.TijianyishiVO;
import com.entity.view.TijianyishiView;


/**
 * 体检医师
 * 
 * @author 
 * @email 
 * @date 2023-05-18 15:35:49
 */
public interface TijianyishiDao extends BaseMapper<TijianyishiEntity> {
	
	List<TijianyishiVO> selectListVO(@Param("ew") Wrapper<TijianyishiEntity> wrapper);
	
	TijianyishiVO selectVO(@Param("ew") Wrapper<TijianyishiEntity> wrapper);
	
	List<TijianyishiView> selectListView(@Param("ew") Wrapper<TijianyishiEntity> wrapper);

	List<TijianyishiView> selectListView(Pagination page,@Param("ew") Wrapper<TijianyishiEntity> wrapper);
	
	TijianyishiView selectView(@Param("ew") Wrapper<TijianyishiEntity> wrapper);
	

}
