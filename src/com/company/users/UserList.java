package com.company.users;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class UserList {

    private ArrayList<User> users;
    private User user;

    public UserList() {
        users = new ArrayList<User>();
        read();
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

    public boolean isAdmin(){
        return user.isAdmin();
    }

    private void read(){
        Document document = null;
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            document = builder.parse(new File("./resources/user.xml"));
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        NodeList elemList = null;
        if (document != null) {
            elemList = document.getDocumentElement().getElementsByTagName("user");
            for (int i = 0; i < elemList.getLength(); i++) {
                Node elem = elemList.item(i);
                NamedNodeMap nodeMap = elem.getAttributes();
                int id = Integer.parseInt(nodeMap.getNamedItem("id").getNodeValue());
                String login = nodeMap.getNamedItem("login").getNodeValue();
                String password = nodeMap.getNamedItem("password").getNodeValue();
                boolean admin = Boolean.parseBoolean(nodeMap.getNamedItem("admin").getNodeValue());
                users.add(new User(id, login, password, admin));
            }
        }
    }

}
