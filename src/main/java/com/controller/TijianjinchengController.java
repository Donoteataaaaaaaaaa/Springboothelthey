package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.TijianjinchengEntity;
import com.entity.view.TijianjinchengView;

import com.service.TijianjinchengService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 体检进程
 * 后端接口
 * @author 
 * @email 
 * @date 2023-05-18 15:35:50
 */
@RestController
@RequestMapping("/tijianjincheng")
public class TijianjinchengController {
    @Autowired
    private TijianjinchengService tijianjinchengService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,TijianjinchengEntity tijianjincheng,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("canjianrenyuan")) {
			tijianjincheng.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("tijianyishi")) {
			tijianjincheng.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<TijianjinchengEntity> ew = new EntityWrapper<TijianjinchengEntity>();

		PageUtils page = tijianjinchengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tijianjincheng), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,TijianjinchengEntity tijianjincheng, 
		HttpServletRequest request){
        EntityWrapper<TijianjinchengEntity> ew = new EntityWrapper<TijianjinchengEntity>();

		PageUtils page = tijianjinchengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tijianjincheng), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( TijianjinchengEntity tijianjincheng){
       	EntityWrapper<TijianjinchengEntity> ew = new EntityWrapper<TijianjinchengEntity>();
      	ew.allEq(MPUtil.allEQMapPre( tijianjincheng, "tijianjincheng")); 
        return R.ok().put("data", tijianjinchengService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(TijianjinchengEntity tijianjincheng){
        EntityWrapper< TijianjinchengEntity> ew = new EntityWrapper< TijianjinchengEntity>();
 		ew.allEq(MPUtil.allEQMapPre( tijianjincheng, "tijianjincheng")); 
		TijianjinchengView tijianjinchengView =  tijianjinchengService.selectView(ew);
		return R.ok("查询体检进程成功").put("data", tijianjinchengView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        TijianjinchengEntity tijianjincheng = tijianjinchengService.selectById(id);
        return R.ok().put("data", tijianjincheng);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        TijianjinchengEntity tijianjincheng = tijianjinchengService.selectById(id);
        return R.ok().put("data", tijianjincheng);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody TijianjinchengEntity tijianjincheng, HttpServletRequest request){
    	tijianjincheng.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(tijianjincheng);
        tijianjinchengService.insert(tijianjincheng);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody TijianjinchengEntity tijianjincheng, HttpServletRequest request){
    	tijianjincheng.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(tijianjincheng);
        tijianjinchengService.insert(tijianjincheng);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody TijianjinchengEntity tijianjincheng, HttpServletRequest request){
        //ValidatorUtils.validateEntity(tijianjincheng);
        tijianjinchengService.updateById(tijianjincheng);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        tijianjinchengService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
