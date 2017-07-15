package com.yc.web.listeners;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.yc.bean.Tag;
import com.yc.biz.FavoriteBiz;
import com.yc.biz.impl.FavoriteBizImpl;

//  当容器启动时就加载所有的标签...    使用临听器实现      
@WebListener
public class InitListener implements ServletContextListener {   //   ServletContext   -> application

	public void contextDestroyed(ServletContextEvent arg0) {
	}
	
	
	//创建FavoriteBizImpl对象，调用findAllTag()方法获取所有的  List<Tag>  存到    application中
	//TODO:以后再添加Tag,将要同步修改   application中的List<Tag>
	public void contextInitialized(ServletContextEvent arg0) {
		FavoriteBiz tb = new FavoriteBizImpl();
		try {
			List<Tag> list = tb.findAllTag();
			///application
			arg0.getServletContext().setAttribute("alltags", list);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
