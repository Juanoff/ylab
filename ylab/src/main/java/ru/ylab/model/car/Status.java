package ru.ylab.model.car;

public enum Status {
    RUNDOWN("Rundown"),
    NEW("New");

    private final String status;

    Status(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Status{" + "status='" + status + '\'' + '}';
    }
}
