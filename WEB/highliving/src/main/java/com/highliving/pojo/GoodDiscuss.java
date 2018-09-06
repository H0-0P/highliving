package com.highliving.pojo;

import java.util.Date;

public class GoodDiscuss {
    private Integer discussid;

    private String goodid;

    private Integer userid;

    private String discussinfo;

    private Integer score;

    private Date createtime;
    
   private UserInfo userInfo;
//    
//    private Goods goods;
//    
//
//
	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

//	public Goods getGoods() {
//		return goods;
//	}
//
//	public void setGoods(Goods goods) {
//		this.goods = goods;
//	}

	public Integer getDiscussid() {
        return discussid;
    }

    public void setDiscussid(Integer discussid) {
        this.discussid = discussid;
    }

    public String getGoodid() {
        return goodid;
    }

    public void setGoodid(String goodid) {
        this.goodid = goodid == null ? null : goodid.trim();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getDiscussinfo() {
        return discussinfo;
    }

    public void setDiscussinfo(String discussinfo) {
        this.discussinfo = discussinfo == null ? null : discussinfo.trim();
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}