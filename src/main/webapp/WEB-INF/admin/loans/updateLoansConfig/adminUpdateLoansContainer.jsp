
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
    // Define el contenido que será cargado dentro del layout
    request.setAttribute("pageContent", "/WEB-INF/admin/loans/updateLoansConfig/adminUpdateLoansContent.jsp");
%>
<jsp:include page="/WEB-INF/admin/adminLayout.jsp" />
