package com.yc.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yc.bean.Favorite;
import com.yc.dao.FavoriteDao;
import com.yc.dao.MyBatisHelper;

public class FavoriteDaoImpl implements FavoriteDao {

	@Override
	public List<Favorite> selectFavoriteAll(Favorite favorite) {
		SqlSession session = null;
		try {
			session = MyBatisHelper.getSession();
			List<Favorite> list = session.selectList(Favorite.class.getName() + ".selectFavoriteAll",favorite);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return null;
	}

	@Override
	public void addFavorite(Favorite favorite) {
		SqlSession session = null;
		try {
			session = MyBatisHelper.getSession();
			session.insert(Favorite.class.getName() + ".addFav",favorite);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

}
