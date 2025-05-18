package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.TijianyishiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.TijianyishiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.TijianyishiView;


/**
 * 体检医师
 *
 * @author 
 * @email 
 * 
 */
public interface TijianyishiService extends IService<TijianyishiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<TijianyishiVO> selectListVO(Wrapper<TijianyishiEntity> wrapper);
   	
   	TijianyishiVO selectVO(@Param("ew") Wrapper<TijianyishiEntity> wrapper);
   	
   	List<TijianyishiView> selectListView(Wrapper<TijianyishiEntity> wrapper);
   	
   	TijianyishiView selectView(@Param("ew") Wrapper<TijianyishiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<TijianyishiEntity> wrapper);
   	

}

