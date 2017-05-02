package com.ib.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ib.metier.BddConnect;

/**
 * Servlet implementation class EditConseiller
 */
@WebServlet("/EditConseiller")
public class EditConseiller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditConseiller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/EditConseiller.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String id = request.getParameter("client_id");
		
		if (id != ""){
			
			int ClientId = Integer.parseInt(id);

					
			String NouveauNom = request.getParameter("nom_user");
			String NouveauPrenom = request.getParameter("prenom_user");
			String NouveauEmail = request.getParameter("email_user");
			String NouveauMDP = request.getParameter("mdp_user");
			
			BddConnect.UpdateUserConseiller(ClientId, NouveauNom, NouveauPrenom, NouveauEmail, NouveauMDP);
		}
			
			
		this.getServletContext().getRequestDispatcher("/WEB-INF/AccueilConseiller.jsp").forward(request, response);
	
	}

}
