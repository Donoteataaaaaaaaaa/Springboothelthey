package com.entity.view;

import com.entity.CanjianrenyuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 参检人员
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-05-18 15:35:49
 */
@TableName("canjianrenyuan")
public class CanjianrenyuanView  extends CanjianrenyuanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public CanjianrenyuanView(){
	}
 
 	public CanjianrenyuanView(CanjianrenyuanEntity canjianrenyuanEntity){
 	try {
			BeanUtils.copyProperties(this, canjianrenyuanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
