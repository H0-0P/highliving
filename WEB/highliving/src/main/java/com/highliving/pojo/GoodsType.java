package com.highliving.pojo;

import java.util.List;

public class GoodsType {
    private Integer goodtypeid;

    private String goodtypename;

    private Integer parent;

    private Integer haschildren;
   
    public List<GoodsType> goodsType;
    
	public List<GoodsType> getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(List<GoodsType> goodsType) {
		this.goodsType = goodsType;
	}

	public Integer getGoodtypeid() {
        return goodtypeid;
    }

    public void setGoodtypeid(Integer goodtypeid) {
        this.goodtypeid = goodtypeid;
    }

    public String getGoodtypename() {
        return goodtypename;
    }

    public void setGoodtypename(String goodtypename) {
        this.goodtypename = goodtypename == null ? null : goodtypename.trim();
    }

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    public Integer getHaschildren() {
        return haschildren;
    }

    public void setHaschildren(Integer haschildren) {
        this.haschildren = haschildren;
    }

	@Override
	public String toString() {
		return "GoodsType [goodtypeid=" + goodtypeid + ", goodtypename=" + goodtypename + ", parent=" + parent
				+ ", haschildren=" + haschildren + ", goodsType=" + goodsType + "]";
	}
}