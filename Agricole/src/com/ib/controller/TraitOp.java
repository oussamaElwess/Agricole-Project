package com.ib.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ib.metier.BddConnect;
import com.ib.beans.Operations;
import com.ib.beans.User;

/**
 * Servlet implementation class TraitOp
 */
@WebServlet("/TraitOp")
public class TraitOp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TraitOp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		HttpSession session=request.getSession();
		
		
		User user = (User) session.getAttribute("user");
				
		List<Operations> operations =  BddConnect.findOperation(user.getPerson_id());
				
		session.setAttribute("operations", operations);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/Operation.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
