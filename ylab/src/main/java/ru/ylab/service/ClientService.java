package ru.ylab.service;

import ru.ylab.model.user.Role;
import ru.ylab.model.user.User;

import java.util.*;

public class ClientService {

    private HashMap<String, User> registeredUsers;

    public ClientService() {
        this.registeredUsers = new HashMap<>();
    }

    public User add(User user) {
        if (!registeredUsers.containsKey(user.getLogin())) {
            registeredUsers.put(user.getLogin(), user);
            return user;
        }
        return null;
    }

    public User find(String login, String password) {
        if (registeredUsers.containsKey(login) && registeredUsers.get(login).getPassword().equals(password)) {
            return registeredUsers.get(login);
        }
        return null;
    }

    public ArrayList<User> filterByName(String name) {
        ArrayList<User> outUsers = new ArrayList<>();
        for (Map.Entry<String, User> user : registeredUsers.entrySet()) {
            if (user.getValue().getName().equals(name)) {
                outUsers.add(user.getValue());
            }
        }
        return outUsers;
    }

    public ArrayList<User> filterByEmail(String email) {
        ArrayList<User> outUsers = new ArrayList<>();
        for (Map.Entry<String, User> user : registeredUsers.entrySet()) {
            if (user.getValue().getEmail().equals(email)) {
                outUsers.add(user.getValue());
            }
        }
        return outUsers;
    }

    public ArrayList<User> filterByPurchaseNum(int purchaseNum) {
        ArrayList<User> outUsers = new ArrayList<>();
        for (Map.Entry<String, User> user : registeredUsers.entrySet()) {
            if (user.getValue().getPurchaseNum() == purchaseNum) {
                outUsers.add(user.getValue());
            }
        }
        return outUsers;
    }

    public ArrayList<User> sortByName() {
        ArrayList<User> outUsers = new ArrayList<>(registeredUsers.values());
        Collections.sort(outUsers);
        return outUsers;
    }

    public ArrayList<User> sortByEmail() {
        ArrayList<User> outUsers = new ArrayList<>(registeredUsers.values());
        outUsers.sort(Comparator.comparing(User::getEmail));
        return outUsers;
    }

    public ArrayList<User> sortByPurchaseNum() {
        ArrayList<User> outUsers = new ArrayList<>(registeredUsers.values());
        outUsers.sort(Comparator.comparing(User::getPurchaseNum));
        return outUsers;
    }

    public ArrayList<User> sortByLogin() {
        ArrayList<User> outUsers = new ArrayList<>(registeredUsers.values());
        outUsers.sort(Comparator.comparing(User::getLogin));
        return outUsers;
    }

    public void update(String name, String email, String login, String password, Role role) {
        if (registeredUsers.containsKey(login)) {
            User user = registeredUsers.get(login);
            user.setName(name);
            user.setEmail(email);
            user.setLogin(login);
            user.setPassword(password);
            user.setRole(role);
        } else {
            System.out.println("This user is not registered.");
        }
    }

    public User delete(String login) {
        return registeredUsers.remove(login);
    }

    public void display() {
        for (Map.Entry<String, User> user : registeredUsers.entrySet()) {
            System.out.println(user.getValue().toString());
        }
    }
}
