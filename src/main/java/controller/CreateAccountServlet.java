package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateAccountServlet
 */
@WebServlet("/CreateAccountServlet")
public class CreateAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateAccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Database db = new Database(request.getServletContext());
		String name = request.getParameter("name");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String cc = request.getParameter("CC");
		String shippingAddress = request.getParameter("ship");
		String billing = request.getParameter("billing");
		
		System.out.println("TEST1");
		int error = db.createAccount(username, password, shippingAddress, cc, name, billing);
		System.out.println("Test2");
		if(error == 2) {
			request.setAttribute("returnValue", "2");
		}else if(error == 3) {
			request.setAttribute("returnValue", "3");
		}else {
			request.setAttribute("returnValue", "1");
		}
		System.out.println(request.getAttribute("returnValue"));
		RequestDispatcher dispatch = request.getRequestDispatcher("LoginPage.jsp");
		dispatch.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
