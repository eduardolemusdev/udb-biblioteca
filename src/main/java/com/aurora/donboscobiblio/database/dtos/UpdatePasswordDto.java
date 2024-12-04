package com.aurora.donboscobiblio.database.dtos;

public class UpdatePasswordDto {
    private int userId;
    private String newPassword;
    public UpdatePasswordDto() {}
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }


    @Override
    public String toString() {
        return super.toString() + "UpdatePasswordDto [userId=" + userId + ", newPassword=" + newPassword + "]";
    }
}
