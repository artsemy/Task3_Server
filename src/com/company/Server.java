package com.company;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private Socket clientSocket;
    private ServerSocket server;
    private BufferedReader in;
    private BufferedWriter out;

    public BufferedReader getIn() {
        return in;
    }

    public BufferedWriter getOut() {
        return out;
    }

    public void run(){
        try {
            server = new ServerSocket(4004);
            clientSocket = server.accept();
            System.out.println("Server start");
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public void stop(){
        try {
            clientSocket.close();
            in.close();
            out.close();
            System.out.println("Server closed");
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
