package com.company;

public class Main {

    public static void main(String[] args) {
        Server server = new Server();
        server.run();
        Menu menu = new Menu(server.getIn(), server.getOut());
        menu.run();
        server.stop();
    }
}
