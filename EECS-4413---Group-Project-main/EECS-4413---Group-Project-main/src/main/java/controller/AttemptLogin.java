package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Account;

/**
 * Servlet implementation class AttemptLogin
 */
@WebServlet("/AttemptLogin")
public class AttemptLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AttemptLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Database db = new Database(request.getServletContext());
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		boolean req = db.verifyLogin(username, password);
		
		if(req) {
			Account user = db.getAccount(username);
			request.setAttribute("account", username);
			RequestDispatcher dispatch = null;
			System.out.println(user.getPriv());
			if(user.getPriv() == 2) {
				dispatch = request.getRequestDispatcher("/AdminView"); //ADMIN USER HAS LOGGED IN SUCCESSFULLY AND WILL BE TRANSFERED TO ADMINMENU
				
				System.out.println("Sending to Admin Page");
			}else {
				dispatch = request.getRequestDispatcher("MainMenu.jsp"); //GENERAL USER HAS LOGGED IN SUCCESSFULLY AND WILL BE TRANSFERRED TO MAINMENU
				System.out.println("Sending to Main Page");
			}
				dispatch.include(request, response);
		}else {
			RequestDispatcher dispatch = request.getRequestDispatcher("welcome.jsp");
			System.out.println("LOGIN ERROR");
			request.setAttribute("returnValue", "4");
			dispatch.include(request, response);
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
