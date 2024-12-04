package com.aurora.donboscobiblio.database;

import com.aurora.donboscobiblio.database.models.UserEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersService {

    public List<UserEntity> getUsers(int page, int limit) {
       int offset = (page - 1) * limit;
       String sql = "select u.id, u.username, ur.role_name as role from users u inner join users_roles ur on ur.id = u.role_id order by u.id limit "+limit+" offset "+offset;
       List<UserEntity> users = new ArrayList<>();
       try(Connection conn = DatabaseConnection.getConnection()){
           PreparedStatement ps = conn.prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           while(rs.next()){
              users.add(new UserEntity(rs.getInt("id"), rs.getString("username"), rs.getString("role")));
           }

           return users;
       }catch (SQLException e){
           throw new RuntimeException(e);
       }
    }

    public void updateUserPassword(int id, String newPassword) {
        String sql = "update users set user_password = ? where id = ?";
        try(Connection conn = DatabaseConnection.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, newPassword);
            ps.setInt(2, id);
            ps.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}