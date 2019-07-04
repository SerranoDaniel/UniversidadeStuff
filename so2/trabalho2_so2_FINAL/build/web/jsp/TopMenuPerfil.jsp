<%-- 
    Document   : topMenu
    Created on : Jun 15, 2019, 7:02:41 PM
    Author     : danas
--%>

<%@page import="usables.Allergy"%>
<%@page import="java.util.ArrayList"%>
<%@page import="usables.User"%>
<%@page language="java" contentType="text/html"%>
<!DOCTYPE html>
<%

    User login = (User) session.getAttribute("login");

%>

<center><h1>Welcome <%=login.getUsername()%></h1>

<form action="./../GoToHome">
    <input type="submit" value="Go Home" name="submit">
</form></center>
