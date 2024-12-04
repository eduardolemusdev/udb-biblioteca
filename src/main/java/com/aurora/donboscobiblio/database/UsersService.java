package com.aurora.donboscobiblio.database;

import com.aurora.donboscobiblio.database.models.UserEntity;

import java.sql.*;
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

    public Integer usersCount(){
         String query = "SELECT COUNT(*) AS total FROM users";
         Integer count = 0;
         try(Connection conn = DatabaseConnection.getConnection()){
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                count = rs.getInt("total");
            }

            return count;
         }catch (SQLException e){
             throw new RuntimeException(e);
         }
    }

    public void insertUser(String username, String password, Integer roleId) {
        String sql = "insert into users (username, user_password, role_id) values(?,?,?)";
        try(Connection conn = DatabaseConnection.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setInt(3, roleId);
            ps.executeUpdate();
        }catch (SQLIntegrityConstraintViolationException e){
            throw new RuntimeException("Nombre de usuario ya existe, tiene que escoger otro.");
        }catch (SQLException e){
            throw new RuntimeException("Error al insertar el usuario, intentelo nuevamente");
        }
    }
}
