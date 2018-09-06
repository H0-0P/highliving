package com.highliving.pojo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Goods {
    private String goodid;//商品号

    private Integer goodtypeid;//商品类型

    private Integer brandid;//品牌号

    private Integer userid;//用户编号

    private String goodname;//商品名称

    private BigDecimal goodprice;//商品价格

    private Boolean goodstatus;//商品状态

    private Boolean isvalid;//商品是否有效

    private Integer goodcollect;//商品收藏量

    private String defaultpic;//商品默认图片

    private Integer goodstore;//商品库存量

    private BigDecimal gooddiscount;//商品折扣

    private Date goodcreatetime;//商品创建时间
    
	private List<Pictures> pictures;//商品图片集合

	public List<Pictures> getPictures() {
		return pictures;
	}

	public void setPictures(List<Pictures> pictures) {
		this.pictures = pictures;
	}

	public String getGoodid() {
        return goodid;
    }

    public void setGoodid(String goodid) {
        this.goodid = goodid == null ? null : goodid.trim();
    }

    public Integer getGoodtypeid() {
        return goodtypeid;
    }

    public void setGoodtypeid(Integer goodtypeid) {
        this.goodtypeid = goodtypeid;
    }

    public Integer getBrandid() {
        return brandid;
    }

    public void setBrandid(Integer brandid) {
        this.brandid = brandid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getGoodname() {
        return goodname;
    }

    public void setGoodname(String goodname) {
        this.goodname = goodname == null ? null : goodname.trim();
    }

    public BigDecimal getGoodprice() {
        return goodprice;
    }

    public void setGoodprice(BigDecimal goodprice) {
        this.goodprice = goodprice;
    }

    public Boolean getGoodstatus() {
        return goodstatus;
    }

    public void setGoodstatus(Boolean goodstatus) {
        this.goodstatus = goodstatus;
    }

    public Boolean getIsvalid() {
        return isvalid;
    }

    public void setIsvalid(Boolean isvalid) {
        this.isvalid = isvalid;
    }

    public Integer getGoodcollect() {
        return goodcollect;
    }

    public void setGoodcollect(Integer goodcollect) {
        this.goodcollect = goodcollect;
    }

    public String getDefaultpic() {
        return defaultpic;
    }

    public void setDefaultpic(String defaultpic) {
        this.defaultpic = defaultpic == null ? null : defaultpic.trim();
    }

    public Integer getGoodstore() {
        return goodstore;
    }

    public void setGoodstore(Integer goodstore) {
        this.goodstore = goodstore;
    }

    public BigDecimal getGooddiscount() {
        return gooddiscount;
    }

    public void setGooddiscount(BigDecimal gooddiscount) {
        this.gooddiscount = gooddiscount;
    }

    public Date getGoodcreatetime() {
        return goodcreatetime;
    }

    public void setGoodcreatetime(Date goodcreatetime) {
        this.goodcreatetime = goodcreatetime;
    }

	@Override
	public String toString() {
		return "Goods [goodid=" + goodid + ", goodtypeid=" + goodtypeid + ", brandid=" + brandid + ", userid=" + userid
				+ ", goodname=" + goodname + ", goodprice=" + goodprice + ", goodstatus=" + goodstatus + ", isvalid="
				+ isvalid + ", goodcollect=" + goodcollect + ", defaultpic=" + defaultpic + ", goodstore=" + goodstore
				+ ", gooddiscount=" + gooddiscount + ", goodcreatetime=" + goodcreatetime + ", pictures=" + pictures
				+ "]";
	}
    
}