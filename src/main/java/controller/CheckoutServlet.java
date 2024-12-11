package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Account;
import model.Sale;

/**
 * Servlet implementation class CheckoutServlet
 */
@WebServlet("/CheckoutServlet")
public class CheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    HttpSession session = request.getSession(true);
	    String account = "" + request.getAttribute("account");
		if (!(account == null == account.equals(""))) {
			Database db = new Database(request.getServletContext());
			Account acc = db.getAccount("test");
			String billing = acc.getBillingAddress();
		    session.setAttribute("def_billing", billing);
		    String shipping = acc.getShipAddress();
		    session.setAttribute("def_shipping", shipping);
		    
		    String itemName = request.getParameter("itemName");
		    ArrayList<Integer> itemId = new ArrayList<Integer>();
		    for (String s : request.getParameterValues("itemId")) {
		    	itemId.add(Integer.parseInt(s));
		    }
		    ArrayList<Integer> quantity = new ArrayList<Integer>();
		    for (String s : request.getParameterValues("quantity")) {
		    	itemId.add(Integer.parseInt(s));
		    }
		    int transactionId = 0; //TODO figure out how to track this
		    Sale sale = new Sale(acc.getName(), itemId, itemName, quantity, transactionId);
		    session.setAttribute("sale", sale);
		    
		    String target = "OrderConfirmation.jsp";
		    request.getRequestDispatcher(target).forward(request, response);
		    
		} else {
			String target = "LoginPage.jsp";
		    request.getRequestDispatcher(target).forward(request, response);
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
