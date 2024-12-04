

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
    // Define el contenido que será cargado dentro del layout
    request.setAttribute("pageContent", "/WEB-INF/admin/usersPasswordRecovery/usersPasswordRecoveryContent.jsp");
%>
<jsp:include page="/WEB-INF/admin/adminLayout.jsp" />
