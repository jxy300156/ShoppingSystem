<%--
  Created by IntelliJ IDEA.
  User: 86186
  Date: 2023/8/2
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
</head>
<<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
        body {
            background-image: url("imgs/p10.jpg");
            background-size: cover;
            background-position: center;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        table {
            border-collapse: collapse;
            padding: 20px;
            background-color: rgba(255, 255, 255, 0.8);
        }
        th, td {
            padding: 10px;
            text-align: center;
        }
        a {
            text-decoration: none;
            font-size: 30px;
            color: #ff2ef6;
        }
    </style>
</head>
<body>
<table>
    <tr>
        <td colspan="6">
            <a>
                欢迎你，尊贵的用户！！！！！
            </a>
        </td>
    </tr>
    <tr>
        <td><a href="listCategory">查看所有分类</a></td>
    </tr>
    <tr>
        <td><a href="listAllProduct">查看全部商品</a></td>
    </tr>
    <tr>
        <td><a href="listAddress">管理地址</a></td>
    </tr>
    <tr>
        <td><a href="listOrder">查看订单列表</a></td>
    </tr>
    <tr>
        <td><a href="listCart">查看购物车</a></td>
    </tr>
    <tr>
        <td><button onclick="logOut()">退出登录</button></td>
    </tr>
</table>
</body>
</html>
<script>
    function logOut(){
        alert("退出中。。。");
        location.href = "/user?method=logOut";

    }
</script>