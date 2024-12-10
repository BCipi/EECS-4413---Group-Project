package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Account;

/**
 * Servlet implementation class ViewUsers
 */
@WebServlet("/ViewUsers")
public class ViewUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewUsers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Database db = new Database(request.getServletContext());
		
		if(request.getParameter("remove").equals("1")) {
			String rUsername = request.getParameter("rUsername");
			db.deleteAccount(rUsername);
			
		}
		if(request.getParameter("addUser").equals("1")) {
			String newName = request.getParameter("newName");
			String newUsername = request.getParameter("newUsername");
			String newPassword = request.getParameter("newPassword");
			String newCC = request.getParameter("newCC");
			String newShip = request.getParameter("newShip");
			String newBilling = request.getParameter("newBilling");
			int newPriv = Integer.parseInt(request.getParameter("newPriv"));
			
			db.adminCreateAccount(newUsername, newPassword, newShip, newCC, newName, newBilling, newPriv);
		}
		
		if(request.getParameter("eFlag").equals("1")) {
			String newName = request.getParameter("newName");
			String newUsername = request.getParameter("newUsername");
			String newPassword = request.getParameter("newPassword");
			String newShip = request.getParameter("newShip");
			String newBill = request.getParameter("newBill");
			String newCC = request.getParameter("newCC");
			int newPriv = Integer.parseInt(request.getParameter("newPriv"));
			Account account = new Account(newShip, newUsername, newPassword, newCC, newName, newPriv, newBill);
			
			db.updateAccount(request.getParameter("username"), account);
		}
		List<Account> users = db.getAllAccounts();
		
		request.setAttribute("users", users);
		
		RequestDispatcher dispatch = request.getRequestDispatcher("ViewUsers.jsp");
		dispatch.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
