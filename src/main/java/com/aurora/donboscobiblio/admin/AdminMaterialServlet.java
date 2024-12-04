package com.aurora.donboscobiblio.admin;

import com.aurora.donboscobiblio.database.CategoriesService;
import com.aurora.donboscobiblio.database.MaterialLanguageService;
import com.aurora.donboscobiblio.database.SaveMaterialService;
import com.aurora.donboscobiblio.database.models.BookEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.print.Book;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/admin/material")
public class AdminMaterialServlet extends HttpServlet {
    private final SaveMaterialService saveMaterialService = new SaveMaterialService();
    private final CategoriesService categoriesService = new CategoriesService();
    private final MaterialLanguageService materialLanguageService = new MaterialLanguageService();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer materialType = Integer.parseInt(request.getParameter("materialType"));

        List<Integer> categories = Arrays.stream(request.getParameterValues("categories")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> languages = Arrays.stream(request.getParameterValues("languages")).map(Integer::parseInt).collect(Collectors.toList());

        String building = request.getParameter("building");
        String buildingFloor = request.getParameter("buildingFloor");
        String buildingShelf = request.getParameter("buildingShelf");

        switch (materialType) {
            case 1:
                BookEntity newBook = new BookEntity();
                newBook.setTitle(request.getParameter("title"));
                newBook.setAuthor(request.getParameter("author"));
                newBook.setPublisher(request.getParameter("publisher"));
                newBook.setPages(Integer.parseInt(request.getParameter("pages")));
                newBook.setIsbn(request.getParameter("isbn"));
                newBook.setPublicationYear(Integer.parseInt(request.getParameter("publicationYear")));

                Integer newMaterialId = saveMaterialService.saveBook(newBook,materialType);
                categoriesService.saveMaterialCategories(categories,newMaterialId);
                materialLanguageService.saveMaterialLanguages(languages,newMaterialId);
            break;
        }







        response.sendRedirect(request.getContextPath()+"/admin/home");
    }
}
