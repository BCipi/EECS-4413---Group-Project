package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Item;

/**
 * Servlet implementation class InventoryManagement
 */
@WebServlet("/InventoryManagement")
public class InventoryManagement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InventoryManagement() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Database db = new Database(request.getServletContext());
		
	
		request.setAttribute("username", request.getAttribute("username"));
		
		
		
		//Need to update Item Stock
		if(request.getParameter("update") == null) {
			//DO NOTHING
		}else if(request.getParameter("update").equals("1")) {
			int newId = Integer.parseInt(request.getParameter("newId"));
			int newStock = Integer.parseInt(request.getParameter("newStock"));
			
			db.updateItemQty(newId, newStock);
			
		}
		
		List<Item> items = db.getAllItems();
		request.setAttribute("Items", items);
		
		RequestDispatcher dispatch = request.getRequestDispatcher("InventoryManagement.jsp");
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
