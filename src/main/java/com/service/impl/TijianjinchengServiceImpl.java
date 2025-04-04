package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.TijianjinchengDao;
import com.entity.TijianjinchengEntity;
import com.service.TijianjinchengService;
import com.entity.vo.TijianjinchengVO;
import com.entity.view.TijianjinchengView;

@Service("tijianjinchengService")
public class TijianjinchengServiceImpl extends ServiceImpl<TijianjinchengDao, TijianjinchengEntity> implements TijianjinchengService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TijianjinchengEntity> page = this.selectPage(
                new Query<TijianjinchengEntity>(params).getPage(),
                new EntityWrapper<TijianjinchengEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<TijianjinchengEntity> wrapper) {
		  Page<TijianjinchengView> page =new Query<TijianjinchengView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<TijianjinchengVO> selectListVO(Wrapper<TijianjinchengEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public TijianjinchengVO selectVO(Wrapper<TijianjinchengEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<TijianjinchengView> selectListView(Wrapper<TijianjinchengEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public TijianjinchengView selectView(Wrapper<TijianjinchengEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
