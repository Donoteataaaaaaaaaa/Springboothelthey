package com.entity.view;

import com.entity.TijianyishiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 体检医师
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * 
 */
@TableName("tijianyishi")
public class TijianyishiView  extends TijianyishiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public TijianyishiView(){
	}
 
 	public TijianyishiView(TijianyishiEntity tijianyishiEntity){
 	try {
			BeanUtils.copyProperties(this, tijianyishiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
