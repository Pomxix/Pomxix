package com.yc.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yc.bean.Favorite;
import com.yc.bean.Tag;
import com.yc.biz.FavoriteBiz;
import com.yc.dao.FavoriteDao;
import com.yc.dao.TagDao;
import com.yc.dao.impl.FavoriteDaoImpl;
import com.yc.dao.impl.TagDaoImpl;

public class FavoriteBizImpl implements FavoriteBiz {
	
	private FavoriteDao fd=new FavoriteDaoImpl();
	private TagDao td=new TagDaoImpl();
	
	private Tag selectTagByName( String tname  ){
		Tag t=new Tag();
		t.setTname(   tname);
		List<Tag> list=td.selectTag( t  );
		if(list!=null&&list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	}

	@Override
	public void addFavorite(Favorite fav) {
		fd.addFavorite(  fav  );  // 1. 得到  fid
		
		String ftags=fav.getFtags();
		
		if(  ftags!=null&&  !ftags.equals("")){
			//1. ,分隔
			String[] tags=ftags.split(",");
			for(   String t:tags){
				//查询是否有这个tag
				Tag tag=new Tag();
				//tag.setTname(t);
				tag=selectTagByName(t);   //查是否已经存在这个tag
				if( tag==null){
					//没有这个标签，，则添加一个到tag表，并添加一个中间表
					tag=new Tag();
					tag.setTname(t);
					td.addTag(tag);
				}else{
					//原来有这个标签，则加数量即可
					td.increaseCount(   tag   );
				}
				//添加中间表  
				Map<String,String> map=new HashMap<String,String>();
				map.put("tid", tag.getTid()+"");
				map.put("fid", fav.getFid()+"");
				td.addTagFavorite(map);
			}
		}
		
	}

	@Override
	public List<Tag> findAllTag() {
		Tag tag=new Tag();
		return td.selectTag(tag);
	}

	@Override
	public List<Favorite> findFavorite(String condition) {
		Favorite f=new Favorite();
		if(  condition.equals("全部")){
			f.setFtags("");
			return fd.selectFavoriteAll(f);
		}else if(  condition.equals("未分类")){
			f.setFtags(null);
			return fd.selectFavoriteAll(f);
		}else{
			TagDao td=new TagDaoImpl();
			Tag t=new Tag();
			t.setTname(  condition );
			return td.selectFavoriteByTname(t);
		}
		
	}

}
