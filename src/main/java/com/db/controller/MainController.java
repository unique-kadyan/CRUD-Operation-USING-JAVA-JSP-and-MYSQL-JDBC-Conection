package com.db.controller;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.db.User.User;
import com.db.dbmodel.DbModel;

/**
 * Servlet implementation class MainController
 */
@WebServlet("/home")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name="jdbc/project")
	DataSource dataSource;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String page = request.getParameter("page");
		page.toLowerCase();
		if(!page.equals("home") || !page.equals("display")|| !page.equals("adding") || !page.equals("delete")) request.setAttribute("title", "Error Page");
		switch(page){
		case "home":
			request.setAttribute("title", "Home");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			break;
		case "display":
			displayUser(request, response);
			break;
		case "adding":
			request.setAttribute("title", "Adding to DB");
			request.getRequestDispatcher("adddata.jsp").forward(request, response);
			break;
		case "update":
			request.setAttribute("title", "Updating Data");
			request.getRequestDispatcher("updateRecords.jsp").forward(request, response);
			break;
		case "delete":
			int id = Integer.parseInt(request.getParameter("userid"));
			new DbModel().deleting(dataSource,id);
			displayUser(request, response);
		default:
			request.setAttribute("title", "Error Page");
			request.getRequestDispatcher("error.jsp").forward(request, response);
			break;
		}
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operation = request.getParameter("form").toLowerCase();
		switch (operation) {
		case "addinguser":
			User newuser = new User(request.getParameter("fname"),request.getParameter("email"),request. getParameter("mob").toString());
			adduser(newuser);
			List<User> list = new ArrayList<>(); 
			list = new DbModel().display(dataSource);
			request.setAttribute("list", list);
			request.setAttribute("title", "Data Added");
			request.getRequestDispatcher("dataadded.jsp").forward(request, response);
			break;
		case "update":
			User upuser = new User(Integer.parseInt(request.getParameter("userid")),request.getParameter("fname"),request.getParameter("email"),request. getParameter("mob").toString());
			updateUser(upuser);
			List<User> ulist = new ArrayList<>(); 
			ulist = new DbModel().display(dataSource);
			request.setAttribute("list", ulist);
			request.setAttribute("title", "Data Display");
			request.getRequestDispatcher("data.jsp").forward(request, response);
			
		
		
		default:
			request.setAttribute("title", "Error Page");
			request.getRequestDispatcher("error.jsp").forward(request, response);
			break;
		}
	}
	private void displayUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<User> dlist = new ArrayList<>(); 
		dlist = new DbModel().display(dataSource);
		request.setAttribute("list", dlist);
		request.setAttribute("title", "Data Display");
		request.getRequestDispatcher("data.jsp").forward(request, response);	
		
	}
	private void updateUser(User upuser) {
		// TODO Auto-generated method stub
		new DbModel().updating(dataSource, upuser);
		
	}
	private void adduser(User newuser) {
		// TODO Auto-generated method stub
		new DbModel().adding(dataSource,newuser);
		
	}
		
	}


