<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 86186
  Date: 2023/7/30
  Time: 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <style>
        body {
            background-image: url("imgs/p4.jpg");
            background-size: cover;
            background-repeat: no-repeat;
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
        }

        .container {
            max-width: 800px;
            margin: 20px auto;
            background-color: rgba(255, 255, 255, 0.8); /* You can adjust the opacity here */
            padding: 20px;
            border-radius: 10px;
            border: 1px solid #ddd; /* Add a border to the container */
        }

        table {
            width: 100%;
            border-collapse: collapse;
            border: 1px solid #0004dd; /* Add borders to the table cells */
        }

        th, td {
            padding: 8px;
            border: 1px solid #ddd; /* Add borders to the table cells */
        }

        form {
            text-align: center;
        }

        form input[type="text"], form input[type="submit"] {
            padding: 8px;
            margin: 5px 0;
            box-sizing: border-box;
        }
    </style>
</head>
<body>
<div class="container">
    <form action="searchProduct" method="post">
        <input type="text" name="context"/><br/>
        <input type="submit" value="查询"/>
    </form>

    <table>
        <tr>
            <th>id:</th>
            <th>name:</th>
            <th>price:</th>
            <th>添加至购物车</th>
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
</div>
</body>
</html>
