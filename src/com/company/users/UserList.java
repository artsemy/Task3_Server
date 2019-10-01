package com.company.users;

import java.util.ArrayList;

public class UserList {

    private ArrayList<User> users;
    private User user;

    public UserList() {
        users = new ArrayList<User>();
        init();
    }

    public UserList(ArrayList<User> users) {
        this.users = users;
    }

    public boolean login(String name, String password){
        for (User u: users) {
            if (u.getLogin().equals(name) && u.getPassword().equals(password)){
                user = u;
                return true;
            }
        }
        return false;
    }

    private void init(){
    }
}
