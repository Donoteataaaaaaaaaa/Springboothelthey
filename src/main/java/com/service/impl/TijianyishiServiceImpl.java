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


import com.dao.TijianyishiDao;
import com.entity.TijianyishiEntity;
import com.service.TijianyishiService;
import com.entity.vo.TijianyishiVO;
import com.entity.view.TijianyishiView;

@Service("tijianyishiService")
public class TijianyishiServiceImpl extends ServiceImpl<TijianyishiDao, TijianyishiEntity> implements TijianyishiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TijianyishiEntity> page = this.selectPage(
                new Query<TijianyishiEntity>(params).getPage(),
                new EntityWrapper<TijianyishiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<TijianyishiEntity> wrapper) {
		  Page<TijianyishiView> page =new Query<TijianyishiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<TijianyishiVO> selectListVO(Wrapper<TijianyishiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public TijianyishiVO selectVO(Wrapper<TijianyishiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<TijianyishiView> selectListView(Wrapper<TijianyishiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public TijianyishiView selectView(Wrapper<TijianyishiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
