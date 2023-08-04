<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 86186
  Date: 2023/7/30
  Time: 12:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
    <script>
        $(function() {
            $(".delete-btn").click(function() {
                let deleteButton = $(this);
                let cid = deleteButton.data("id");
                $.ajax({
                    url: "/deleteFromCart?id="+cid,
                    method:"POST",
                    success: function(result) {
                        let jsObject = JSON.parse(result);
                        if (jsObject.mess === "success") {
                            deleteButton.parent().parent().hide();
                            alert("删除成功！");
                        } else {
                            alert("删除购物车内的该条信息失败！");
                        }
                    }
                })
            })
        });
    </script>
    <style>
        body {
            background-color: #ffa8a8;
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
            border: 1px solid #600056; /* Add border around the table */
            border-radius: 10px;
            max-width: 800px;
            width: 100%;
            margin-top: 20px;
        }

        th, td {
            border: 1px solid #ddd; /* Add borders to table cells */
            padding: 8px;
            text-align: center;
        }

        .delete-btn {
            background-color: #f44336;
            color: white;
            border: none;
            padding: 6px 10px;
            border-radius: 4px;
            cursor: pointer;
        }

        .delete-btn:hover {
            background-color: #d32f2f;
        }
    </style>
</head>
<body>
<table>
    <tr>
        <th>id:</th>
        <th>商品名称:</th>
        <th>购物数量:</th>
        <th>价格:</th>
        <th>编辑</th>
        <th>删除</th>
        <th>结算</th>
    </tr>
    <c:forEach items="${cs}" var="c" varStatus="st">
        <tr>
            <td>${c.id}</td>
            <td>${c.productName}</td>
            <td>${c.quantity}</td>
            <td>${c.totalPrice}</td>
            <td><a href="editCart?id=${c.id}">编辑</a></td>
            <td><button class="delete-btn" data-id="${c.id}">删除</button></td>
            <td><a href="confirmOrderDetail?id=${c.id}">结算</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
