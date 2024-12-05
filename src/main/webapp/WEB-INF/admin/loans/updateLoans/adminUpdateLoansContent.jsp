
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<div class="mt-8">
    <table class="min-w-full border-collapse border border-gray-400">
        <thead>
        <tr class="bg-gray-200">
            <th class="border border-gray-400 px-4 py-2">Config ID</th>
             <th class="border border-gray-400 px-4 py-2">Días de límite</th>
            <th class="border border-gray-400 px-4 py-2">Penalización por día</th>
            <th class="border border-gray-400 px-4 py-2">Límite de préstamos activos</th>
            <th class="border border-gray-400 px-4 py-2">Tipo de Usuario</th>
            <th class="border border-gray-400 px-4 py-2">Estado</th>
            <th class="border border-gray-400 px-4 py-2">Acciones</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${elements}" var="element">
            <tr class="odd:bg-white even:bg-gray-100">
                 <td class="border border-gray-400 px-4 py-2">

                          ${element.getId()}
                </td>
                <td class="border border-gray-400 px-4 py-2">
                    <input
                            type="number"
                            class="rounded-sm border border-gray-300 py-1 px-2 w-full focus:outline-none focus:border-blue-500"
                            name="days_limit_${element.getId()}"
                            value="${element.getDaysLimit()}"
                            min="7"
                            max="45"
                    />
                </td>
                <td class="border border-gray-400 px-4 py-2">
                    <input
                            type="number"
                            step="0.01"
                            class="rounded-sm border border-gray-300 py-1 px-2 w-full focus:outline-none focus:border-blue-500"
                            name="tax_penalty_per_day_${element.getId()}"
                            value="${element.getTaxPenaltyPerDay()}"
                            min="0.10"
                            max="1"
                    />
                </td>
                <td class="border border-gray-400 px-4 py-2">
                    <input
                            type="number"
                            class="rounded-sm border border-gray-300 py-1 px-2 w-full focus:outline-none focus:border-blue-500"
                            name="active_loans_limit_${element.getId()}"
                            value="${element.getActiveLoansLimit()}"
                            min="3"
                            max="10"
                    />
                </td>
                <td class="border border-gray-400 px-4 py-2">
                   ${element.getRoleName()}
                </td>
                <td class="border border-gray-400 px-4 py-2">
                    <select
                            class="rounded-sm border border-gray-300 py-1 px-2 w-full focus:outline-none focus:border-blue-500"
                            name="status_${element.getId()}"
                    >
                        <option value="enabled" ${element.isEnabled() == 'enabled' ? 'selected' : ''}>Habilitado</option>
                        <option value="disabled" ${element.isEnabled() == 'disabled' ? 'selected' : ''}>Deshabilitado</option>
                    </select>
                </td>
                <td class="border border-gray-400 px-4 py-2 text-center">
                    <button
                            type="button"
                            class="bg-blue-500 text-white px-4 py-2 rounded hover:bg-blue-600"
                            onclick="updateElement(${element.getId()})"
                    >
                        Actualizar
                    </button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
