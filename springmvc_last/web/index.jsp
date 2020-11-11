<%--
  Created by IntelliJ IDEA.
  User: oono
  Date: 2020/11/10
  Time: 9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

  <%--准备一个上传文件的表单--%>
  <form action="${pageContext.request.contextPath}/upload" enctype="multipart/form-data" method="post">
    用户名：<input type="text" name="username"/><br/>
    头像：<input type="file" name="photo"/><br/>
    <input type="submit" value="上传">
  </form>

  </body>
</html>
