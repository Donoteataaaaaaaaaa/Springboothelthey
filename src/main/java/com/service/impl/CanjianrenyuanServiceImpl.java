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


import com.dao.CanjianrenyuanDao;
import com.entity.CanjianrenyuanEntity;
import com.service.CanjianrenyuanService;
import com.entity.vo.CanjianrenyuanVO;
import com.entity.view.CanjianrenyuanView;

@Service("canjianrenyuanService")
public class CanjianrenyuanServiceImpl extends ServiceImpl<CanjianrenyuanDao, CanjianrenyuanEntity> implements CanjianrenyuanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CanjianrenyuanEntity> page = this.selectPage(
                new Query<CanjianrenyuanEntity>(params).getPage(),
                new EntityWrapper<CanjianrenyuanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<CanjianrenyuanEntity> wrapper) {
		  Page<CanjianrenyuanView> page =new Query<CanjianrenyuanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<CanjianrenyuanVO> selectListVO(Wrapper<CanjianrenyuanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public CanjianrenyuanVO selectVO(Wrapper<CanjianrenyuanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<CanjianrenyuanView> selectListView(Wrapper<CanjianrenyuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public CanjianrenyuanView selectView(Wrapper<CanjianrenyuanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
