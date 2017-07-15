package com.yc.dao;

import java.util.List;
import java.util.Map;

import com.yc.bean.Favorite;
import com.yc.bean.Tag;

public interface TagDao {
	
	/**
	 * 查询标签
	 * @return
	 */
	public List<Tag> selectTag(   Tag tag);
	
	/**
	 * 根据标签名查这个标签下所有的favorite
	 * @param tag
	 * @return
	 */
	public List<Favorite> selectFavoriteByTname(    Tag tag);
	
	
	
	public void addTag( Tag tag);
	
	public void increaseCount( Tag tag);
	/**
	 * 中间关系表
	 * @param map
	 */
	public void addTagFavorite(  Map<String,String> map);
	
	
}
