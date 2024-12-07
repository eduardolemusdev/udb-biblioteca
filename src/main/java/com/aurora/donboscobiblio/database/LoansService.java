package com.aurora.donboscobiblio.database;

import com.aurora.donboscobiblio.database.dtos.CreateMaterialLoanDto;
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

    public List<LoanConfigEntity> getLoanConfigByUserRoleId(int id){
       String query = "select * from loans_conditions where role_id = ? and enabled = true";
       List<LoanConfigEntity> loanConfigEntityList = new ArrayList<>();
       try(Connection conn = DatabaseConnection.getConnection()){
          PreparedStatement ps = conn.prepareStatement(query);
          ps.setInt(1, id);

          ResultSet rs = ps.executeQuery();
          while(rs.next()){
             LoanConfigEntity loanConfigEntity = new LoanConfigEntity();
             loanConfigEntity.setDaysLimit(rs.getInt("days_limit"));
             loanConfigEntity.setTaxPenaltyPerDay(rs.getDouble("tax_penalty_per_day"));
             loanConfigEntity.setActiveLoansLimit(rs.getInt("active_loans_limit"));
             loanConfigEntity.setId(rs.getInt("id"));
             loanConfigEntity.setRoleId(rs.getInt("role_id"));
             loanConfigEntity.setEnabled(rs.getBoolean("enabled"));
             loanConfigEntity.setDescription(rs.getString("description"));
             loanConfigEntityList.add(loanConfigEntity);
          }

          return loanConfigEntityList;
       }catch (SQLException e){
           throw new RuntimeException(e);
       }

    }

    public void createMaterialLoan(CreateMaterialLoanDto createMaterialLoanDto){

        String query = "SELECT COUNT(*) AS total_pending_loans " +
                "FROM users u " +
                "INNER JOIN loans l ON l.user_id = u.id " +
                "INNER JOIN loans_conditions lc ON lc.id = l.loans_conditions_id " +
                "INNER JOIN loans_details ld ON ld.loan_id = l.id " +
                "INNER JOIN material m ON m.id = ld.material_id " +
                "WHERE ld.status = 'pending' AND l.date_return_estimated - CURRENT_DATE < 0 and l.user_id = ?;";

        String maxActiveLoansWithoutMora = "SELECT COUNT(*) AS total_pending_loans " +
                "FROM users u " +
                "INNER JOIN loans l ON l.user_id = u.id " +
                "INNER JOIN loans_conditions lc ON lc.id = l.loans_conditions_id " +
                "INNER JOIN loans_details ld ON ld.loan_id = l.id " +
                "INNER JOIN material m ON m.id = ld.material_id " +
                "WHERE ld.status = 'pending' and l.user_id = ?;";

        Integer loansInMora = 0;
        Integer maxActiveLoans = 0;

        try(Connection conn = DatabaseConnection.getConnection()){
           PreparedStatement ps = conn.prepareStatement(query);
           ps.setInt(1, createMaterialLoanDto.getUserId());
           ResultSet rs = ps.executeQuery();
           if(rs.next()){
              loansInMora = rs.getInt("total_pending_loans");
           }

           if(loansInMora > 0){
               throw new SQLException("No se peude realizar el prestamo el usuario tiene devoluciones pendientes");
           }

           PreparedStatement psMaxLoansPerConfig = conn.prepareStatement(maxActiveLoansWithoutMora);
           psMaxLoansPerConfig.setInt(1, createMaterialLoanDto.getUserId());
           ResultSet rsMaxLoansPerConfig = psMaxLoansPerConfig.executeQuery();

           if(rsMaxLoansPerConfig.next()){
               maxActiveLoans = rsMaxLoansPerConfig.getInt("total_pending_loans");
           }

           if(maxActiveLoans >= createMaterialLoanDto.getMaxActiveLoans()){
               throw new SQLException("No se peude realizar el prestamo: maximo de prestamos alcanzado");
           }

           String createLoanQuery = "insert into loans (date_return_estimated, loans_conditions_id, user_id) values (?,?,?)";
           PreparedStatement psCreateLoan = conn.prepareStatement(createLoanQuery);
           psCreateLoan.setString(1, "current_date +"+createMaterialLoanDto.getDaysLimit());
           psCreateLoan.setInt(2, createMaterialLoanDto.getLoanConditionsId());
           psCreateLoan.setInt(3, createMaterialLoanDto.getUserId());
           psCreateLoan.executeUpdate();

        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }

    }
}
