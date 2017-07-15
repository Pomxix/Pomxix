package com.yc.biz;

import java.util.List;

import com.yc.bean.Favorite;
import com.yc.bean.Tag;

public interface FavoriteBiz {
	
	/**
	 * -> TODO:  所有的这些操作要在一个事务中  (要采用spring的事务处理机制  )  <br/>
	 * 从fav中取出ftags(门户,军事), 根据,分隔，取出每个标签.   ["门户","军事"] <br/>
	 * 循环查是否有 门户,是否有军事<br/>
	 *     存在则更新这个标签数量   ->     TagMapper中的  increaseCount方法<br/>
	 *     不存在，则要向Tag中加入一条数据   ->   TagMapper中的  addTag   -> 还要在中间表加入关系的数据  ( TagMapper中的addTagFavorite  )<br/>
	 * 再向  favorite添加一条数据       FavoriteMapper的 addFav<br/>
	 * @param fav
	 */
	public void addFavorite(  Favorite fav  );
	
	
	/**
	 * 查所有的Tag,   
	 * 用于云图,   首页显示所有的tag
	 * 解决方案:  TagMapper selectTagAll
	 */
	public List<Tag> findAllTag();
	
	/**
	 * 值有  "全部","未分类", 标签值
	 * @param condition:  
	 * @return
	 */
	public List<Favorite> findFavorite(String condition);
}
