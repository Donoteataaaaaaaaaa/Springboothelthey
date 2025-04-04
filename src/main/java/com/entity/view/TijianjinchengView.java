package com.entity.view;

import com.entity.TijianjinchengEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 体检进程
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-05-18 15:35:50
 */
@TableName("tijianjincheng")
public class TijianjinchengView  extends TijianjinchengEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public TijianjinchengView(){
	}
 
 	public TijianjinchengView(TijianjinchengEntity tijianjinchengEntity){
 	try {
			BeanUtils.copyProperties(this, tijianjinchengEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
