package com.ib.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ib.beans.User;
import com.ib.metier.BddConnect;

/**
 * Servlet implementation class AjoutClient
 */
@WebServlet("/AjoutClient")
public class AjoutClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjoutClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/AjoutClient.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		HttpSession session=request.getSession();
		
		
		User user = (User) session.getAttribute("user");
		
	
			int advisor = user.getPerson_advisor_id();

			int client_external_id =Integer.parseInt(request.getParameter("id_user"));
	
			String lastname = request.getParameter("nom_user");
			String firstname = request.getParameter("prenom_user");
			String email = request.getParameter("email_user");
			String password = request.getParameter("mdp_user");
			String dob = request.getParameter("dob_user");
			String phone = request.getParameter("phone_user");
			
			BddConnect.ajoutUser(client_external_id, lastname, firstname, email, password,dob,phone,advisor);
			

			
			
		this.getServletContext().getRequestDispatcher("/WEB-INF/AccueilConseiller.jsp").forward(request, response);
		
	}

}
