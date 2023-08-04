<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 86186
  Date: 2023/7/30
  Time: 19:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="addOrderDetail" method="post">
    <input type="hidden" value="${c.id}" name="cid"><br/>
    <a>请选择地址Id：</a>
    <c:forEach items="${ads}" var="ad" varStatus="st">
        <input type="radio" name="addressId" value="${ad.id}"><a>${ad.id}</a>
    </c:forEach>
    <input type="hidden" value="${c.productName}" name="productName"><br/>
    <input type="hidden" value="${c.totalPrice}" name="cost"><br/>
    <input type="submit" value="确定" >
</form>
</body>
</html>
