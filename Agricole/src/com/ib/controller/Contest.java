package com.ib.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ib.beans.Message;
import com.ib.beans.User;
import com.ib.metier.BddConnect;

/**
 * Servlet implementation class Contest
 */
@WebServlet("/Contest")
public class Contest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Contest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		User user = (User) session.getAttribute("user");
		
		List<Message> msgs= BddConnect.findMsg(user.getPerson_id());
		request.setAttribute("msgs", msgs);
		this.getServletContext().getRequestDispatcher("/WEB-INF/contest.jsp").forward(request, response);
	}



}
