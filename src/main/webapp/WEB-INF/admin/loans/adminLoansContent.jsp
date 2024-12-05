
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<div>
    <span class="text-2xl">Configuración de Prestamos</span>

   <div class="flex justify-center items-center">
       <form action="${contextPath}/admin/loans" method="post" class="space-y-4 w-1/3">
        <div class="flex flex-col">
            <label class="text-xl font-medium" for="days_limit">Días de límite:</label>
            <input
                    class="rounded-sm border-2 border-gray-400 py-2 focus:border-blue-500 focus:outline-none w-full"
                    type="number"
                    min="7"
                    max="45"
                    id="days_limit"
                    name="days_limit"
                    required
            />
        </div>

        <div class="flex flex-col">
            <label class="text-xl font-medium" for="tax_penalty_per_day">Penalización por día:</label>
            <input
                    class="rounded-sm border-2 border-gray-400 py-2 focus:border-blue-500 focus:outline-none w-full"
                    type="number"
                    step="0.01"
                    min="0.10"
                    max="1"
                    id="tax_penalty_per_day"
                    name="tax_penalty_per_day"
                    required
            />
        </div>

        <div class="flex flex-col">
            <label class="text-xl font-medium" for="active_loans_limit">Límite de préstamos activos:</label>
            <input
                    class="rounded-sm border-2 border-gray-400 py-2 focus:border-blue-500 focus:outline-none w-full"
                    type="number"
                    min="3"
                    max="10"
                    id="active_loans_limit"
                    name="active_loans_limit"
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


        <button
                type="submit"
                class="mt-4 px-4 py-2 bg-blue-500 text-white rounded-sm hover:bg-blue-600"
        >
            Guardar
        </button>
    </form>
   </div>

</div>