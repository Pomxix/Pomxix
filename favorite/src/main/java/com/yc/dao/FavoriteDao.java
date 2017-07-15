package com.yc.dao;

import java.util.List;

import com.yc.bean.Favorite;

public interface FavoriteDao {
	
	/**
	 * 查询链接:   查询所有/查询未分类
		 未分类  ->  f_tags=null
		 查询所有          f_tags=''
	 * @param favorite
	 * @return
	 */
	public List<Favorite> selectFavoriteAll(Favorite favorite);
	
	/**
	 * 添加链接
	 * @param favorite
	 */
	public void addFavorite ( Favorite favorite);
	
}
