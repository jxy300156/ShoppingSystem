<%--
  Created by IntelliJ IDEA.
  User: 86186
  Date: 2023/7/30
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="updateAddress" method="post">
    <input type="hidden" value="${ad.id}" name="id"><br/>
    <input type="text" value="${ad.province}" name="province" placeholder="province" ><br/>
    <input type="text" value="${ad.city}" name="city" placeholder="city" ><br/>
    <input type="text" value="${ad.area}" name="area" placeholder="area" ><br/>
    <input type="text" value="${ad.street}" name="street" placeholder="street" ><br/>
    <input type="submit" value="更新" >
</form>
</body>
</html>
