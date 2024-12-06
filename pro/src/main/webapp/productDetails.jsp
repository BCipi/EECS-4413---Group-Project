<%@ page import="model.Product" %>
<%
    Product product = (Product) request.getAttribute("product");
%>
<html>
<head>
    <title><%= product.getName() %> Details</title>
</head>
<body>
    <h1><%= product.getName() %></h1>
    <p><strong>Description:</strong> <%= product.getDescription() %></p>
    <p><strong>Price:</strong> $<%= product.getPrice() %></p>
    <form action="catalog" method="post">
        <input type="hidden" name="action" value="addToCart">
        <input type="hidden" name="productId" value="<%= product.getId() %>">
        <input type="submit" value="Add to Cart">
    </form>
    <a href="catalog?action=list">Back to Catalog</a>
</body>
</html>
