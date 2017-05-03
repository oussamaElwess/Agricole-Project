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
 * Servlet implementation class Send
 */
@WebServlet("/Send")
public class Send extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Send() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		
		User user = (User) session.getAttribute("user");
		
		int idOperation = Integer.parseInt(request.getParameter("IdOperation"));
		
		int msg_to = 0;
		
		List<Message> msgs= BddConnect.findMsg(user.getPerson_id());
		
		request.setAttribute("msgs", msgs);
		
			for (Message msg : msgs) {
		 			
		 		if((msg.getMsg_id() == idOperation )) {
				 	 				
		 			msg_to = msg.getMsg_from();
		 				
		 		
		 		}
		 	}
			
		Message msg = new Message();
		
		msg.setMsg_content(request.getParameter("msg"));
		msg.setMsg_from(user.getPerson_id());
		msg.setMsg_to(msg_to);
		//msg.setMsg_to(Integer.parseInt(request.getParameter("IdConseiller")));
		BddConnect.ajoutMsg(msg);
		
		if (user.getPerson_is_advisor()==1){
			this.getServletContext().getRequestDispatcher("/WEB-INF/AccueilConseiller.jsp").forward(request, response);
			return;
			
		}else{
			this.getServletContext().getRequestDispatcher("/WEB-INF/AccueilClient.jsp").forward(request, response);
			return;
			
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
