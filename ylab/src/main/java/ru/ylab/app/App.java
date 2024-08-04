package ru.ylab.app;

import ru.ylab.model.order.Order;
import ru.ylab.model.order.Status;
import ru.ylab.model.user.Role;
import ru.ylab.model.user.User;
import ru.ylab.service.CarService;
import ru.ylab.service.ClientService;
import ru.ylab.service.OrderService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Objects;

public class App {

    private static App instance;
    private ClientService clientService;
    private CarService carService;
    private OrderService orderService;
    private User user;

    private App() {
        this.clientService = new ClientService();
        this.carService = new CarService();
        this.orderService = new OrderService();
    }

    public static void createInstance() {
        if (instance == null) {
            instance = new App();
        }
    }

    public static App getInstance() {
        return instance;
    }

    private void startCommands() {
        System.out.println("Enter the command number: ");
        System.out.println("1. Sign in");
        System.out.println("2. Sign up");
        System.out.println("3. Exit");
    }

    private void userCommands() {
        System.out.println("Enter the command number: ");
        System.out.println("1. View a list of cars");
        System.out.println("2. Creating a car purchase order");
        System.out.println("3. Viewing orders");
        System.out.println("4. Cancel the order");
        System.out.println("5. Proceed to order payment");

        System.out.println("6. Log out");
        System.out.println("7. Exit");
    }

    private void managerCommands() {
        System.out.println("Enter the command number: ");
        System.out.println("1. View a list of cars");
        System.out.println("2. Creating a car purchase order");
        System.out.println("33. Log out");
        System.out.println("34. Exit");
    }

    private void administratorCommands() {
        System.out.println("Enter the command number: ");
        System.out.println("1. View the list of registered clients and employees");
        System.out.println("2. Creating a car purchase order");
        System.out.println("33. Log out");
        System.out.println("34. Exit");
    }

    private boolean signIn(BufferedReader in) throws IOException {
        boolean isExit = true;
        System.out.print("login: ");
        String login = in.readLine();
        System.out.print("password: ");
        String password = in.readLine();
        user = clientService.find(login, password);
        if (user != null) {
            System.out.println("You have successfully sign in.");
            isExit = userMenu(in);
        } else {
            System.out.println("This user is not registered.");
        }
        return isExit;
    }

    private boolean signUp(BufferedReader in) throws IOException {
        boolean isExit = true;
        System.out.print("login: ");
        String login = in.readLine();
        System.out.print("password: ");
        String password = in.readLine();
        System.out.print("role: ");
        Role role;
        if (Objects.equals(in.readLine(), Role.ADMINISTRATOR.getRole())) {
            role = Role.ADMINISTRATOR;
        } else if (Objects.equals(in.readLine(), Role.MANAGER.getRole())) {
            role = Role.MANAGER;
        } else {
            role = Role.CLIENT;
        }
        System.out.print("name: ");
        String name = in.readLine();
        System.out.print("email: ");
        String email = in.readLine();

        user = clientService.add(new User(name, email, login, password, role));
        if (user != null) {
            System.out.println("You have successfully sign up.");
        } else {
            System.out.println("This user is already registered.");
        }
        return isExit;
    }

    public void menu() throws IOException {
        startCommands();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        boolean isExit = false;
        while (!isExit) {
            int command = Integer.parseInt(in.readLine());
            switch (command) {
                case 1 -> {
                    isExit = signIn(in);
                }
                case 2 -> {
                    isExit = signUp(in);
                }
                case 3 -> {
                    isExit = true;
                }
            }
        }
    }

    private boolean userMenu(BufferedReader in) throws IOException {
        userCommands();
        boolean isExit = false;
        while (!isExit) {
            int command = Integer.parseInt(in.readLine());
            switch (command) {
                case 1 -> {
                    carService.display();
                }
                case 2 -> {
                    System.out.print("Enter car id: ");
                    int carId = Integer.parseInt(in.readLine());
                    orderService.add(new Order(new Date(), user.getLogin(), Status.UNPAID, carId));
                }
                case 3 -> {
                    orderService.display();
                }
                case 4 -> {
                    System.out.print("Enter order id: ");
                    int id = Integer.parseInt(in.readLine());
                    orderService.update(id, new Date(), Status.CANCELED);
                }
                case 5 -> {
                    System.out.print("Enter order id: ");
                    int id = Integer.parseInt(in.readLine());
                    orderService.update(id, new Date(), Status.PAID);
                    user.setPurchaseNum(user.getPurchaseNum() + 1);
                }
                case 34 -> {
                    isExit = true;
                }
            }
        }
        return isExit;
    }
}
