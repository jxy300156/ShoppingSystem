<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 86186
  Date: 2023/7/30
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <style>
        body {
            background-image: url("imgs/p10.jpg");
            background-size: cover;
            background-repeat: no-repeat;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            padding: 0;
        }

        .table-container {
            background-color: rgba(255, 255, 255, 0.8);
            padding: 20px;
            border-radius: 10px;
            max-width: 800px;
            width: 100%;
            text-align: center;
            border: 1px solid #ddd;
        }

        .table-container table {
            width: 100%;
            border-collapse: collapse;
        }

        .table-container th, .table-container td {
            padding: 8px;
            border: 1px solid #ddd;
        }

        .form-container {
            background-color: rgba(255, 255, 255, 0.8);
            padding: 20px;
            border-radius: 10px;
            max-width: 400px;
            width: 100%;
            text-align: center;
            margin-top: 20px;
        }

        .form-container input[type="text"] {
            width: 100%;
            padding: 10px;
            margin: 5px 0;
            box-sizing: border-box;
        }

        .form-container input[type="submit"] {
            width: 100%;
            padding: 10px;
            margin-top: 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
    </style>
</head>
<body>
<div class="table-container">
    <table>
        <tr>
            <th>id:</th>
            <th>省:</th>
            <th>市:</th>
            <th>区:</th>
            <th>街道:</th>
            <th>编辑</th>
            <th>删除</th>
        </tr>
        <c:forEach items="${ads}" var="ad" varStatus="st">
            <tr>
                <td>${st.count}</td>
                <td>${ad.province}</td>
                <td>${ad.city}</td>
                <td>${ad.area}</td>
                <td>${ad.street}</td>
                <td><a href="editAddress?id=${ad.id}">编辑</a></td>
                <td><a href="deleteAddress?id=${ad.id}">删除</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
<br/>
<div class="form-container">
    <form action="addAddress" method="post">
        <input type="text" name="province"/><br/>
        <input type="text" name="city"/><br/>
        <input type="text" name="area"/><br/>
        <input type="text" name="street"/><br/>
        <input type="submit" value="新增"/>
    </form>
</div>
</body>
</html>

