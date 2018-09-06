package com.highliving.pojo;

import java.util.Date;

public class News {
    private Integer newsid;//新闻编号

    private Integer userid;//用户编号

    private Date newscreatetime;//新闻创建时间

    private String newstitle;//新闻标题

    private String newspicpath;//新闻图片

    private String newsinfo;//新闻内容

    public Integer getNewsid() {
        return newsid;
    }

    public void setNewsid(Integer newsid) {
        this.newsid = newsid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Date getNewscreatetime() {
        return newscreatetime;
    }

    public void setNewscreatetime(Date newscreatetime) {
        this.newscreatetime = newscreatetime;
    }

    public String getNewstitle() {
        return newstitle;
    }

    public void setNewstitle(String newstitle) {
        this.newstitle = newstitle == null ? null : newstitle.trim();
    }

    public String getNewspicpath() {
        return newspicpath;
    }

    public void setNewspicpath(String newspicpath) {
        this.newspicpath = newspicpath == null ? null : newspicpath.trim();
    }

    public String getNewsinfo() {
        return newsinfo;
    }

    public void setNewsinfo(String newsinfo) {
        this.newsinfo = newsinfo == null ? null : newsinfo.trim();
    }
}