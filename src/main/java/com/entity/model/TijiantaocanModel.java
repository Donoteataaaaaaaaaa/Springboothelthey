
package com.entity.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 体检套餐 Model 类（标准版）
 */
@Data
@ApiModel(value = "TijiantaocanModel", description = "体检套餐模型对象")
public class TijiantaocanModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "体检项目")
	private String tijianxiangmu;

	@ApiModelProperty(value = "体检地点")
	private String tijiandidian;

	@ApiModelProperty(value = "体检单位")
	private String tijiandanwei;

	@ApiModelProperty(value = "套餐价格")
	private Float taocanjiage;

	@ApiModelProperty(value = "可约人数")
	private Integer keyuerenshu;

	@ApiModelProperty(value = "体检内容")
	private String tijianneirong;

	@ApiModelProperty(value = "体检流程")
	private String tijianliucheng;

	@ApiModelProperty(value = "套餐图片")
	private String taocantupian;

	@ApiModelProperty(value = "账号")
	private String zhanghao;

	@ApiModelProperty(value = "姓名")
	private String xingming;

	@ApiModelProperty(value = "最近点击时间")
	@JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date clicktime;

	// 新增字段
	@ApiModelProperty(value = "最大预约人数")
	private Integer maxReserveCount;

	@ApiModelProperty(value = "剩余可预约人数")
	private Integer remainingReserveCount;
}
