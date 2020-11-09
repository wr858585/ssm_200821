<%--
  Created by IntelliJ IDEA.
  User: oono
  Date: 2020/11/6
  Time: 9:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<form action="http://localhost:8080/springmvc_01/param7" method="get">
    姓名：<input type="text" name="name"><br/>
    年龄：<input type="text" name="age"><br/>
    编号：<input type="text" name="id"><br/>
    电话：<input type="text" name="phone"><br/>
    车名：<input type="text" name="car.name"><br/>
    车牌：<input type="text" name="car.carNo"><br/>
    <input type="submit" value="提交">
</form>

</body>
</html>
