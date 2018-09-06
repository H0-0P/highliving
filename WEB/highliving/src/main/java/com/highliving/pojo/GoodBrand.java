package com.highliving.pojo;

public class GoodBrand {
    private Integer brandid;

    private String brandname;

    private String brandlogopath;
    
    //根据品牌连查商品
    private Goods goods;
    
    

    public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public Integer getBrandid() {
        return brandid;
    }

    public void setBrandid(Integer brandid) {
        this.brandid = brandid;
    }

    public String getBrandname() {
        return brandname;
    }

    public void setBrandname(String brandname) {
        this.brandname = brandname == null ? null : brandname.trim();
    }

    public String getBrandlogopath() {
        return brandlogopath;
    }

    public void setBrandlogopath(String brandlogopath) {
        this.brandlogopath = brandlogopath == null ? null : brandlogopath.trim();
    }
}