<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 86186
  Date: 2023/7/30
  Time: 19:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <style>
        body {
            background-image: url("imgs/p2.jpg");
            background-size: cover;
            background-repeat: no-repeat;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            padding: 0;
        }

        table {
            border-collapse: collapse;
            background-color: rgba(255, 255, 255, 0.8); /* You can adjust the opacity here */
            border: 1px solid #002380; /* Add border to the table */
            border-radius: 5px;
            max-width: 800px;
            width: 100%;
        }

        th, td {
            padding: 8px;
            text-align: center;
            border: 1px solid #ddd; /* Add border to table cells */
        }

        a {
            text-decoration: none;
            color: #000;
        }

        a:hover {
            color: #4CAF50;
        }
    </style>
</head>
<body>
<table>
    <tr>
        <th>id:</th>
        <th>detailId:</th>
        <th>删除</th>
    </tr>
    <c:forEach items="${ods}" var="od" varStatus="st">
        <tr>
            <td>${st.count}</td>
            <td><a href="showOrderDetail?id=${od.orderDetailId}">${od.orderDetailId}</a></td>
            <td><a href="deleteOrder?id=${od.id}&detailId=${od.orderDetailId}">删除</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
