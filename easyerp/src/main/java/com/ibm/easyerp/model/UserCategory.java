package com.ibm.easyerp.model;

import com.ibm.easyerp.base.BaseVo;

public class UserCategory extends BaseVo {
	
	private Ucategory category; 
	
    public Ucategory getCategory() {
		return category;
	}

	public void setCategory(Ucategory category) {
		this.category = category;
	}

	private Integer id;

    private Integer uid;

    private Integer cid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }
}