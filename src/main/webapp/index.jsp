<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
  <head>
    <title>Amigos de Don Bosco</title>
    <link rel="stylesheet" href="public/css/global.css" />
    <link rel="stylesheet" href="public/css/mintail.css" />
  </head>
  <body>
    <h1>Amigos de Don Bosco Librería Online</h1>

  <div class="flex justify-center content-center items-center w-full h-full">
    <div class="w-1/2 h-fit">
      <form method="post" action="${contextPath}/signin">
        <div class="mx-6 my-5 grid grid-cols-1 gap-4">
          <label name="email" class="text-xl"> Correo Electronico: </label>
          <input type="text" name="email" placeholder="Correo Electronico" class="appearance-none rounded-sm border-2 border-blue-700 p-2 focus:outline-none focus:ring-2" />
          <label name="password" class="text-xl"> Contraseña : </label>
          <input type="password" name="password" placeholder="Contraseña" class="appearance-none rounded-sm border-2 border-blue-700 p-2 focus:outline-none focus:ring-2" />
          <button type="submit" class="bg-blue-700 py-2 text-xl font-semibold text-white">Iniciar Sesion</button>
        </div>
      </form>
      <!-- Mostrar mensaje de error si existe -->
      <c:if test="${not empty errorMessage}">
          <div class="text-red-700 mx-6 font-semibold text-xl">
            <span>
                ${errorMessage}
            </span>
          </div>
      </c:if>
    </div>
  </div>
  </body>
</html>
