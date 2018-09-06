package com.highliving.pojo;

import java.math.BigDecimal;

public class OrderItems {
    private Integer orderitemid;//订单项编号

    private String goodid;//商品编号

    private Integer orderid;//订单编号

    private Integer goodnum;//商品购买数量

    private BigDecimal orderitemsum;//订单项价格
    
    private Goods goods;

    public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public Integer getOrderitemid() {
        return orderitemid;
    }

    public void setOrderitemid(Integer orderitemid) {
        this.orderitemid = orderitemid;
    }

    public String getGoodid() {
        return goodid;
    }

    public void setGoodid(String goodid) {
        this.goodid = goodid == null ? null : goodid.trim();
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Integer getGoodnum() {
        return goodnum;
    }

    public void setGoodnum(Integer goodnum) {
        this.goodnum = goodnum;
    }

    public BigDecimal getOrderitemsum() {
        return orderitemsum;
    }

    public void setOrderitemsum(BigDecimal orderitemsum) {
        this.orderitemsum = orderitemsum;
    }

	@Override
	public String toString() {
		return "OrderItems [orderitemid=" + orderitemid + ", goodid=" + goodid + ", orderid=" + orderid + ", goodnum="
				+ goodnum + ", orderitemsum=" + orderitemsum + ", goods=" + goods + "]";
	}
}