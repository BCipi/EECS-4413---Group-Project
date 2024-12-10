<%@ page import="java.util.List" %>
<%@ page import="model.Product" %>
<%@ page import="model.Category" %>
<%@ page import="model.Brand" %>
<%
    List<Product> products = (List<Product>) request.getAttribute("products");
    List<Category> categories = (List<Category>) request.getAttribute("categories");
    List<Brand> brands = (List<Brand>) request.getAttribute("brands");
%>
<html>
<head>
    <title>Product Catalog</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }

        .container {
            display: flex; /* Enable flexbox layout */
            flex-direction: row;
            margin: 0;
            padding: 0;
        }

        .sidebar {
            width: 200px; /* Adjust as needed */
            background-color: #f2f2f2;
            padding: 10px;
            box-sizing: border-box;
        }

        .sidebar h2 {
            margin-top: 0;
        }

        .sidebar ul {
            list-style-type: none;
            padding-left: 0;
        }

        .sidebar ul li {
            margin-bottom: 5px;
        }

        .content {
            flex: 1; /* Take the remaining space */
            padding: 10px;
            box-sizing: border-box;
        }

        h1 {
            text-align: center;
        }

        .content h2 {
            margin-top: 0;
        }

        .content ul {
            list-style-type: none;
            padding-left: 0;
        }

        .content ul li {
            margin-bottom: 10px;
        }

        .content ul li a {
            text-decoration: none;
            color: #333;
        }

        .content ul li a:hover {
            text-decoration: underline;
        }

        /* Sidebar links styling */
        .sidebar a {
            text-decoration: none;
            color: #333;
        }

        .sidebar a:hover {
            text-decoration: underline;
        }

        /* Search bar styling */
        .search-bar {
            margin-bottom: 20px;
            width: 100%;
            box-sizing: border-box;
        }

        .search-bar form {
            display: flex;
            width: 100%;
            gap: 10px; /* space between input and button */
            box-sizing: border-box;
        }

        .search-bar input[type="text"] {
            flex: 1; /* Take all remaining horizontal space */
            padding: 5px;
            box-sizing: border-box;
        }

        .search-bar input[type="submit"] {
            padding: 5px 10px;
            box-sizing: border-box;
            white-space: nowrap;
        }
    </style>
</head>
<body>
    <h1>Product Catalog</h1>
    <div class="container">
        <div class="sidebar">
            <h2>Categories</h2>
            <ul>
                <li><a href="catalog?action=list">All Products</a></li>
                <% for (Category category : categories) { %>
                    <li><a href="catalog?action=list&categoryId=<%= category.getId() %>"><%= category.getName() %></a></li>
                <% } %>
            </ul>

            <h2>Brands</h2>
            <ul>
                <% for (Brand brand : brands) { %>
                    <li><a href="catalog?action=list&brandId=<%= brand.getId() %>"><%= brand.getName() %></a></li>
                <% } %>
            </ul>
        </div>
        <div class="content">
            <div class="search-bar">
                <form action="catalog" method="get">
                    <input type="hidden" name="action" value="list">
                    <input type="text" name="searchQuery" placeholder="Search products..." />
                    <input type="submit" value="Search" />
                </form>
            </div>

            <h2>Products</h2>
            <ul>
                <% if (products != null && !products.isEmpty()) {
                     for (Product product : products) { %>
                        <li>
                            <a href="catalog?action=details&productId=<%= product.getId() %>">
                                <%= product.getName() %>
                            </a> - $<%= product.getPrice() %>
                        </li>
                    <% }
                   } else { %>
                     <li>No products found.</li>
                <% } %>
            </ul>
        </div>
    </div>
</body>
</html>
