package com.aurora.donboscobiblio.database;

import com.aurora.donboscobiblio.database.models.LoanConfigEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoansService {

    public void createLoanConfig(LoanConfigEntity loanConfigEntity){
        String query = "insert into loans_conditions(days_limit, tax_penalty_per_day, active_loans_limit, enabled, role_id) values(?,?,?,?,?)";
        try(Connection conn = DatabaseConnection.getConnection()){
           PreparedStatement ps = conn.prepareStatement(query);
           ps.setInt(1, loanConfigEntity.getDaysLimit());
           ps.setDouble(2, loanConfigEntity.getTaxPenaltyPerDay());
           ps.setInt(3, loanConfigEntity.getActiveLoansLimit());
           ps.setBoolean(4, loanConfigEntity.isEnabled());
           ps.setInt(5, loanConfigEntity.getRoleId());
           ps.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<LoanConfigEntity> listLoanConfig(){
        String query = "select * from loans_conditions";
        List<LoanConfigEntity> loanConfigEntityList = new ArrayList<>();
         try(Connection conn = DatabaseConnection.getConnection()){
           PreparedStatement ps = conn.prepareStatement(query);
           ResultSet rs = ps.executeQuery();

           while(rs.next()){
              loanConfigEntityList.add(new LoanConfigEntity(rs.getInt("id"),
                      rs.getInt("days_limit"),
                      rs.getDouble("tax_penalty_per_day"),
                      rs.getInt("active_loans_limit"),
                      rs.getInt("role_id"),
                      rs.getBoolean("enabled")));
           }
         return loanConfigEntityList;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void updateLoanConfig(LoanConfigEntity loanConfigEntity){
        String query = "update loans_conditions set days_limit = ?, tax_penalty_per_day= ?, active_loans_limit = ?, enabled = ? where id = ?";
        try(Connection conn = DatabaseConnection.getConnection()){
           PreparedStatement ps = conn.prepareStatement(query);
           ps.setInt(1, loanConfigEntity.getDaysLimit());
           ps.setDouble(2, loanConfigEntity.getTaxPenaltyPerDay());
           ps.setInt(3, loanConfigEntity.getActiveLoansLimit());
           ps.setBoolean(4, loanConfigEntity.isEnabled());
           ps.setInt(5, loanConfigEntity.getId());

           ps.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
