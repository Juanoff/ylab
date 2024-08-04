package ru.ylab.model.order;

import java.util.Date;
import java.util.Objects;

public class Order {

    private Date date;
    private String clientLogin;
    private Status status;
    private int carId;

    public Order(Date date, String clientLogin, Status status, int carId) {
        this.date = date;
        this.clientLogin = clientLogin;
        this.status = status;
        this.carId = carId;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setClientLogin(String clientLogin) {
        this.clientLogin = clientLogin;
    }

    public String getClientLogin() {
        return clientLogin;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public int getCarId() {
        return carId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order order)) return false;
        return getCarId() == order.getCarId() && Objects.equals(getDate(), order.getDate()) && Objects.equals(getClientLogin(), order.getClientLogin()) && getStatus() == order.getStatus();
    }
}
