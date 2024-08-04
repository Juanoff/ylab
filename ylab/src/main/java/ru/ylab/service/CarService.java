package ru.ylab.service;

import ru.ylab.model.car.Car;
import ru.ylab.model.car.Status;

import java.util.ArrayList;
import java.util.Objects;

public class CarService {

    private ArrayList<Car> cars;

    public CarService() {
        this.cars = new ArrayList<>();
    }

    public void insert(Car car) {
        if (!find(car.getId())) {
            cars.add(car);
        } else {
            System.out.println("This car is already on the list");
        }
    }

    public boolean find(int carId) {
        for (Car car : cars) {
            if (car.getId() == carId) {
                return true;
            }
        }
        return false;
    }

    public Car findByMake(String make) {
        for (Car car : cars) {
            if (Objects.equals(car.getMake(), make)) {
                return car;
            }
        }
        return null;
    }

    public Car findByModel(String model) {
        for (Car car : cars) {
            if (Objects.equals(car.getModel(), model)) {
                return car;
            }
        }
        return null;
    }

    public Car findByYear(int year) {
        for (Car car : cars) {
            if (car.getYear() == year) {
                return car;
            }
        }
        return null;
    }

    public Car findByPrice(int price) {
        for (Car car : cars) {
            if (car.getPrice() == price) {
                return car;
            }
        }
        return null;
    }

    public Car findByStatus(Status status) {
        for (Car car : cars) {
            if (car.getStatus() == status) {
                return car;
            }
        }
        return null;
    }

    public ArrayList<Car> filterByMake(String make) {
        ArrayList<Car> outCars = new ArrayList<>();
        for (Car car : cars) {
            if (Objects.equals(car.getMake(), make)) {
                outCars.add(car);
            }
        }
        return outCars;
    }

    public ArrayList<Car> filterByModel(String model) {
        ArrayList<Car> outCars = new ArrayList<>();
        for (Car car : cars) {
            if (Objects.equals(car.getModel(), model)) {
                outCars.add(car);
            }
        }
        return outCars;
    }

    public ArrayList<Car> filterByYear(int year) {
        ArrayList<Car> outCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getYear() == year) {
                outCars.add(car);
            }
        }
        return outCars;
    }

    public ArrayList<Car> filterByPrice(int price) {
        ArrayList<Car> outCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPrice() == price) {
                outCars.add(car);
            }
        }
        return outCars;
    }

    public ArrayList<Car> filterByStatus(Status status) {
        ArrayList<Car> outCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getStatus() == status) {
                outCars.add(car);
            }
        }
        return outCars;
    }

    public void delete(String delModel) {
        Car delCar = null;
        for (Car curCar : cars) {
            if (Objects.equals(curCar.getModel(), delModel)) {
                delCar = curCar;
            }
        }

        if (delCar == null) {
            System.out.println("Invalid car model");
        } else {
            cars.remove(delCar);
            System.out.println("Successfully deleted car from the list");
        }
    }


//    public void update(int id, Scanner input) {
//        if (findRecord(id)) {
//            Record rec = findRecord(id);
//
//            System.out.print("What is the new Student id Number ? ");
//            int idNumber = input.nextInt();
//
//            // Display message only
//            System.out.print("What is the new Student contact Number ");
//            int contactNumber = input.nextInt();
//            input.nextLine();
//
//            // Display message only
//            System.out.print(
//                    "What is the new Student Name ? ");
//            String name = input.nextLine();
//
//            rec.setIdNumber(idNumber);
//            rec.setName(name);
//            rec.setContactNumber(contactNumber);
//            System.out.println("Record Updated Successfully");
//        } else {
//            System.out.println("Record Not Found in the Student list");
//        }
//    }

    public void display() {
        if (cars.isEmpty()) {
            System.out.println("The list has no cars\n");
        }

        for (Car car : cars) {
            System.out.println(car.toString());
        }
    }
}
