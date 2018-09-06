package com.highliving.pojo;

public class ItemParams {
    private Integer itemid;

    private String itemparams;

    public Integer getItemid() {
        return itemid;
    }

    public void setItemid(Integer itemid) {
        this.itemid = itemid;
    }

    public String getItemparams() {
        return itemparams;
    }

    public void setItemparams(String itemparams) {
        this.itemparams = itemparams == null ? null : itemparams.trim();
    }
}