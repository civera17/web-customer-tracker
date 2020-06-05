<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: xakir
  Date: 5/28/2020
  Time: 3:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add customer form</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
            integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container p-3 my-3 border">
    <div id="wrapper">
        <div id="header">
            <h2>Form</h2>
        </div>
    </div>
<form:form action="saveCustomer" modelAttribute="customer" method="post">

    <form:hidden path="id" />

    <table class="table-light">
        <tbody>
        <tr>
            <td><label>First name:</label></td>
            <td><form:input path="firstName"/></td>
        </tr>

        <tr>
            <td><label>Last name:</label></td>
            <td><form:input path="lastName"/></td>
        </tr>

        <tr>
            <td><label>Email:</label></td>
            <td><form:input path="email"/></td>
        </tr>

        <tr>
            <td><label></label></td>
            <td><input type="submit" value="Save" class="btn btn-info"></td>
        </tr>
        </tbody>
    </table>
</form:form>
    <div style="clear; both;"></div>
    <p>
        <a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
    </p>
</div>
</body>
</html>
