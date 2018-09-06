package com.highliving.pojo;

public class Collections {
    private Integer collectid;

    private Integer userid;

    private String goodid;
    
    private Goods goods;

    public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public Integer getCollectid() {
        return collectid;
    }

    public void setCollectid(Integer collectid) {
        this.collectid = collectid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getGoodid() {
        return goodid;
    }

    public void setGoodid(String goodid) {
        this.goodid = goodid == null ? null : goodid.trim();
    }

	@Override
	public String toString() {
		return "Collections [collectid=" + collectid + ", userid=" + userid + ", goodid=" + goodid + ", goods=" + goods
				+ "]";
	}
    
}