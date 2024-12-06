

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class ShoppingCartServlet
 */
@WebServlet("/ShoppingCart")
public class ShoppingCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoppingCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Shopping Cart servlet forwarding");
		
		try {
			String action = request.getParameter("action");
//			String itemID = request.getParameter("itemID");
//			HttpSession session = request.getSession(true);
//		    Cart cart = (Cart) session.getAttribute("cart");
			
			if(action.equals("increase")) {
				System.out.println("Increase quantity!!!!!");
				// 1 item added to cart instance
			}
			if(action.equals("decrease")) {
				System.out.println("Decrease quantity!!!!!");
				// 1 item removed from cart instance
			}
			if(action.equals("remove")) {
				System.out.println("Remove item!!!!!");
				// Entire item removed from cart instance
			}
		}
		catch(Exception e) {
			
		}
		
		
		
	
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/shoppingCartView.jsp");
		rd.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
