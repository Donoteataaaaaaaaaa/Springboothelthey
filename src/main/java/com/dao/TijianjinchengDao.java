package com.dao;

import com.entity.TijianjinchengEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.TijianjinchengVO;
import com.entity.view.TijianjinchengView;


/**
 * 体检进程
 * 
 * @author 
 * @email 
 * @date 2023-05-18 15:35:50
 */
public interface TijianjinchengDao extends BaseMapper<TijianjinchengEntity> {
	
	List<TijianjinchengVO> selectListVO(@Param("ew") Wrapper<TijianjinchengEntity> wrapper);
	
	TijianjinchengVO selectVO(@Param("ew") Wrapper<TijianjinchengEntity> wrapper);
	
	List<TijianjinchengView> selectListView(@Param("ew") Wrapper<TijianjinchengEntity> wrapper);

	List<TijianjinchengView> selectListView(Pagination page,@Param("ew") Wrapper<TijianjinchengEntity> wrapper);
	
	TijianjinchengView selectView(@Param("ew") Wrapper<TijianjinchengEntity> wrapper);
	

}
