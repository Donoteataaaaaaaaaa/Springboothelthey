package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.CanjianrenyuanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.CanjianrenyuanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.CanjianrenyuanView;


/**
 * 参检人员
 *
 * @author 
 * @email 
 * @date 2023-05-18 15:35:49
 */
public interface CanjianrenyuanService extends IService<CanjianrenyuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<CanjianrenyuanVO> selectListVO(Wrapper<CanjianrenyuanEntity> wrapper);
   	
   	CanjianrenyuanVO selectVO(@Param("ew") Wrapper<CanjianrenyuanEntity> wrapper);
   	
   	List<CanjianrenyuanView> selectListView(Wrapper<CanjianrenyuanEntity> wrapper);
   	
   	CanjianrenyuanView selectView(@Param("ew") Wrapper<CanjianrenyuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<CanjianrenyuanEntity> wrapper);
   	

}

