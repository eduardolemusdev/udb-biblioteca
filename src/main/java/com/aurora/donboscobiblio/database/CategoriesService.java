package com.aurora.donboscobiblio.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class CategoriesService {

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
}
