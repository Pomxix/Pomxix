package com.yc.biz.test;

import java.util.List;

import com.yc.bean.Favorite;
import com.yc.bean.Tag;
import com.yc.biz.FavoriteBiz;
import com.yc.biz.impl.FavoriteBizImpl;
import com.yc.dao.FavoriteDao;
import com.yc.dao.impl.FavoriteDaoImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

//100% fu盖测试
public class FavoriteBizTest extends TestCase {
	
	public FavoriteBizTest(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(FavoriteBizTest.class);
	}
	
	public void testAddFavorite(){
		Favorite f=new Favorite();
		f.setFdesc("good3");
		f.setFlabel("google3");
		f.setFtags("");
		f.setFurl("http://www.google3.com");
		FavoriteBiz fd=new FavoriteBizImpl();
		fd.addFavorite( f );
	}
	
	public void testFindAllTag(){
		FavoriteBiz fd=new FavoriteBizImpl();
		List<Tag> list=fd.findAllTag();
		for( Tag t:list){
			System.out.println(  t);
		}
	}
	
	public void testFindFavorite1(){
		FavoriteBiz fd=new FavoriteBizImpl();
		List<Favorite> list=fd.findFavorite("全部");
		for( Favorite f:list){
			System.out.println(  f );
		}
	}
	
	public void testFindFavorite2(){
		FavoriteBiz fd=new FavoriteBizImpl();
		List<Favorite> list=fd.findFavorite("未分类");
		for( Favorite f:list){
			System.out.println(  f );
		}
	}
	
	public void testFindFavorite3(){
		FavoriteBiz fd=new FavoriteBizImpl();
		List<Favorite> list=fd.findFavorite("军事");
		for( Favorite f:list){
			System.out.println(  f );
		}
	}
}
