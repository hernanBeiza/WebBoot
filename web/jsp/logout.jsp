<%-- 
    Document   : logout
    Created on : Nov 19, 2016, 5:55:29 PM
    Author     : hernanBeiza
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    session.invalidate();
    response.sendRedirect("../index.jsp");
%>