package com.dao;

import com.entity.CanjianrenyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.CanjianrenyuanVO;
import com.entity.view.CanjianrenyuanView;


/**
 * 参检人员
 * 
 * @author 
 * @email 
 * 
 */
public interface CanjianrenyuanDao extends BaseMapper<CanjianrenyuanEntity> {
	
	List<CanjianrenyuanVO> selectListVO(@Param("ew") Wrapper<CanjianrenyuanEntity> wrapper);
	
	CanjianrenyuanVO selectVO(@Param("ew") Wrapper<CanjianrenyuanEntity> wrapper);
	
	List<CanjianrenyuanView> selectListView(@Param("ew") Wrapper<CanjianrenyuanEntity> wrapper);

	List<CanjianrenyuanView> selectListView(Pagination page,@Param("ew") Wrapper<CanjianrenyuanEntity> wrapper);
	
	CanjianrenyuanView selectView(@Param("ew") Wrapper<CanjianrenyuanEntity> wrapper);
	

}
