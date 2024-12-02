<%--
  Created by IntelliJ IDEA.
  User: bunny
  Date: 24/11/2024
  Time: 20:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<div>
    <div>
        <form>
           <div class="flex justify-center p-4 space-x-3">
            <label for="materialTypeComboBox">Tipo de Material:</label>
            <select id="materialTypeComboBox" class="rounded-md border-2 border-gray-400" name="materialType" required>
              <option value="book" selected>Libro</option>
              <option value="thesis">Tesis</option>
              <option value="cd">CD</option>
              <option value="dvd">DVD</option>
            </select>
          </div>

        <div id="dynamicFields" class="grid grid-cols-4 gap-4">
            <label class="text-xl font-medium" for="title">Título:</label>
            <input class="rounded-sm border-2 border-gray-400 focus:border-blue-500 focus:outline-none" type="text" id="title" name="title" />

            <label class="text-xl font-medium" for="author">Autor:</label>
            <input class="rounded-sm border-2 border-gray-400 focus:border-blue-500 focus:outline-none" type="text" id="author" name="author" required />

            <label class="text-xl font-medium" for="isbn">ISBN:</label>
            <input class="rounded-sm border-2 border-gray-400 focus:border-blue-500 focus:outline-none" type="text" id="isbn" name="isbn" />

            <label class="text-xl font-medium" for="publication_year">Año de Publicación:</label>
            <input class="rounded-sm border-2 border-gray-400 focus:border-blue-500 focus:outline-none" type="number" id="publication_year" name="publication_year" />

            <label class="text-xl font-medium" for="edition">Edición:</label>
            <input class="rounded-sm border-2 border-gray-400 focus:border-blue-500 focus:outline-none" type="text" id="edition" name="edition" />

            <label class="text-xl font-medium" for="publisher">Editorial:</label>
            <input class="rounded-sm border-2 border-gray-400 focus:border-blue-500 focus:outline-none" type="text" id="publisher" name="publisher" />

            <label class="text-xl font-medium" for="pages">Páginas:</label>
            <input class="rounded-sm border-2 border-gray-400 focus:border-blue-500 focus:outline-none" type="number" id="pages" name="pages" />
        </div>
        <div>

            <div class="flex justify-center p-4 space-x-3">
            <label for="materialTypeComboBox">Lenguaje:</label>
            <select id="languageCombobox" class="rounded-md border-2 border-gray-400" name="materialType" required>
            <c:forEach items="${languages}" var="item">
                <option>${item} - ${item.value}</option>
            </c:forEach>
            </select>
          </div>


        </div>
        </form>
    </div>
</div>