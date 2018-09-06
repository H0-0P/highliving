package com.highliving.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.highliving.common.TreeNode;
import com.highliving.dao.GoodsTypeMapper;
import com.highliving.pojo.GoodsType;
import com.highliving.pojo.Type;
import com.highliving.pojo.TypeResult;
@Service
public class GoodsTypeService{
	@Autowired
	private GoodsTypeMapper goodsTypeMapper;
	public int deleteGoodType(Integer goodtypeid) {
		return goodsTypeMapper.deleteByPrimaryKey(goodtypeid);
	}

	public int insertGoodType(GoodsType record) {
		return goodsTypeMapper.insert(record);
	}

	public int insertGoodTypeSelective(GoodsType record) {
		return goodsTypeMapper.insertSelective(record);
	}

	public GoodsType selectGoodType(Integer goodtypeid) {
		return goodsTypeMapper.selectByPrimaryKey(goodtypeid);
	}

	public int updateGoodsTypeSelective(GoodsType record) {
		return goodsTypeMapper.updateByPrimaryKeySelective(record);
	}

	public int updateGoodsType(GoodsType record) {
		return goodsTypeMapper.updateByPrimaryKey(record);
	}
	//根据parent查类型
	public  List<GoodsType> findByParent(Integer parent) {
		return goodsTypeMapper.selectByParent(parent);
	}
	public  GoodsType findByHasChildren(Integer hasChildren) {
		return goodsTypeMapper.selectByHasChildren(hasChildren);
	}
	
//	public List<GoodsType> findGoodsById(Integer goodTypeId){
//		return goodsTypeMapper.findGoodsById(goodTypeId);
//	}
	public TypeResult findAllTypes() throws Exception{
		TypeResult result = new TypeResult();
		result.setData(getTypeList(0));
		return result;
	}
	/**
	 * 查询分类列表
	 * @param parent
	 * @return
	 */
	
	private List<?> getTypeList(Integer parent){
		List<GoodsType> list = goodsTypeMapper.selectByParent(parent);
		List resultlist = new ArrayList<>();
		int count = 0;
		for(GoodsType i:list) {
			if(i.getHaschildren()==1) {
				Type type = new Type();
				type.setName(i.getGoodtypename());
				type.setType(getTypeList(i.getGoodtypeid()));
				resultlist.add(type);
				count++;
				if(count>=10)break;
			}else {
				resultlist.add("/type.html?typeid="+i.getGoodtypeid()+"|"+i.getGoodtypename());
			}
		}
		return resultlist;
	}
	
	public List<TreeNode> getItemCatList(int parentId){
		List<GoodsType> list = goodsTypeMapper.selectByParent(parentId);
		List<TreeNode> result = new ArrayList<>();
		for (GoodsType goodsType : list) {
			TreeNode treeNode = new TreeNode(goodsType.getGoodtypeid(), goodsType.getGoodtypename(), goodsType.getHaschildren()==1?"closed":"open");
			result.add(treeNode);
		}
		return result;
	}

}
