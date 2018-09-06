package com.highliving.pojo;

public class TypeParamModel {
    private Integer modelid;

    private Integer goodtypeid;

    private String paramdata;

    public Integer getModelid() {
        return modelid;
    }

    public void setModelid(Integer modelid) {
        this.modelid = modelid;
    }

    public Integer getGoodtypeid() {
        return goodtypeid;
    }

    public void setGoodtypeid(Integer goodtypeid) {
        this.goodtypeid = goodtypeid;
    }

    public String getParamdata() {
        return paramdata;
    }

    public void setParamdata(String paramdata) {
        this.paramdata = paramdata == null ? null : paramdata.trim();
    }
}