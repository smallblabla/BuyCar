package com.pfy.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pfy.bean.BuyThing;
import com.pfy.service.AddThing;

/**
 * Servlet implementation class ChangeBuyThingServlet
 */
public class ChangeBuyThingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeBuyThingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String type = (String)request.getParameter("type");
		String name = (String)request.getParameter("name");
		boolean ps = AddThing.addThing(name);
		System.out.println(type+name+ps);
		if(ps == true) {
			if(type.equals("add")) AddThing.addBuyThingNum(name);
			if(type.equals("subtract")) AddThing.subtractBuything(name);
			if(type.equals("delete")) AddThing.deleteBuyThing(name);			
			request.setAttribute("BuyThingList", AddThing.findAllBuyThing()); 
			request.getRequestDispatcher("BuyThingshow.jsp").forward(request, response);	
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
