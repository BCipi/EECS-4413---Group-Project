<%@ page import="java.util.Map" %>
<%@ page import="model.Cart" %>
<%@ page import="model.Product" %>
<%@ page import="Dao.ProductDAO" %>
<%@ page import="Dao.ProductDAOImpl" %>
<%@ page import="controller.DatabaseUtils" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="javax.servlet.http.HttpSession" %>

<%
    Cart cart = (Cart) session.getAttribute("cart");
    if (cart == null || cart.getItems().isEmpty()) {
%>
    <p>Your cart is empty.</p>
    <a href="catalog?action=list">Continue Shopping</a>
<%
    } else {
        try {
            Connection connection = DatabaseUtils.getConnection();
            ProductDAO productDAO = new ProductDAOImpl(connection);
%>
    <h1>Your Shopping Cart</h1>
    <table border="1">
        <tr>
            <th>Product</th>
            <th>Quantity</th>
            <th>Subtotal</th>
        </tr>
    <%
            double total = 0;
            for (Map.Entry<Integer, Integer> entry : cart.getItems().entrySet()) {
                int productId = entry.getKey();
                int quantity = entry.getValue();
                Product product = productDAO.getProduct(productId);
                double subtotal = product.getPrice() * quantity;
                total += subtotal;
    %>
        <tr>
            <td><%= product.getName() %></td>
            <td><%= quantity %></td>
            <td>$<%= subtotal %></td>
        </tr>
    <%
            }
    %>
        <tr>
            <td colspan="2"><strong>Total</strong></td>
            <td><strong>$<%= total %></strong></td>
        </tr>
    </table>
    <a href="catalog?action=list">Continue Shopping</a>
<%
        } catch (SQLException e) {
            out.println("<p>Error retrieving cart items.</p>");
        }
    }
%>
