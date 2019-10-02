package com.company;

import com.company.students.StudentList;
import com.company.users.UserList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Menu {

    private StudentList studentList;
    private UserList userList;
    private BufferedReader in;
    private BufferedWriter out;

    public Menu(BufferedReader in, BufferedWriter out) {
        studentList = new StudentList();
        userList = new UserList();
        this.in = in;
        this.out = out;
    }

    public void run(){
        try {
            login();
            work();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void login() throws IOException {
        boolean log = false;
        String login = "noLogin";
        String pass = "1";
        while (!log){
            out.write("insert login: ");
            out.flush();
            login = in.readLine();
            out.write("insert password");
            out.flush();
            pass = in.readLine();
            log = userList.login(login, pass);
        }
        out.write("logged in");
        out.flush();
    }

    private void work() throws IOException {
        out.write(commands());
        out.flush();
        String command = in.readLine();
        while (!command.equals("exit")){
            switch (command){
                case "commands":
                    out.write(commands());
                    out.flush();
                    break;
                case "read":
                    readProfile();
                    break;
                case "change":
                    changeProfile();
                    break;
                case "add":
                    addProfile();
                    break;
                default:
                    out.write("bad command");
                    out.flush();
            }
            command = in.readLine();
        }
    }

    private String commands(){
        return "write 'commands' - to see commands\n" +
                "write 'read' - to read profile\n" +
                "write 'change' to change profile\n" +
                "write 'add' to add profile\n" +
                "write 'exit' - to exit\n";
    }

    private void readProfile() throws IOException {
        out.write("insert id");
        out.flush();
        int id = Integer.parseInt(in.readLine());
        out.write(studentList.getStudent(id));
        out.flush();
    }

    private void changeProfile() throws IOException {
        if (userList.isAdmin()){
            out.write("insert student id to change");
            out.flush();
            int id = Integer.parseInt(in.readLine());
            out.write("insert new name");
            out.flush();
            String name = in.readLine();
            out.write("insert new course");
            out.flush();
            int course = Integer.parseInt(in.readLine());
            studentList.changeStudent(id, name, course);
        } else {
            out.write("only admin can use this command");
            out.flush();
        }
    }

    private void addProfile() throws IOException {
        if (userList.isAdmin()){
            out.write("insert name");
            out.flush();
            String name = in.readLine();
            out.write("insert course");
            out.flush();
            int course = Integer.parseInt(in.readLine());
            studentList.addStudent(name, course);
        } else {
            out.write("only admin can use this command");
            out.flush();
        }
    }

}
