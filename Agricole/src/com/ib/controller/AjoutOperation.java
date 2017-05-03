package com.ib.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ib.beans.Operations;
import com.ib.beans.User;
import com.ib.metier.BddConnect;

/**
 * Servlet implementation class AjouterOperation
 */
@WebServlet("/AjoutOperation")
public class AjoutOperation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjoutOperation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session=request.getSession();
		
		session.getAttribute("comptes");
		
		session.getAttribute("clients");
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/AjoutOperation.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session=request.getSession();
		
		User user = (User) session.getAttribute("user");
				
		int opId = user.getPerson_id();
		
		String type = request.getParameter("opType");
		
		float montant = Float.parseFloat(request.getParameter("opMontant"));
		
		String description = request.getParameter("opDescription");
			
		BddConnect.ajoutOperation(type,montant,description,opId);
		
		List<Operations> operations =  BddConnect.findOperation(user.getPerson_id());
		
		session.setAttribute("operations", operations);
			
		this.getServletContext().getRequestDispatcher("/WEB-INF/AccueilClient.jsp").forward(request, response);	
	}

}
