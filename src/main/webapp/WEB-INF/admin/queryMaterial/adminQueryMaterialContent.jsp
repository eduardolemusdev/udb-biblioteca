<%--
  Created by IntelliJ IDEA.
  User: bunny
  Date: 2/12/2024
  Time: 19:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c"  uri = "http://java.sun.com/jsp/jstl/core" %>
<div>
    <h1>Consultar material</h1>
    <form action="${contextPath}/admin/query-material" method="post" class="flex justify-center items-center gap-x-4">
        <div class="flex justify-center p-4 space-x-3">
        <label for="searchByCombobox">Buscar por:</label>
        <select
          id="searchByCombobox"
          class="rounded-md border-2 border-gray-400"
          name="searchType"
          required
        >
          <option value="id" selected>ID</option>
          <option value="title">Título</option>
        </select>
      </div>
       <div>
           <label class="text-xl font-medium" for="target">Título:</label>
        <input
          class="rounded-sm border-2 border-gray-400 focus:border-blue-500 focus:outline-none"
          type="text"
          id="target"
          name="target"
        />
       </div>

        <button type="submit" class="px-4 py-2 rounded-sm bg-gray-200 border-2 border-black">BUSCAR</button>
    </form>

    <div id="searchResults" class="flex justify-center items-center">

       <c:forEach items="${results}" var="item">
          <div class="grid grid-cols-2 w-1/3 border p-2 bg-yellow-50">
              <span class="font-medium">ID:</span><span>${item.getId()}</span>
              <span class="font-medium">Título:</span><a href="#" class="text-blue-700 font-medium">/${item.getTitle()}</a>
              <span class="font-medium">Autor:</span><span>${item.getAuthor()}</span>
              <span class="font-medium">ISBN:</span><span>${item.getIsbn()}</span>
              <span class="font-medium">Editorial:</span><span>${item.getPublisher()}</span>
              <span class="font-medium">Año de Publicación:</span><span>${item.getPublicationYear()}</span>
              <span class="font-medium">Número de Páginas:</span><span>${item.getPages()}</span>
          </div>
       </c:forEach>
    </div>
</div>