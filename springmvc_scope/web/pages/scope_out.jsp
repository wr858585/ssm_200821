<%--
  Created by IntelliJ IDEA.
  User: oono
  Date: 2020/11/7
  Time: 10:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

Request域中reqKey1的值是：${requestScope.reqKey1}<br/>
Request域中reqKey2的值是：${requestScope.reqKey2}<br/>

Session域中seKey1的值是：${sessionScope.seKey1}<br/>
Session域中seKey2的值是：${sessionScope.seKey2}<br/>

ServletContext域中scKey1的值是：${applicationScope.scKey1}<br/>
ServletContext域中scKey2的值是：${applicationScope.scKey2}<br/>

</body>
</html>
