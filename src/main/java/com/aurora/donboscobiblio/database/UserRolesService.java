package com.aurora.donboscobiblio.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class UserRolesService {

    public Map<Integer, String> getRoles(){
        String query = "select * from users_roles";
        Map<Integer, String> usersRoles = new HashMap<>();
        try(Connection conn = DatabaseConnection.getConnection()){
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
               usersRoles.put(rs.getInt("id"), rs.getString("role_name"));
            }

            return usersRoles;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public String getRoleById(int id){
        String query = "select * from users_roles where id = ?";
        String roleName = null;
        try(Connection conn = DatabaseConnection.getConnection()){
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
               roleName = rs.getString("role_name");
            }

            return roleName;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
