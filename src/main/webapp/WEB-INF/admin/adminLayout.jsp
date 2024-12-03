
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Amigos de Don Bosco</title>
    <link rel="stylesheet" href="${contextPath}/public/css/global.css" />
    <link rel="stylesheet" href="${contextPath}/public/css/mintail.css" />
    <script src="${contextPath}/public/js/addMaterialService.js" defer></script>
</head>
<body>

<nav class="bg-black p-4">
    <ul class="flex space-x-4">
        <li>
            <a href="${contextPath}/admin/home" class="text-white hover:text-gray-300">Agregar Material</a>
        </li>
        <li>
            <a href="${contextPath}/admin/query-material" class="text-white hover:text-gray-300">Consultar Material</a>
        </li>
        <li>
            <a href="${contextPath}/admin/registry" class="text-white hover:text-gray-300">Administración de Usuarios</a>
        </li>
        <li>
            <a href="${contextPath}/admin/loans" class="text-white hover:text-gray-300">Préstamos Configuración</a>
        </li>
    </ul>
</nav>


<main class="w-full h-full">
    <jsp:include page="${pageContent}"/>
</main>

<footer>
    <p>© 2024 Don Bosco Library</p>
</footer>
</body>
</html>
