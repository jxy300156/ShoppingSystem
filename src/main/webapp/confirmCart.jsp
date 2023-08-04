<%--
  Created by IntelliJ IDEA.
  User: 86186
  Date: 2023/7/30
  Time: 13:02
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

        .form-container {
            background-color: rgba(255, 255, 255, 0.8); /* You can adjust the opacity here */
            padding: 20px;
            border-radius: 10px;
            max-width: 400px;
            width: 100%;
            text-align: center;
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
<div class="form-container">
    <form action="addToCart" method="post">
        <input type="hidden" value="${p.id}" name="id"/><br/>
        您想购买的商品数量：<input type="text" name="quantity"/><br/>
        <input type="submit" value="添加到购物车"/>
    </form>
</div>
</body>
</html>
