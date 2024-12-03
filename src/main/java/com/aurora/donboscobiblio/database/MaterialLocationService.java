package com.aurora.donboscobiblio.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class MaterialLocationService {
    public Map<Integer,String> getBuildings(){
        String query = "select * from material_building";
        Map<Integer,String> buildings = new HashMap<Integer,String>();

        try(Connection conn = DatabaseConnection.getConnection()){
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                buildings.put(rs.getInt("id"), rs.getString("building_name"));
            }
            return buildings;
        }catch (SQLException e){
            throw  new RuntimeException(e);
        }
    }

    public Map<Integer,Integer> getBuildingFloors(){
        String query = "select * from material_floor";
        Map<Integer,Integer> buildings = new HashMap<Integer,Integer>();

        try(Connection conn = DatabaseConnection.getConnection()){
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                buildings.put(rs.getInt("id"), rs.getInt("building_floor"));
            }
            return buildings;
        }catch (SQLException e){
            throw  new RuntimeException(e);
        }
    }

    public Map<Integer,Integer> getBuildingShelfs(){
        String query = "select * from material_shelf";
        Map<Integer,Integer> shelfs= new HashMap<Integer,Integer>();

        try(Connection conn = DatabaseConnection.getConnection()){
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                shelfs.put(rs.getInt("id"), rs.getInt("shelf_level"));
            }
            return shelfs;
        }catch (SQLException e){
            throw  new RuntimeException(e);
        }
    }
}
