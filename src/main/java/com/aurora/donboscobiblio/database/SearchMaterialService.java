package com.aurora.donboscobiblio.database;

import com.aurora.donboscobiblio.database.models.BookEntity;
import com.aurora.donboscobiblio.database.models.DvdEntity;
import com.aurora.donboscobiblio.database.models.MaterialEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SearchMaterialService {

    public List<MaterialEntity> searchById(Integer criteria){
        String query = "select * from material where id = "+criteria;

        Integer materialId = null;
        String materialType = null;
        String materialTitle = null;

        try(Connection conn = DatabaseConnection.getConnection()){
           PreparedStatement ps = conn.prepareStatement(query);
           ResultSet rs = ps.executeQuery();
           List<MaterialEntity> result = new ArrayList<>();

           while(rs.next()){

               materialId = rs.getInt("id");
               materialTitle = rs.getString("title");

               String queryToGetMaterialType = "select * from material_type where id = "+rs.getInt("material_type_id");
               PreparedStatement psToGetMaterial = conn.prepareStatement(queryToGetMaterialType);
               ResultSet rsMaterial = psToGetMaterial.executeQuery();
               

               while(rsMaterial.next()){
                   materialType = rsMaterial.getString("name");
               }

               switch (materialType){
                   case "libro":
                        String bookQuery = "select * from books where material_id = "+materialId;
                        PreparedStatement psToGetBook = conn.prepareStatement(bookQuery);
                        ResultSet rsBook = psToGetBook.executeQuery();

                        while(rsBook.next()){
                            result.add(new BookEntity(materialId,materialTitle,materialType,
                                    rsBook.getString("author"),
                                    rsBook.getString("isbn"),
                                    rsBook.getInt("publication_year"),
                                    rsBook.getString("publisher"),
                                    rsBook.getInt("pages")));
                        }
                       break;
                    case "cd":
                        String cdsQuery = "select * from cds where material_id = "+materialId;

                       break;
                   case "dvd":
                       String dvdQuery = "select * from dvds where material_id = "+materialId;
                       break;
                   case "tesis":
                       String tesisQuery = "select * from theses where material_id = "+materialId;
                       break;
               }
               
           }

           result.forEach(e -> System.out.println(e.toString()));

           return result;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<MaterialEntity> searchByTitle(String criteria){
       String query = "select * from material where title ILIKE '%"+criteria+"%'";
       Integer materialId = null;
        String materialType = null;
        String materialTitle = null;

        List<MaterialEntity> result = new ArrayList<>();
        try(Connection conn = DatabaseConnection.getConnection()){
           PreparedStatement ps = conn.prepareStatement(query);
           ResultSet rs = ps.executeQuery();

           while(rs.next()){
               System.out.println(rs.getString("title"));
               materialId = rs.getInt("id");
               materialTitle = rs.getString("title");

               String queryToGetMaterialType = "select * from material_type where id = "+rs.getInt("material_type_id");
               PreparedStatement psToGetMaterial = conn.prepareStatement(queryToGetMaterialType);
               ResultSet rsMaterial = psToGetMaterial.executeQuery();


               while(rsMaterial.next()){
                   materialType = rsMaterial.getString("name");
               }


               switch (materialType){
                   case "libro":
                        String bookQuery = "select * from books where material_id = "+materialId;
                        PreparedStatement psToGetBook = conn.prepareStatement(bookQuery);
                        ResultSet rsBook = psToGetBook.executeQuery();

                        while(rsBook.next()){
                            result.add(new BookEntity(materialId,materialTitle,materialType,
                                    rsBook.getString("author"),
                                    rsBook.getString("isbn"),
                                    rsBook.getInt("publication_year"),
                                    rsBook.getString("publisher"),
                                    rsBook.getInt("pages")));
                        }
                       break;
                    case "cd":
                        String cdsQuery = "select * from cds where material_id = "+materialId;

                       break;
                   case "dvd":
                       System.out.println("Dvds: "+materialId);
                       String dvdQuery = "select * from dvds where material_id = "+materialId;
                       PreparedStatement psDvd = conn.prepareStatement(dvdQuery);
                       ResultSet rsDvd = psDvd.executeQuery();
                        while(rsDvd.next()){
                            result.add(new DvdEntity(materialId,materialTitle,materialType,
                                    rsDvd.getString("director"),
                                    rsDvd.getString("genre"),
                                    rsDvd.getString("release_year"),
                                    rsDvd.getInt("duration")));
                        }
                       break;
                   case "tesis":
                       String tesisQuery = "select * from theses where material_id = "+materialId;

                       break;
               }

           }

           result.forEach(e -> System.out.println(e.toString()));

           return result;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
