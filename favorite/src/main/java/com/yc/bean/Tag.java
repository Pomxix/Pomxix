package com.yc.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Tag implements Serializable {

	private static final long serialVersionUID = 2776264839186532004L;
	private Integer tid;
	private String tname;
	private Integer tcount;

	//一个Tag下有多个联接，  即属于 tname为军事的联接有多个.   ->   mapper  ->    collection
	private List<Favorite> favorites = new ArrayList<Favorite>();

	public List<Favorite> getFavorites() {
		return favorites;
	}

	public void setFavorites(List<Favorite> favorites) {
		this.favorites = favorites;
	}

	@Override
	public String toString() {
		return "Tag [tid=" + tid + ", tname=" + tname + ", tcount=" + tcount + "]";
	}

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public Integer getTcount() {
		return tcount;
	}

	public void setTcount(Integer tcount) {
		this.tcount = tcount;
	}

}
