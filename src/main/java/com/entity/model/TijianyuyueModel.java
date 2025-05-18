
package com.entity.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 体检预约 Model 类（标准版）
 */
@Data
@ApiModel(value = "TijianyuyueModel", description = "体检预约模型对象")
public class TijianyuyueModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "套餐图片")
	private String taocantupian;

	@ApiModelProperty(value = "体检内容")
	private String tijianneirong;

	@ApiModelProperty(value = "体检单位")
	private String tijiandanwei;

	@ApiModelProperty(value = "套餐价格")
	private Float taocanjiage;

	@ApiModelProperty(value = "可约人数")
	private Integer keyuerenshu;

	@ApiModelProperty(value = "总金额")
	private Float zongjine;

	@ApiModelProperty(value = "体检地点")
	private String tijiandidian;

	@ApiModelProperty(value = "用户账号")
	private String yonghuzhanghao;

	@ApiModelProperty(value = "用户姓名")
	private String yonghuxingming;

	@ApiModelProperty(value = "手机号")
	private String shoujihaoma;

	@ApiModelProperty(value = "预约时间")
	@JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date yuyueshijian;

	@ApiModelProperty(value = "账号")
	private String zhanghao;

	@ApiModelProperty(value = "姓名")
	private String xingming;

	@ApiModelProperty(value = "是否审核")
	private String sfsh;

	@ApiModelProperty(value = "审核回复")
	private String shhf;

	@ApiModelProperty(value = "是否支付")
	private String ispay;

	// 新增字段
	@ApiModelProperty(value = "预约时间段，如 9-10")
	private String timeslot;

	@ApiModelProperty(value = "预约状态（已预约/已完成/已取消）")
	private String status;

	@ApiModelProperty(value = "提醒标记（0 未提醒，1 已提醒）")
	private Integer remindFlag;

	@ApiModelProperty(value = "取消时间")
	@JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date cancelTime;

	@ApiModelProperty(value = "更新时间")
	@JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updateTime;
}
