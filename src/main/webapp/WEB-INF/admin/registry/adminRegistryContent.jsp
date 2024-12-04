<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<div>
    <h1 class="text-2xl py-2">Registro de usuarios</h1>

    <div class="flex justify-center items-center">
        <form class="space-y-4 w-1/3">
        <div>
            <label class="text-xl font-medium" for="username">Username:</label>
            <input
                    class="rounded-sm border-2 border-gray-400  py-2 focus:border-blue-500 focus:outline-none w-full"
                    type="text"
                    id="username"
                    name="username"
                    required
            />
        </div>

        <div>
            <label class="text-xl font-medium" for="password">Password:</label>
            <input
                    class="rounded-sm border-2 py-2 border-gray-400 focus:border-blue-500 focus:outline-none w-full"
                    type="password"
                    id="password"
                    name="password"
                    required
            />
        </div>

        <div>
            <label class="text-xl font-medium" for="userRole">Tipo de Usuario:</label>
            <select
                    class="rounded-sm border-2 border-gray-400 py-2 focus:border-blue-500 focus:outline-none w-full"
                    id="userRole"
                    name="userRole"
                    required
            >
          <c:forEach items="${roles.entrySet()}" var="entry">
            <option value="${entry.key}">${entry.key} - ${entry.value}</option>
          </c:forEach>
            </select>
        </div>

       <div class="pt-4">
           <button
                class="bg-blue-700 text-white font-medium py-2 text-xl w-full rounded-sm hover:bg-blue-600"
                type="submit"
        >
            Crear Usuario
        </button>
       </div>
    </form>
    </div>

</div>