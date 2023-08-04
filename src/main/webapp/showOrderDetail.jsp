<%--
  Created by IntelliJ IDEA.
  User: 86186
  Date: 2023/7/30
  Time: 19:41
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

        table {
            background-color: rgba(255, 255, 255, 0.8); /* You can adjust the opacity here */
            border-collapse: collapse;
            max-width: 600px;
            width: 100%;
            margin: 20px;
            text-align: center;
        }

        th, td {
            padding: 10px;
            border: 1px solid #ccc;
        }

        .pay-btn {
            background-color: #4CAF50;
            color: white;
            border: none;
            padding: 8px 12px;
            cursor: pointer;
            border-radius: 5px;
        }
    </style>
    <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
</head>
<body>
<table>
    <tr>
        <td>id:</td>
        <td>省:</td>
        <td>市:</td>
        <td>区:</td>
        <td>街道:</td>
        <td>商品名称:</td>
        <td>花费金额:</td>
        <td>支付状态</td>
    </tr>
    <tr>
        <td>${od.id}</td>
        <td>${od.province}</td>
        <td>${od.city}</td>
        <td>${od.area}</td>
        <td>${od.street}</td>
        <td>${od.productName}</td>
        <td>${od.cost}</td>
        <td>${od.state}</td>
    </tr>
</table>
<form id="payForm" name="submit_form" method="post" action="/payOrder">
    <input type="hidden" name="orderId" value="${od.id}">
    <input type="hidden" name="cost" value="${od.cost}">
    <input type="hidden" name="productName" value="${od.productName}">
    <button class="pay-btn">支付</button>
</form>

</body>
</html>
<script>
    $(document).ready(function () {
        $('.pay-btn').click(function () {
            $('#payForm').submit(); // 提交支付表单，跳转到支付宝页面进行支付
        });
    });
</script>
