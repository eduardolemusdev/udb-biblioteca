package com.aurora.donboscobiblio.database.models;

import com.aurora.donboscobiblio.database.UserRolesService;

public class LoanConfigEntity {
    int id;
    int daysLimit = 7;
    double taxPenaltyPerDay = 0.25;
    int activeLoansLimit = 3;
    int roleId;
    boolean enabled = false;

    public LoanConfigEntity() {}

    public LoanConfigEntity(int daysLimit, double taxPenaltyPerDay, int activeLoansLimnit, int roleId) {
        this.daysLimit = daysLimit;
        this.taxPenaltyPerDay = taxPenaltyPerDay;
        this.activeLoansLimit = activeLoansLimnit;
        this.roleId = roleId;
    }
    public LoanConfigEntity(int id, int daysLimit, double taxPenaltyPerDay, int activeLoansLimnit, int roleId, boolean enabled) {
        this.id = id;
        this.daysLimit = daysLimit;
        this.taxPenaltyPerDay = taxPenaltyPerDay;
        this.activeLoansLimit = activeLoansLimnit;
        this.roleId = roleId;
        this.enabled = enabled;
    }

    public int getDaysLimit() {
        return daysLimit;
    }

    public void setDaysLimit(int daysLimit) {
        this.daysLimit = daysLimit;
    }

    public double getTaxPenaltyPerDay() {
        return taxPenaltyPerDay;
    }

    public void setTaxPenaltyPerDay(double taxPenaltyPerDay) {
        this.taxPenaltyPerDay = taxPenaltyPerDay;
    }

    public int getActiveLoansLimit() {
        return activeLoansLimit;
    }

    public void setActiveLoansLimit(int activeLoansLimit) {
        this.activeLoansLimit = activeLoansLimit;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName(){
        UserRolesService userRolesService = new UserRolesService();
        String role = userRolesService.getRoleById(this.roleId);
        return role;
    }

    @Override
    public String toString() {
        return super.toString() +" => "+ id+ "/" + daysLimit + "/" + taxPenaltyPerDay + "/" + activeLoansLimit + "/" + roleId;
    }
}
