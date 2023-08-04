<%--
  Created by IntelliJ IDEA.
  User: 86186
  Date: 2023/7/30
  Time: 13:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="updateCart" method="post">
    <input type="hidden" value="${c.id}" name="id"><br/>
    请输入您想更改的商品数：
    <input type="text" value="${c.quantity}" name="quantity" placeholder="quantity" ><br/>
    <input type="submit" value="更新" >
</form>
</body>
</html>
