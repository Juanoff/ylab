package ru.ylab.model.car;

public class Car {
    private int id;
    private String make;
    private String model;
    private int year;
    private int price;
    private Status status;

    public Car(int id, String make, String model, int year, int price, Status status) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public int getPrice() {
        return price;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", status=" + status +
                '}';
    }
}