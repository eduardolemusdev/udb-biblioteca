package com.aurora.donboscobiblio.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoriesService {
    public Map<Integer, String> getMaterialTypes() {
        String query = "select * from material_type";
        Map<Integer, String> materialType= new HashMap<>();
        try(Connection conn = DatabaseConnection.getConnection()){
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
               materialType.put(rs.getInt("id"), rs.getString("name"));
            }

            return materialType;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    public Map<Integer, String> getCategories() {
        String query = "select * from categories";
        Map<Integer, String> categories = new HashMap<>();
        try(Connection conn = DatabaseConnection.getConnection()){
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
               categories.put(rs.getInt("id"), rs.getString("name"));
            }

            return categories;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void saveMaterialCategories(List<Integer> categories, Integer materialId){
        categories.forEach(categoryId->{

            String query = "insert into material_categories(material_id,category_id) values(?,?)";
            PreparedStatement ps = null;
            try(Connection conn = DatabaseConnection.getConnection()){
               ps = conn.prepareStatement(query);
               ps.setInt(1, materialId);
               ps.setInt(2, categoryId);
               ps.executeUpdate();
            }catch (SQLException e){
                throw new RuntimeException(e);
            }

        });
    }
}
