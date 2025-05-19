package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.TijianjinchengEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.TijianjinchengVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.TijianjinchengView;


/**
 * 体检进程
 *
 * @author 
 * @email 
 * 
 */
public interface TijianjinchengService extends IService<TijianjinchengEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<TijianjinchengVO> selectListVO(Wrapper<TijianjinchengEntity> wrapper);
   	
   	TijianjinchengVO selectVO(@Param("ew") Wrapper<TijianjinchengEntity> wrapper);
   	
   	List<TijianjinchengView> selectListView(Wrapper<TijianjinchengEntity> wrapper);
   	
   	TijianjinchengView selectView(@Param("ew") Wrapper<TijianjinchengEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<TijianjinchengEntity> wrapper);
   	

}

