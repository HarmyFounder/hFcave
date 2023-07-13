package com.hF.hFcave.models;

public enum TaskStatus {
    NO_STATUS("No Status"),
    NEXT_UP("Next Up"),
    IN_PROGRESS("In Progress"),
    COMPLETED("Completed");

    private String status;

    TaskStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
