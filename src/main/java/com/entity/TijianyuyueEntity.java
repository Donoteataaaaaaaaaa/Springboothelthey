
package com.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 体检预约实体类
 * 数据库表：tijianyuyue
 */
@Data
@TableName("tijianyuyue")
public class TijianyuyueEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableId(type = IdType.AUTO)
	private Long id;

	private String tijianxiangmu;
	private String taocantupian;
	private String tijianneirong;
	private String tijiandanwei;
	private Float taocanjiage;
	private Integer keyuerenshu;
	private Float zongjine;
	private String tijiandidian;
	private String yonghuzhanghao;
	private String yonghuxingming;
	private String shoujihaoma;

	@JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date yuyueshijian;

	private String zhanghao;
	private String xingming;
	private String sfsh;
	private String shhf;
	private String ispay;

	// 新增字段
	private String timeslot; // 预约时间段

	private String status; // 预约状态（已预约/已完成/已取消）

	private Integer remindFlag; // 提醒标记（0 未提醒，1 已提醒）

	@JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date cancelTime; // 取消时间

	@JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updateTime; // 更新时间

	@JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date addtime; // 创建时间
}
