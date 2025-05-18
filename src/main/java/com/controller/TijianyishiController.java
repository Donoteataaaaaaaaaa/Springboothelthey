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

import com.entity.TijianyishiEntity;
import com.entity.view.TijianyishiView;

import com.service.TijianyishiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 体检医师
 * 后端接口
 * @author 
 * @email 
 * 
 */
@RestController
@RequestMapping("/tijianyishi")
public class TijianyishiController {
    @Autowired
    private TijianyishiService tijianyishiService;


    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		TijianyishiEntity u = tijianyishiService.selectOne(new EntityWrapper<TijianyishiEntity>().eq("zhanghao", username));
		if(u==null || !u.getMima().equals(password)) {
			return R.error("账号或密码不正确");
		}
		
		String token = tokenService.generateToken(u.getId(), username,"tijianyishi",  "体检医师" );
		return R.ok().put("token", token);
	}

	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody TijianyishiEntity tijianyishi){
    	//ValidatorUtils.validateEntity(tijianyishi);
    	TijianyishiEntity u = tijianyishiService.selectOne(new EntityWrapper<TijianyishiEntity>().eq("zhanghao", tijianyishi.getZhanghao()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		tijianyishi.setId(uId);
        tijianyishiService.insert(tijianyishi);
        return R.ok();
    }

	
	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        TijianyishiEntity u = tijianyishiService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	TijianyishiEntity u = tijianyishiService.selectOne(new EntityWrapper<TijianyishiEntity>().eq("zhanghao", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        u.setMima("123456");
        tijianyishiService.updateById(u);
        return R.ok("密码已重置为：123456");
    }


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,TijianyishiEntity tijianyishi,
		HttpServletRequest request){
        EntityWrapper<TijianyishiEntity> ew = new EntityWrapper<TijianyishiEntity>();

		PageUtils page = tijianyishiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tijianyishi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,TijianyishiEntity tijianyishi, 
		HttpServletRequest request){
        EntityWrapper<TijianyishiEntity> ew = new EntityWrapper<TijianyishiEntity>();

		PageUtils page = tijianyishiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tijianyishi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( TijianyishiEntity tijianyishi){
       	EntityWrapper<TijianyishiEntity> ew = new EntityWrapper<TijianyishiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( tijianyishi, "tijianyishi")); 
        return R.ok().put("data", tijianyishiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(TijianyishiEntity tijianyishi){
        EntityWrapper< TijianyishiEntity> ew = new EntityWrapper< TijianyishiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( tijianyishi, "tijianyishi")); 
		TijianyishiView tijianyishiView =  tijianyishiService.selectView(ew);
		return R.ok("查询体检医师成功").put("data", tijianyishiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        TijianyishiEntity tijianyishi = tijianyishiService.selectById(id);
        return R.ok().put("data", tijianyishi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        TijianyishiEntity tijianyishi = tijianyishiService.selectById(id);
        return R.ok().put("data", tijianyishi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody TijianyishiEntity tijianyishi, HttpServletRequest request){
    	tijianyishi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(tijianyishi);
    	TijianyishiEntity u = tijianyishiService.selectOne(new EntityWrapper<TijianyishiEntity>().eq("zhanghao", tijianyishi.getZhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		tijianyishi.setId(new Date().getTime());
        tijianyishiService.insert(tijianyishi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody TijianyishiEntity tijianyishi, HttpServletRequest request){
    	tijianyishi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(tijianyishi);
    	TijianyishiEntity u = tijianyishiService.selectOne(new EntityWrapper<TijianyishiEntity>().eq("zhanghao", tijianyishi.getZhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		tijianyishi.setId(new Date().getTime());
        tijianyishiService.insert(tijianyishi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody TijianyishiEntity tijianyishi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(tijianyishi);
        tijianyishiService.updateById(tijianyishi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        tijianyishiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
