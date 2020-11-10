<%--
  Created by IntelliJ IDEA.
  User: oono
  Date: 2020/11/9
  Time: 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

  <a href="${pageContext.request.contextPath}/book/1">查询id=1的图书</a><br/>
  <a href="${pageContext.request.contextPath}/book">查询所有图书</a><br/>

  <form action="${pageContext.request.contextPath}/book" method="post">
    <input type="submit" value="添加图书">
  </form>

  <form action="${pageContext.request.contextPath}/book/1" method="post">
    <input type="hidden" name="_method" value="PUT">
    <input type="submit" value="修改图书">
  </form>

  <form action="${pageContext.request.contextPath}/book/1" method="post">
    <%--隐藏域的name属性一定是以_开头的，因为源码中有写具体变量名否则识别不了etc--%>
    <input type="hidden" name="_method" value="DELETE">
    <input type="submit" value="删除图书">
  </form>


  </body>
</html>
