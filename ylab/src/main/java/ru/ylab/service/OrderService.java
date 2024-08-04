package ru.ylab.service;

import ru.ylab.model.order.Order;
import ru.ylab.model.order.Status;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class OrderService {

    private ArrayList<Order> orders;

    public OrderService() {
        this.orders = new ArrayList<>();
    }

    public ArrayList<Order> getOrders() {
        return new ArrayList<>(orders);
    }

    public void add(Order order) {
        if (!find(order.getCarId())) {
            orders.add(order);
        } else {
            System.out.println("This model has already been ordered. Look for something else.");
        }
    }

    public boolean find(int carId) {
        for (Order order : orders) {
            if (order.getCarId() == carId) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Order> filterByDate(ArrayList<Order> src, Date date) {
        ArrayList<Order> outOrders = new ArrayList<>();
        for (Order order : src) {
            if (order.getDate() == date) {
                outOrders.add(order);
            }
        }
        return outOrders;
    }

    public ArrayList<Order> filterByClient(ArrayList<Order> src, String clientLogin) {
        ArrayList<Order> outOrders = new ArrayList<>();
        for (Order order : src) {
            if (Objects.equals(order.getClientLogin(), clientLogin)) {
                outOrders.add(order);
            }
        }
        return outOrders;
    }

    public ArrayList<Order> filterByStatus(ArrayList<Order> src, Status status) {
        ArrayList<Order> outOrders = new ArrayList<>();
        for (Order order : src) {
            if (order.getStatus() == status) {
                outOrders.add(order);
            }
        }
        return outOrders;
    }

    public ArrayList<Order> filterByCar(ArrayList<Order> src, int carId) {
        ArrayList<Order> outOrders = new ArrayList<>();
        for (Order order : src) {
            if (order.getCarId() == carId) {
                outOrders.add(order);
            }
        }
        return outOrders;
    }

    public void update(int id, Date date, Status status) {
        Order order = orders.get(id);
        order.setDate(date);
        order.setStatus(status);
        System.out.println("The order information has been changed.");
    }

    public void delete() {

    }

    public void display() {
        if (orders.isEmpty()) {
            System.out.println("The list has no orders.");
        }

        for (Order order : orders) {
            System.out.println(order);
        }
    }
}
