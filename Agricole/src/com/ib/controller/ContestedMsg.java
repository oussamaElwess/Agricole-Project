package com.ib.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ib.beans.Operations;
import com.ib.metier.BddConnect;

/**
 * Servlet implementation class ContestedMsg
 */
@WebServlet("/ContestedMsg")
public class ContestedMsg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContestedMsg() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Operations> operations =  BddConnect.findOperation(1);
		List<Operations> operations_contested= new ArrayList<Operations>();
		for (Operations operation2 : operations) {
			if(operation2.getOpe_dispute() > 0){
				operations_contested.add(operation2);
			}
		}
		request.setAttribute("operations", operations_contested);
		this.getServletContext().getRequestDispatcher("/WEB-INF/Operation_contested.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
