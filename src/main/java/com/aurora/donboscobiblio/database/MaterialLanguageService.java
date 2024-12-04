package com.aurora.donboscobiblio.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaterialLanguageService {
    public Map<Integer, String> getMaterialLanguages() {
        String query = "select * from languages";
        Map<Integer, String> mapLanguages = new HashMap<>();
        try (Connection conn = DatabaseConnection.getConnection()){
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                mapLanguages.put(rs.getInt("id"), rs.getString("name"));
            }
            return  mapLanguages;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
     public void saveMaterialLanguages(List<Integer> languages, Integer materialId){
        languages.forEach(languageId->{

            String query = "insert into material_languages(material_id,language_id) values(?,?)";
            PreparedStatement ps = null;
            try(Connection conn = DatabaseConnection.getConnection()){
               ps = conn.prepareStatement(query);
               ps.setInt(1, materialId);
               ps.setInt(2, languageId);
               ps.executeUpdate();
            }catch (SQLException e){
                throw new RuntimeException(e);
            }

        });
    }
}
