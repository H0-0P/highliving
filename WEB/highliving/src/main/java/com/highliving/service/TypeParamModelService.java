package com.highliving.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.highliving.common.EUDataGridResult;
import com.highliving.common.TaotaoResult;
import com.highliving.dao.GoodsTypeMapper;
import com.highliving.dao.TypeParamModelMapper;
import com.highliving.pojo.GoodsType;
import com.highliving.pojo.ParamAndType;
import com.highliving.pojo.TypeParamModel;

@Service
public class TypeParamModelService {
	
	@Autowired
	private TypeParamModelMapper typeParamModelMapper;	
	
	@Autowired
	private GoodsTypeMapper goodsTypeMapper;
	/*
	 * 根据goodTypeId查
	 */
	public TypeParamModel findParamByTypeId(Integer goodTypeId) {
		return typeParamModelMapper.findParamByTypeId(goodTypeId);
	}
	
	/*
	 * 根据goodTypeId改
	 */
	public void updateParamByTypeId(TypeParamModel typeParamModel) {
		typeParamModelMapper.updateByTypeId(typeParamModel);
	}
	
	public TypeParamModel findById(Integer modelId) {
		return typeParamModelMapper.selectByPrimaryKey(modelId);
	}
	
	public TaotaoResult getItemParamByCid(Integer goodTypeId) {
		TypeParamModel typeParamModel = typeParamModelMapper.findParamByTypeId(goodTypeId);
		
		return TaotaoResult.ok(typeParamModel);
	}
	public TaotaoResult InsertTypeParam(TypeParamModel typeParamModel) {
		typeParamModelMapper.insert(typeParamModel);
		return TaotaoResult.ok();
	}
	 public EUDataGridResult findAllTypeParam(Integer page, Integer rows) {
		//分页处理
		PageHelper.startPage(page, rows);
		List<TypeParamModel> list = typeParamModelMapper.selectAll();
		List<ParamAndType> list2 = new ArrayList<ParamAndType>();
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		for(int i = 0; i < list.size(); i++) {	
			//类别编号
			ParamAndType paramAndType = new ParamAndType();
			paramAndType.setModelid(list.get(i).getModelid());
			//
			 int typeId = list.get(i).getGoodtypeid();
			 paramAndType.setGoodtypeid(typeId);
			//类别名称
			 GoodsType type = goodsTypeMapper.selectByPrimaryKey(typeId);
			 paramAndType.setGoodname(type.getGoodtypename());
			 //param
			 String paramData = list.get(i).getParamdata();
			 paramAndType.setParamdata(paramData);
			 list2.add(paramAndType);
		}
		result.setRows(list2);
		//取记录总条数
		PageInfo<TypeParamModel> pageInfo = new PageInfo<TypeParamModel>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
	public int deleteParams(Integer modelid) {
		return typeParamModelMapper.deleteByPrimaryKey(modelid);		
	}
	
}
