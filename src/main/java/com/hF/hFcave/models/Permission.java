package com.hF.hFcave.models;

public enum Permission {

    USERS_READ("users:read"), USERS_WRITE("users:write");


    private String permission;

    public String getPermission() {
        return permission;
    }

    Permission(String permission) {
        this.permission = permission;
    }
}
