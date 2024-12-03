

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
    // Define el contenido que será cargado dentro del layout
    request.setAttribute("pageContent", "/WEB-INF/admin/queryMaterial/adminQueryMaterialContent.jsp");
%>
<jsp:include page="/WEB-INF/admin/adminLayout.jsp" />
