package com.company;

public class Main {

    /*
    client server app. archive with student profiles
    according with rights, print, change, add profile
    use socket to communicate client server
    save info in xml files
     */
    //server
    public static void main(String[] args) {
        //start server
        Server server = new Server();
        server.run();
        //start menu
        Menu menu = new Menu(server.getIn(), server.getOut());
        menu.run();
        //stop server
        server.stop();
    }

}
