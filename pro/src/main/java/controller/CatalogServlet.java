package controller;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.BrandDAO;
import Dao.BrandDAOImpl;
import Dao.CategoryDAO;
import Dao.CategoryDAOImpl;
import Dao.ProductDAO;
import Dao.ProductDAOImpl;
import model.Brand;
import model.Cart;
import model.Category;
import model.Product;
@WebServlet("/catalog")
public class CatalogServlet extends HttpServlet {
    private ProductDAO productDAO;
    private CategoryDAO categoryDAO;
    private BrandDAO brandDAO;

    @Override
    public void init() throws ServletException {
        try {
            Connection connection = DatabaseUtils.getConnection();
            productDAO = new ProductDAOImpl(connection);
            categoryDAO = new CategoryDAOImpl(connection);
            brandDAO = new BrandDAOImpl(connection);
        } catch (SQLException e) {
            throw new ServletException("Unable to initialize DAOs", e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Determine the action to perform
        String action = request.getParameter("action");

        if (action == null || action.equals("list")) {
            // Default action: list products
            listProducts(request, response);
        } else if (action.equals("details")) {
            // Show product details
            showProductDetails(request, response);
        } else if (action.equals("addToCart")) {
            // Add product to cart
            addToCart(request, response);
        } else {
            // Unknown action, redirect to catalog
            response.sendRedirect("catalog?action=list");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Handle form submissions via POST
        doGet(request, response);
    }

    private void listProducts(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String searchQuery = request.getParameter("searchQuery");
        String categoryIdStr = request.getParameter("categoryId");
        String brandIdStr = request.getParameter("brandId");

        List<Product> products;

        try {
            if (searchQuery != null && !searchQuery.trim().isEmpty()) {
                // If there's a search query, filter products by the query
                products = productDAO.searchProductsByName(searchQuery);
            } else if (categoryIdStr != null) {
                int categoryId = Integer.parseInt(categoryIdStr);
                products = productDAO.getProductsByCategory(categoryId);
            } else if (brandIdStr != null) {
                int brandId = Integer.parseInt(brandIdStr);
                products = productDAO.getProductsByBrand(brandId);
            } else {
                products = productDAO.getAllProducts();
            }
        } catch (NumberFormatException e) {
            // If categoryId or brandId are invalid, just fallback to all products
            products = productDAO.getAllProducts();
        }

        List<Category> categories = categoryDAO.getAllCategories();
        List<Brand> brands = brandDAO.getAllBrands();

        request.setAttribute("products", products);
        request.setAttribute("categories", categories);
        request.setAttribute("brands", brands);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/catalog.jsp");
        dispatcher.forward(request, response);
    }


    private void showProductDetails(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String productIdStr = request.getParameter("productId");

        if (productIdStr == null) {
            response.sendRedirect("catalog?action=list");
            return;
        }

        try {
            int productId = Integer.parseInt(productIdStr);
            Product product = productDAO.getProduct(productId);

            if (product == null) {
                response.sendRedirect("catalog?action=list");
                return;
            }

            request.setAttribute("product", product);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/productDetails.jsp");
            dispatcher.forward(request, response);
        } catch (NumberFormatException e) {
            throw new ServletException("Error retrieving product details", e);
        }
    }

    private void addToCart(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String productIdStr = request.getParameter("productId");

        if (productIdStr == null) {
            response.sendRedirect("catalog?action=list");
            return;
        }

        try {
            int productId = Integer.parseInt(productIdStr);

            HttpSession session = request.getSession();
            Cart cart = (Cart) session.getAttribute("cart");
            if (cart == null) {
                cart = new Cart();
                session.setAttribute("cart", cart);
            }
            cart.addProduct(productId);

            // Redirect to the cart page
            response.sendRedirect("cart.jsp");//this line is only a place holder,I build a simple cart.jsp for demo only replace cart.jsp with the latter one you designed
        } catch (NumberFormatException e) {
            throw new ServletException("Invalid product ID", e);
        }
    }
}
