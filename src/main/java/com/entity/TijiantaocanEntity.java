package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 体检套餐
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-05-18 15:35:49
 */
@TableName("tijiantaocan")
public class TijiantaocanEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public TijiantaocanEntity() {
		
	}
	
	public TijiantaocanEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 体检项目
	 */
					
	private String tijianxiangmu;
	
	/**
	 * 体检地点
	 */
					
	private String tijiandidian;
	
	/**
	 * 体检单位
	 */
					
	private String tijiandanwei;
	
	/**
	 * 套餐价格
	 */
					
	private Integer taocanjiage;
	
	/**
	 * 可约人数
	 */
					
	private Integer keyuerenshu;
	
	/**
	 * 体检内容
	 */
					
	private String tijianneirong;
	
	/**
	 * 体检流程
	 */
					
	private String tijianliucheng;
	
	/**
	 * 套餐图片
	 */
					
	private String taocantupian;
	
	/**
	 * 账号
	 */
					
	private String zhanghao;
	
	/**
	 * 姓名
	 */
					
	private String xingming;
	
	/**
	 * 最近点击时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date clicktime;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：体检项目
	 */
	public void setTijianxiangmu(String tijianxiangmu) {
		this.tijianxiangmu = tijianxiangmu;
	}
	/**
	 * 获取：体检项目
	 */
	public String getTijianxiangmu() {
		return tijianxiangmu;
	}
	/**
	 * 设置：体检地点
	 */
	public void setTijiandidian(String tijiandidian) {
		this.tijiandidian = tijiandidian;
	}
	/**
	 * 获取：体检地点
	 */
	public String getTijiandidian() {
		return tijiandidian;
	}
	/**
	 * 设置：体检单位
	 */
	public void setTijiandanwei(String tijiandanwei) {
		this.tijiandanwei = tijiandanwei;
	}
	/**
	 * 获取：体检单位
	 */
	public String getTijiandanwei() {
		return tijiandanwei;
	}
	/**
	 * 设置：套餐价格
	 */
	public void setTaocanjiage(Integer taocanjiage) {
		this.taocanjiage = taocanjiage;
	}
	/**
	 * 获取：套餐价格
	 */
	public Integer getTaocanjiage() {
		return taocanjiage;
	}
	/**
	 * 设置：可约人数
	 */
	public void setKeyuerenshu(Integer keyuerenshu) {
		this.keyuerenshu = keyuerenshu;
	}
	/**
	 * 获取：可约人数
	 */
	public Integer getKeyuerenshu() {
		return keyuerenshu;
	}
	/**
	 * 设置：体检内容
	 */
	public void setTijianneirong(String tijianneirong) {
		this.tijianneirong = tijianneirong;
	}
	/**
	 * 获取：体检内容
	 */
	public String getTijianneirong() {
		return tijianneirong;
	}
	/**
	 * 设置：体检流程
	 */
	public void setTijianliucheng(String tijianliucheng) {
		this.tijianliucheng = tijianliucheng;
	}
	/**
	 * 获取：体检流程
	 */
	public String getTijianliucheng() {
		return tijianliucheng;
	}
	/**
	 * 设置：套餐图片
	 */
	public void setTaocantupian(String taocantupian) {
		this.taocantupian = taocantupian;
	}
	/**
	 * 获取：套餐图片
	 */
	public String getTaocantupian() {
		return taocantupian;
	}
	/**
	 * 设置：账号
	 */
	public void setZhanghao(String zhanghao) {
		this.zhanghao = zhanghao;
	}
	/**
	 * 获取：账号
	 */
	public String getZhanghao() {
		return zhanghao;
	}
	/**
	 * 设置：姓名
	 */
	public void setXingming(String xingming) {
		this.xingming = xingming;
	}
	/**
	 * 获取：姓名
	 */
	public String getXingming() {
		return xingming;
	}
	/**
	 * 设置：最近点击时间
	 */
	public void setClicktime(Date clicktime) {
		this.clicktime = clicktime;
	}
	/**
	 * 获取：最近点击时间
	 */
	public Date getClicktime() {
		return clicktime;
	}

}
