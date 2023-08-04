<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 86186
  Date: 2023/7/28
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <td>id:</td>
        <td>商品名:</td>
        <td>商品价格:</td>
        <td>添加至购物车</td>
    </tr>
    <c:forEach items="${ps}" var="p" varStatus="st">
        <tr>
            <td>${st.count}</td>
            <td>${p.name}</td>
            <td>${p.price}</td>
            <td><a href="confirmAddCart?id=${p.id}">添加至购物车</a></td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
