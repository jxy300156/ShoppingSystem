<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 86186
  Date: 2023/7/30
  Time: 11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <style>
        body {
            background-image: url("imgs/p3.jpg");
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
            width: 400px; /* Adjust the width as needed */
            background-color: rgba(255, 255, 255, 0.8); /* You can adjust the opacity here */
            border: 1px solid #ddd; /* Add a border to the table */
        }

        table td, table th {
            padding: 8px;
            border: 1px solid #ddd; /* Add borders to table cells */
        }

        a {
            text-decoration: none;
            color: #000;
        }
    </style>
</head>
<body>
<table>
    <tr>
        <th>id:</th>
        <th>name:</th>
    </tr>
    <c:forEach items="${cs}" var="c" varStatus="st">
        <tr>
            <td>${st.count}</td>
            <td><a href="listProduct?id=${c.id}">${c.name}</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
