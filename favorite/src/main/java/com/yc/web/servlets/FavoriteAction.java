package com.yc.web.servlets;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.bean.Favorite;
import com.yc.bean.Tag;
import com.yc.biz.FavoriteBiz;
import com.yc.biz.impl.FavoriteBizImpl;
import com.yc.web.model.JsonModel;

@WebServlet("/favorite.action")
public class FavoriteAction extends BaseServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			if (op.equals("findAllTag")) {
				findAllTag(request, response);
			} else if (op.equals("findFavorite")) {
				findFavorite(request, response);
			} else if (op.equals("addFavorite")) {
				addFavorite(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void addFavorite(HttpServletRequest request, HttpServletResponse response) throws IOException,
			InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Favorite f = RequestUtil.getParemeter(request, Favorite.class);
		FavoriteBiz fb = new FavoriteBizImpl();
		fb.addFavorite(f);
		// 清空application中的 tag
		FavoriteBiz tb = new FavoriteBizImpl();
		List<Tag> list = tb.findAllTag();
		request.getServletContext().setAttribute("alltags", list);

		JsonModel jm = new JsonModel();
		jm.setCode(1);
		super.outJson(jm, response);
	}

	private void findAllTag(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<Tag> list = (List<Tag>) request.getServletContext().getAttribute("alltags");
		JsonModel jm = new JsonModel();
		jm.setCode(1);
		jm.setObj(list);
		super.outJson(jm, response);
	}

	private void findFavorite(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String tname = request.getParameter("tname");
		FavoriteBiz fb = new FavoriteBizImpl();
		List<Favorite> list = fb.findFavorite(tname);
		JsonModel jm = new JsonModel();
		jm.setCode(1);
		jm.setObj(list);
		super.outJson(jm, response);
	}

}
