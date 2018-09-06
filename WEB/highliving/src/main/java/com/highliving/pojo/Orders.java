package com.highliving.pojo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.print.attribute.standard.DateTimeAtCompleted;

public class Orders {

	private Integer orderid;//订单编号

    private Integer userid;//用户编号

    private Integer addressid;//地址编号

    private BigDecimal ordersum;//订单总价
    
    private List<OrderItems> orderitems;//订单项
    
    private Integer orderstate;//订单状态
    
    private Date ordercreatedate;//下单时间
    
    private Address address;//地址

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<OrderItems> getOrderItems() {
		return orderitems;
	}

	public void setOrderItems(List<OrderItems> orderItems) {
		this.orderitems = orderItems;
	}

	public Date getOrdercreatedate() {
		return ordercreatedate;
	}

	public void setOrdercreatedate(Date ordercreatedate) {
		this.ordercreatedate = ordercreatedate;
	}

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getAddressid() {
        return addressid;
    }

    public void setAddressid(Integer addressid) {
        this.addressid = addressid;
    }

    public BigDecimal getOrdersum() {
        return ordersum;
    }

    public void setOrdersum(BigDecimal ordersum) {
        this.ordersum = ordersum;
    }

    public Integer getOrderstate() {
        return orderstate;
    }

    public void setOrderstate(Integer orderstate) {
        this.orderstate = orderstate;
    }
    @Override
	public String toString() {
		return "Orders [orderid=" + orderid + ", userid=" + userid + ", addressid=" + addressid + ", ordersum="
				+ ordersum + ", orderitems=" + orderitems + ", orderstate=" + orderstate + ", ordercreatedate="
				+ ordercreatedate + ", address=" + address + "]";
	}
}