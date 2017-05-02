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
 * Servlet implementation class Edit
 */
@WebServlet("/Edit")
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Edit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/Edit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session=request.getSession();
		
		String NouveauNom = request.getParameter("nom_user");
		String NouveauPrenom = request.getParameter("prenom_user");
		String NouveauEmail = request.getParameter("email_user");
		String NouveauMDP = request.getParameter("mdp_user");
		
		User user = (User) session.getAttribute("user");
		
		int client_id = user.getPerson_id();
		
		if (NouveauNom == ""){
			NouveauNom = user.getPerson_lastname();
		}
		
		if (NouveauPrenom == ""){
			NouveauPrenom = user.getPerson_firstname();
		}
		
		if (NouveauEmail == ""){
			NouveauEmail = user.getPerson_email();
		}
		
		if (NouveauMDP == ""){
			NouveauMDP = user.getPerson_password();
		}
		
			
		
		BddConnect.UpdateUser(client_id, NouveauNom, NouveauPrenom, NouveauEmail, NouveauMDP);
		
		
		
		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/EditValid.jsp").forward(request, response);
	}

}
