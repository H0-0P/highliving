package com.highliving.pojo;

public class ParamAndType {
    private Integer modelid;

    private Integer goodtypeid;
    
    private String goodname;

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


	public String getGoodname() {
		return goodname;
	}


	public void setGoodname(String goodname) {
		this.goodname = goodname;
	}


	public String getParamdata() {
		return paramdata;
	}


	public void setParamdata(String paramdata) {
		this.paramdata = paramdata;
	}


	@Override
	public String toString() {
		return "ParamAndType [modelid=" + modelid + ", goodtypeid=" + goodtypeid + ", goodname=" + goodname
				+ ", paramdata=" + paramdata + "]";
	}
    
}
