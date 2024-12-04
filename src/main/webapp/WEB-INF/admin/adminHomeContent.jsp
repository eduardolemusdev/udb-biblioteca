<%-- Created by IntelliJ IDEA. User: bunny Date: 24/11/2024 Time: 20:57 To
change this template use File | Settings | File Templates. --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<div>
  <div>
    <form action="${contextPath}/admin/material" method="post">
      <div class="flex justify-center p-4 space-x-3">
        <label for="materialTypeComboBox">Tipo de Material:</label>
        <select
          id="materialTypeComboBox"
          class="rounded-md border-2 border-gray-400"
          name="materialType"
          required
        >
          <c:forEach items="${materialTypes.entrySet()}" var="entry">
            <option value="${entry.key}">${entry.key} - ${entry.value}</option>
          </c:forEach>
        </select>
      </div>

      <div id="dynamicFields" class="grid grid-cols-4 gap-4">
        <label class="text-xl font-medium" for="title">Título:</label>
        <input
          class="rounded-sm border-2 border-gray-400 focus:border-blue-500 focus:outline-none"
          type="text"
          id="title"
          name="title"
        />

        <label class="text-xl font-medium" for="author">Autor:</label>
        <input
          class="rounded-sm border-2 border-gray-400 focus:border-blue-500 focus:outline-none"
          type="text"
          id="author"
          name="author"
          required
        />

        <label class="text-xl font-medium" for="isbn">ISBN:</label>
        <input
          class="rounded-sm border-2 border-gray-400 focus:border-blue-500 focus:outline-none"
          type="text"
          id="isbn"
          name="isbn"
        />

        <label class="text-xl font-medium" for="publication_year"
          >Año de Publicación:</label
        >
        <input
          class="rounded-sm border-2 border-gray-400 focus:border-blue-500 focus:outline-none"
          type="number"
          id="publication_year"
          name="publicationYear"
        />

        <label class="text-xl font-medium" for="publisher">Editorial:</label>
        <input
          class="rounded-sm border-2 border-gray-400 focus:border-blue-500 focus:outline-none"
          type="text"
          id="publisher"
          name="publisher"
        />

        <label class="text-xl font-medium" for="pages">Páginas:</label>
        <input
          class="rounded-sm border-2 border-gray-400 focus:border-blue-500 focus:outline-none"
          type="number"
          id="pages"
          name="pages"
        />
      </div>
      <div class="grid grid-cols-4 gap-4 pt-4">
        <label for="categoriesCombobox" class="text-xl font-medium"
          >Categorías:</label
        >
        <select
          id="categoriesCombobox"
          class="rounded-md border-2 border-gray-400"
          name="categories"
          required
          multiple
        >
          <c:forEach items="${categories.entrySet()}" var="entry">
            <option value="${entry.key}">${entry.key} - ${entry.value}</option>
          </c:forEach>
        </select>
        <label for="materialTypeComboBox" class="text-xl font-medium"
          >Idioma:</label
        >
        <select
          id="languageCombobox"
          class="rounded-md border-2 border-gray-400"
          name="languages"
          required
          multiple
        >
          <c:forEach items="${languages.entrySet()}" var="entry">
            <option value="${entry.key}">${entry.key} - ${entry.value}</option>
          </c:forEach>
        </select>
        <label for="buildingCombobox" class="text-xl font-medium"
          >Edificio:</label
        >
        <select
          id="buildingCombobox"
          class="rounded-md border-2 border-gray-400"
          name="building"
          required
        >
          <c:forEach items="${buildings.entrySet()}" var="entry">
            <option value="${entry.key}">${entry.key} - ${entry.value}</option>
          </c:forEach>
        </select>

        <label for="buildingFloorCombobox" class="text-xl font-medium"
          >Nivel de Edificio:</label
        >
        <select
          id="buildingFloorCombobox"
          class="rounded-md border-2 border-gray-400"
          name="buildingFloor"
          required
        >
          <c:forEach items="${buildingFloors.entrySet()}" var="entry">
            <option value="${entry.key}">${entry.key}</option>
          </c:forEach>
        </select>

        <label for="buildingShelfCombobox" class="text-xl font-medium"
          >Número de Estante:</label
        >
        <select
          id="buildingShelfCombobox"
          class="rounded-md border-2 border-gray-400"
          name="buildingShelf"
          required
        >
          <c:forEach items="${buildingShelfs.entrySet()}" var="entry">
            <option value="${entry.key}">${entry.key}</option>
          </c:forEach>
        </select>
      </div>

      <div class="flex justify-center items-center pt-4">
        <button type="submit" class="px-2 py-2 bg-green-700 text-2xl text-white">GUARDAR</button>
      </div>
    </form>
  </div>
</div>
