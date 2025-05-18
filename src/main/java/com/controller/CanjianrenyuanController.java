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

import com.entity.CanjianrenyuanEntity;
import com.entity.view.CanjianrenyuanView;

import com.service.CanjianrenyuanService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 参检人员
 * 后端接口
 * @author 
 * @email 
 * 
 */
@RestController
@RequestMapping("/canjianrenyuan")
public class CanjianrenyuanController {
    @Autowired
    private CanjianrenyuanService canjianrenyuanService;


    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		CanjianrenyuanEntity u = canjianrenyuanService.selectOne(new EntityWrapper<CanjianrenyuanEntity>().eq("yonghuzhanghao", username));
		if(u==null || !u.getMima().equals(password)) {
			return R.error("账号或密码不正确");
		}
		
		String token = tokenService.generateToken(u.getId(), username,"canjianrenyuan",  "参检人员" );
		return R.ok().put("token", token);
	}

	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody CanjianrenyuanEntity canjianrenyuan){
    	//ValidatorUtils.validateEntity(canjianrenyuan);
    	CanjianrenyuanEntity u = canjianrenyuanService.selectOne(new EntityWrapper<CanjianrenyuanEntity>().eq("yonghuzhanghao", canjianrenyuan.getYonghuzhanghao()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		canjianrenyuan.setId(uId);
        canjianrenyuanService.insert(canjianrenyuan);
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
        CanjianrenyuanEntity u = canjianrenyuanService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	CanjianrenyuanEntity u = canjianrenyuanService.selectOne(new EntityWrapper<CanjianrenyuanEntity>().eq("yonghuzhanghao", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        u.setMima("123456");
        canjianrenyuanService.updateById(u);
        return R.ok("密码已重置为：123456");
    }


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,CanjianrenyuanEntity canjianrenyuan,
		HttpServletRequest request){
        EntityWrapper<CanjianrenyuanEntity> ew = new EntityWrapper<CanjianrenyuanEntity>();

		PageUtils page = canjianrenyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, canjianrenyuan), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,CanjianrenyuanEntity canjianrenyuan, 
		HttpServletRequest request){
        EntityWrapper<CanjianrenyuanEntity> ew = new EntityWrapper<CanjianrenyuanEntity>();

		PageUtils page = canjianrenyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, canjianrenyuan), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( CanjianrenyuanEntity canjianrenyuan){
       	EntityWrapper<CanjianrenyuanEntity> ew = new EntityWrapper<CanjianrenyuanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( canjianrenyuan, "canjianrenyuan")); 
        return R.ok().put("data", canjianrenyuanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(CanjianrenyuanEntity canjianrenyuan){
        EntityWrapper< CanjianrenyuanEntity> ew = new EntityWrapper< CanjianrenyuanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( canjianrenyuan, "canjianrenyuan")); 
		CanjianrenyuanView canjianrenyuanView =  canjianrenyuanService.selectView(ew);
		return R.ok("查询参检人员成功").put("data", canjianrenyuanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        CanjianrenyuanEntity canjianrenyuan = canjianrenyuanService.selectById(id);
        return R.ok().put("data", canjianrenyuan);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        CanjianrenyuanEntity canjianrenyuan = canjianrenyuanService.selectById(id);
        return R.ok().put("data", canjianrenyuan);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CanjianrenyuanEntity canjianrenyuan, HttpServletRequest request){
    	canjianrenyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(canjianrenyuan);
    	CanjianrenyuanEntity u = canjianrenyuanService.selectOne(new EntityWrapper<CanjianrenyuanEntity>().eq("yonghuzhanghao", canjianrenyuan.getYonghuzhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		canjianrenyuan.setId(new Date().getTime());
        canjianrenyuanService.insert(canjianrenyuan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody CanjianrenyuanEntity canjianrenyuan, HttpServletRequest request){
    	canjianrenyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(canjianrenyuan);
    	CanjianrenyuanEntity u = canjianrenyuanService.selectOne(new EntityWrapper<CanjianrenyuanEntity>().eq("yonghuzhanghao", canjianrenyuan.getYonghuzhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		canjianrenyuan.setId(new Date().getTime());
        canjianrenyuanService.insert(canjianrenyuan);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody CanjianrenyuanEntity canjianrenyuan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(canjianrenyuan);
        canjianrenyuanService.updateById(canjianrenyuan);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        canjianrenyuanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
