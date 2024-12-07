
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Amigos de Don Bosco</title>
    <link rel="stylesheet" href="${contextPath}/public/css/global.css" />
    <link rel="stylesheet" href="${contextPath}/public/css/mintail.css" />
    <script src="${contextPath}/public/js/addMaterialService.js" defer></script>

    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
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
            <a href="${contextPath}/admin/registry" class="text-white hover:text-gray-300">Registro de Usuarios</a>
        </li>
        <li>
            <a href="${contextPath}/admin/password-recovery" class="text-white hover:text-gray-300">Actualización de Contraseña</a>
        </li>
        <li>
            <a href="${contextPath}/admin/loans" class="text-white hover:text-gray-300">Préstamos Configuración</a>
        </li>
         <li>
            <a href="${contextPath}/admin/loans/update" class="text-white hover:text-gray-300">Actualizar - Préstamo Configuración</a>
        </li>
        <li>
            <a href="${contextPath}/admin/material-loan" class="text-white hover:text-gray-300">Crear Préstamo</a>
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
