package ru.ylab.model.order;

public enum Status {
    UNPAID("Unpaid"),
    PAID("Paid"),
    CANCELED("Canceled");

    private final String status;

    Status(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Status{" + "status='" + status + '\'' + '}';
    }
}
