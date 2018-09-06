package com.highliving.pojo;

import java.util.Date;

public class UserInfo {
    private Integer userid;//用户Id

    private Integer usertype;//用户类型

    private String loginname;//登录名

    private String password;//密码

    private String username;//昵称

    private String phone;//电话

    private Date createtime;//创建时间

    private Integer score;//积分

    private Boolean isvalid;//是否有效

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getUsertype() {
        return usertype;
    }

    public void setUsertype(Integer usertype) {
        this.usertype = usertype;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname == null ? null : loginname.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Boolean getIsvalid() {
        return isvalid;
    }

    public void setIsvalid(Boolean isvalid) {
        this.isvalid = isvalid;
    }

	@Override
	public String toString() {
		return "UserInfo [userid=" + userid + ", usertype=" + usertype + ", loginname=" + loginname + ", password="
				+ password + ", username=" + username + ", phone=" + phone + ", createtime=" + createtime + ", score="
				+ score + ", isvalid=" + isvalid + "]";
	}
    
}