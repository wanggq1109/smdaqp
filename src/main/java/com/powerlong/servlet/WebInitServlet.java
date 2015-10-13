package com.powerlong.servlet;

import org.apache.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;


/**
 * 项目初始化
 * 
 * WebInitServlet
 * 
 * dzm
 * 2013-8-26-下午4:49:33
 * 
 * @version 1.0.0
 *
 */
public class WebInitServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(WebInitServlet.class);
	
	public static ServletContext servletContext=null;
	public void init() throws ServletException {
		super.init();
		servletContext=getServletContext();
	}

}
