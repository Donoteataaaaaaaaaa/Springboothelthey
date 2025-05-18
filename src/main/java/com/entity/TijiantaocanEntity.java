
package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 体检套餐实体类（MyBatis-Plus 2.3 兼容版）
 * 已补充最大预约人数和剩余可预约人数字段。
 */
@Data
@TableName("tijiantaocan")
public class TijiantaocanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableId(type = IdType.AUTO)
	private Long id;

	private String tijianxiangmu; // 体检项目
	private String tijiandidian;  // 体检地点
	private String tijiandanwei;  // 体检单位
	private Float taocanjiage;    // 套餐价格
	private Integer keyuerenshu;  // 可约人数
	private String tijianneirong; // 体检内容
	private String tijianliucheng; // 体检流程
	private String taocantupian;   // 套餐图片
	private String zhanghao;       // 账号
	private String xingming;       // 姓名

	@JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date clicktime;        // 最近点击时间

	@JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date addtime;          // 创建时间

	// 新增字段
	private Integer maxReserveCount;      // 最大预约人数
	private Integer remainingReserveCount; // 剩余可预约人数
}
