<%--
  Created by IntelliJ IDEA.
  User: oono
  Date: 2020/11/10
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

  <form action="${pageContext.request.contextPath}/book/save" method="post">
    <input type="text" name="name">
    <input type="text" name="author" >
    <input type="text" name="price" >
    <input type="text" name="sales" >
    <input type="text" name="stock" >
    <input type="submit">
  </form>

  </body>
</html>
