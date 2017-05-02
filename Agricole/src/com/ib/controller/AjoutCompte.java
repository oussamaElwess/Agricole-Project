package com.ib.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ib.beans.User;
import com.ib.metier.BddConnect;

/**
 * Servlet implementation class AjoutCompte
 */
@WebServlet("/AjoutCompte")
public class AjoutCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjoutCompte() {
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
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/AjoutCompte.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * 
	 */
	
	 public static String ConvertId(String oldId, HttpSession session) {
		 
		 User user = (User) session.getAttribute("user");
		 
		 List<User> clients =  BddConnect.findClients(user.getPerson_id());
    	 
    	 for (User client : clients) {
 			
 			if((client.getPerson_external_id().equals(oldId))) {
 	 				
 				return ""+client.getPerson_id();
 				
 		
 			}
 		}
		return null;
         
     }
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		HttpSession session=request.getSession();
		
		
		User user = (User) session.getAttribute("user");
		
		List<User> clients =  BddConnect.findClients(user.getPerson_id());
		
		session.setAttribute("clients", clients);
		
		    
	    String client_id = ConvertId(request.getParameter("id_user").substring(0,8), session);
				
			float balance = Float.parseFloat(request.getParameter("balance"));
			
			String type = request.getParameter("type");
			
			BddConnect.ajoutCompte(client_id, balance, type, 0);
			
		this.getServletContext().getRequestDispatcher("/WEB-INF/AccueilConseiller.jsp").forward(request, response);
	}

}
