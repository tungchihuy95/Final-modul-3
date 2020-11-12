<%--
  Created by IntelliJ IDEA.
  User: tungchihuy95
  Date: 11/12/20
  Time: 11:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
  <title>Title</title>
</head>
<body>
<a href="/products?action=create">Add New Product</a>
<div>
  <form action="/products?action=search" method="post">
    <input type="text" name="search">
    <input type="submit"value="SEARCH">
  </form>
</div>
</h2>
<h1>Product List</h1>
<table width="100%" border="1">
  <tr class="thead-dark">
    <th>ID</th>
    <th>Product Name</th>
    <th>Price</th>
    <th>Quatity</th>
    <th>Color</th>
    <th>Short Desc</th>
    <th>Category</th>
    <th>Action</th>
  <c:forEach items="${products}" var="product">
    <tr>
      <td><c:out value="${product.getProductId()}"></c:out> </td>
      <td><c:out value="${product.getProductName()}"></c:out> </td>
      <td><c:out value="${product.getPrice()}"></c:out> </td>
      <td><c:out value="${product.getQuantity()}"></c:out> </td>
      <td><c:out value="${product.getColor()}"></c:out> </td>
      <td><c:out value="${product.getShortDesc()}"></c:out> </td>
      <td><c:out value="${product.getCategory().getName()}"></c:out> </td>
    </tr>

  </c:forEach>
</table>
</body>
</html>
