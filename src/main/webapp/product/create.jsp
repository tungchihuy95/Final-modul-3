<%--
  Created by IntelliJ IDEA.
  User: tungchihuy95
  Date: 11/12/20
  Time: 11:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<div class="container text-center">
  <h1>Create new Product</h1>
  <h2>
    <a href="products?action=products">List All Products</a>
  </h2>
<form method="post" >
  <table border="1" cellpadding="5">
    <caption>
      <h2>Add New Product</h2>
    </caption>
    <tr>
      <th>Product ID:</th>
      <td>
        <input type="text" name="product_id" id="product_id" size="45"/>
      </td>
    </tr>
    <tr>
      <th>Product Name:</th>
      <td>
        <input type="text" name="product_name" id="product_name" size="45"/>
      </td>
    </tr>
    <tr>
      <th>Price:</th>
      <td>
        <input type="text" name="price" id="price" size="45"/>
      </td>
    </tr>
    <tr>
      <th>Quantity:</th>
      <td>
        <input type="text" name="quantity" id="quantity" size="45"/>
      </td>
    </tr>
    <tr>
      <th>Color:</th>
      <td>
        <input type="text" name="color" id="color" size="45"/>
      </td>
    </tr>
    <tr>
      <th>Descript:</th>
      <td>
        <input type="text" name="short_desc" id="short_desc" size="45"/>
      </td>
    </tr>
    <tr>
      <th>Category:</th>
      <td>
        <select name="categoryName">
          <c:forEach items="${categories}" var="category">
            <option value="${category.getCategory_name()}"><c:out value="${category.getCategory_name()}"></c:out></option>
          </c:forEach>
        </select>
      </td>
    </tr>
    <tr>
      <td colspan="2" align="center">
        <input type="submit" value="Save"/>
      </td>
    </tr>
  </table>
</form>
</div>
</body>
</html>
