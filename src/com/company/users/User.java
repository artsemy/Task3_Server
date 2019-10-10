package com.company.users;

public class User {

    private int id;
    private String login;
    private String password;
    private boolean isAdmin;

    //constructor
    public User() {
        id = -1;
        login = "noLogin";
        password = "1";
        isAdmin = false;
    }

    //constructor
    public User(int id, String login, String password, boolean isAdmin) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    //get method
    public String getLogin() {
        return login;
    }

    //set method
    public void setLogin(String login) {
        this.login = login;
    }

    //get method
    public String getPassword() {
        return password;
    }

    //set method
    public void setPassword(String password) {
        this.password = password;
    }

    //get method
    public boolean isAdmin() {
        return isAdmin;
    }

    //set method
    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

}
