package controller;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cart;


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
		
		HttpSession session = request.getSession(true);
		Cart cart;
   	      synchronized (session) {  // synchronized to prevent concurrent updates
   	         // Retrieve the shopping cart for this session, if any. Otherwise, create one.
   	         cart = (Cart) session.getAttribute("cart");
   	         if (cart == null) {  // No cart, create one.
   	            cart = new Cart();
   	            
   	            // Sample data
   	            cart.addItem("1984", 0, "Great book", "Dystopian", "Penguin", 10, 5);
 	   	        cart.addItem("Sapiens", 1, "History of humanity", "Non Fiction", "Penguin", 20, 10);
 	   	    
   	            session.setAttribute("cart", cart);  // Save it into session
   	         }
   	      }
	    
   	      
		try {
			String action = request.getParameter("action");
			String itemIDString = request.getParameter("itemID");
			int itemID = Integer.parseInt(itemIDString);

	   	  
	 
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
				cart.removeItem(itemID);
				// Entire item removed from cart instance
			}
		}
		catch(Exception e) {
			
		}
		
		if(cart.getItems().size() == 0) {
			response.setContentType("text/html;charset=UTF-8");
	   	    PrintWriter out = response.getWriter();
	   	    
	   	    out.println("<h1>Cart is empty!</h1>");
	   	    out.println("<br><a href=\"index.html\">Keep Shopping</a>");
	   	    out.close();
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/shoppingCartView.jsp");
			rd.forward(request, response);
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
