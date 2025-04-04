package com.entity.vo;

import com.entity.TijiantaocanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 体检套餐
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2023-05-18 15:35:49
 */
public class TijiantaocanVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
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
