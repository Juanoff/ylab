package ru.ylab.model.user;

public enum Role {
    ADMINISTRATOR("Administrator"),
    MANAGER("Manager"),
    CLIENT("Client");

    private final String role;

    Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "Role{" + "role='" + role + '\'' + '}';
    }
}