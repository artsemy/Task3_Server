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
            out.write("insert login:\n");
            out.flush();
            login = in.readLine();
            out.write("insert password:\n");
            out.flush();
            pass = in.readLine();
            log = userList.login(login, pass);
        }
    }

    private void work() throws IOException {
        String c = commands();
        out.write(c);
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
                    out.write("bad command\n");
                    out.flush();
            }
            command = in.readLine();
        }
    }

    private String commands(){
        return "write 'commands' - to see commands | " +
                "write 'read' - to read profile | " +
                "write 'change' to change profile | " +
                "write 'add' to add profile | " +
                "write 'exit' - to exit \n";
    }

    private void readProfile() throws IOException {
        out.write("insert id\n");
        out.flush();
        int id = Integer.parseInt(in.readLine());
        out.write(studentList.getStudent(id) + "\n");
        out.flush();
    }

    private void changeProfile() throws IOException {
        if (userList.isAdmin()){
            boolean b = false;
            while (!b) {
                out.write("insert student id to change\n");
                out.flush();
                int id = Integer.parseInt(in.readLine());
                out.write("insert new name\n");
                out.flush();
                String name = in.readLine();
                out.write("insert new course\n");
                out.flush();
                int course = Integer.parseInt(in.readLine());
                b = studentList.changeStudent(id, name, course);
            }
            out.write("changed\n");
            out.flush();
        } else {
            out.write("only admin can use this command\n");
            out.flush();
        }
    }

    private void addProfile() throws IOException {
        if (userList.isAdmin()){
            out.write("insert name\n");
            out.flush();
            String name = in.readLine();
            out.write("insert course\n");
            out.flush();
            int course = Integer.parseInt(in.readLine());
            studentList.addStudent(name, course);
            out.write("added\n");
            out.flush();
        } else {
            out.write("only admin can use this command\n");
            out.flush();
        }
    }

}
