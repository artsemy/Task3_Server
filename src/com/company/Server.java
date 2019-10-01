package com.company;

import com.company.students.Student;
import com.company.students.StudentList;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private Socket clientSocket;
    private ServerSocket server;
    private BufferedReader in;
    private BufferedWriter out;
    private StudentList studentList;

    public Server() {
        studentList = new StudentList();
    }

    public void run(){
        try {
            try  {
                server = new ServerSocket(4004);
                System.out.println("Сервер запущен!");
//                clientSocket = server.accept();
                try {
//                    in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//                    out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                    parse();
                } finally {
                    System.out.println("finally");
//                    clientSocket.close();
//                    in.close();
//                    out.close();
                }
            } finally {
                System.out.println("Сервер закрыт!");
                server.close();
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    private void parse(){
        Student st = new Student("n5", 3, -1);
        studentList.addStudent(st);
//        try {
//            String word = in.readLine();
//            do {
//                System.out.println(word);
//                out.write("Привет, это Сервер! Подтверждаю, вы написали : " + word + "\n");
//                out.flush();
//            } while (!word.equals("exit"));
//        }catch(IOException e){
//            e.printStackTrace();
//        }
    }
}
