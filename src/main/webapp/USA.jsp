<%--
  Created by IntelliJ IDEA.
  User: nathanielellsworth
  Date: 11/7/16
  Time: 10:27 PM
  To change this template use File | Settings | File Templates.
--%>
%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>USA GDP</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
<style>


body {background-color: floralwhite  ;}

table {
    font-family: "Times New Roman";
    border-collapse: collapse;
    width: 60%;
    color: black;
    background-color:#d4e3e5;
    padding: 8px;
}
td, th {
    border: 3px solid;
    text-align: center;
    background-color:#d4e3e5;
    padding: 8px;
}

tr:nth-child(even) {
    background-color: #dddddd ;
}
#header {
    z-index: 1;
    position: fixed;
    width: 100%;
    margin-top: -20px;
    height: 60px;
    background-color: #000000;
    margin-bottom: 10px;
    color: green;
}

h4 {
    margin-left: 5px;
    margin-bottom: 100px;
    font-family: Times New Roman;

}


</style>
<body>

<div id="header">
    <p id="name"><center><h2>USA's Annual GDP</h2></center></p>
</div>
<table border="1" class="table">
    <h4><tr><th>area_name</th><th>measurement</th><th>value</th><th>year</th></tr></h4>
    <c:forEach items="${country}" var="aGDP">
    <tr>

        <td><c:out value="${aGDP.area_name}"/></td>
        <td><c:out value="${aGDP.measurement}"/></td>
        <td><c:out value="${aGDP.value}"/></td>
        <td><c:out value="${aGDP.year}"/></td>
        </c:forEach>

    <tr>
</table>
</body>
</html>

