package com.aurora.donboscobiblio.database;

import com.aurora.donboscobiblio.database.models.BookEntity;

import java.sql.*;
import java.util.List;

public class SaveMaterialService {
    public Integer saveBook(BookEntity bookEntity,Integer typeId){
       String materialQuery = "insert into material (title, material_type_id) values (?,?)";
       try(Connection conn = DatabaseConnection.getConnection()){
           // se guarda el material
           PreparedStatement ps = conn.prepareStatement(materialQuery, Statement.RETURN_GENERATED_KEYS);
           ps.setString(1, bookEntity.getTitle());
           ps.setInt(2, typeId);

           ps.executeUpdate();
           Integer newMaterialId = null;
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                   newMaterialId = rs.getInt(1);
                }
            }


           //se crea el record de la tabla libro
           String newBookQuery = "insert into books (material_id, author, isbn, publication_year, publisher, pages) values (?,?,?,?,?,?)";
           PreparedStatement psBook = conn.prepareStatement(newBookQuery, Statement.RETURN_GENERATED_KEYS);
           psBook.setInt(1, newMaterialId);
           psBook.setString(2, bookEntity.getAuthor());
           psBook.setString(3, bookEntity.getIsbn());
           psBook.setInt(4, bookEntity.getPublicationYear());
           psBook.setString(5, bookEntity.getPublisher());
           psBook.setInt(6, bookEntity.getPages());
           psBook.executeUpdate();

           return newMaterialId;
       }catch (SQLException e){
           throw new RuntimeException(e);
       }
    }
}
