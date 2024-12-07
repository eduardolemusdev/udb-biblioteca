package com.aurora.donboscobiblio.database.dtos;

public class CreateMaterialLoanDto {
    private Integer loanConditionsId;
    private Integer materialId;
    private Integer daysLimit;
    private Integer userId;
    private Integer maxActiveLoans;

    public Integer getMaxActiveLoans() {
        return maxActiveLoans;
    }

    public void setMaxActiveLoans(Integer maxActiveLoans) {
        this.maxActiveLoans = maxActiveLoans;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }


    public CreateMaterialLoanDto() {}

    public Integer getLoanConditionsId() {
        return loanConditionsId;
    }

    public void setLoanConditionsId(Integer loanConditionsId) {
        this.loanConditionsId = loanConditionsId;
    }

    public Integer getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Integer materialId) {
        this.materialId = materialId;
    }

    public Integer getDaysLimit() {
        return daysLimit;
    }

    public void setDaysLimit(Integer daysLimit) {
        this.daysLimit = daysLimit;
    }
}
