package ru.ylab.model.user;

public class User implements Comparable<User> {

    private String name;
    private String email;
    private String login;
    private String password;
    private Role role;
    private int purchaseNum;

    public User(String name, String email, String login, String password, Role role) {
        this.name = name;
        this.email = email;
        this.login = login;
        this.password = password;
        this.role = role;
        this.purchaseNum = 0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public int getPurchaseNum() {
        return purchaseNum;
    }

    public void setPurchaseNum(int purchaseNum) {
        this.purchaseNum = purchaseNum;
    }

    @Override
    public String toString() {
        return "User{" +
                "role=" + role +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(User o) {
        return o.name.compareTo(this.name);
    }
}