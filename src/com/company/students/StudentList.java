package com.company.students;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class StudentList {

    private ArrayList<Student> students;

    public StudentList() {
        students = new ArrayList<Student>();
        read();
    }

    public StudentList(ArrayList<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student){
        student.setId(students.size());
        students.add(student);
        write();
    }

    public boolean changeStudent(int id, Student s2){
        if (id > students.size() || id < 0){
            return false;
        } else {
            s2.setId(id);
            students.set(id, s2);
            return true;
        }
    }

    public String getStudent(int id){
        if (id > students.size() || id < 0){
            return "bad id";
        } else {
            return students.get(id).toString();
        }
    }

    private void read(){
        Document document = null;
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            document = builder.parse(new File("./resources/info.xml"));
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        NodeList elemList = null;
        if (document != null) {
            elemList = document.getDocumentElement().getElementsByTagName("student");
            for (int i = 0; i < elemList.getLength(); i++) {
                Node elem = elemList.item(i);
                NamedNodeMap nodeMap = elem.getAttributes();
                int id = Integer.parseInt(nodeMap.getNamedItem("id").getNodeValue());
                String name = nodeMap.getNamedItem("name").getNodeValue();
                int course = Integer.parseInt(nodeMap.getNamedItem("course").getNodeValue());
                students.add(new Student(name, course, id));
            }
        }
    }

    private void write(){
        Document document = null;
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            document = builder.newDocument();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Element studentList = document.createElement("students");
        document.appendChild(studentList);
        for (Student s: students) {
            Element student = document.createElement("student");
            student.setAttribute("id", String.valueOf(s.getId()));
            student.setAttribute("name", s.getName());
            student.setAttribute("course", String.valueOf(s.getCourse()));
            studentList.appendChild(student);
        }
        try {
            Transformer t = TransformerFactory.newInstance().newTransformer();
            t.setOutputProperty(OutputKeys.INDENT, "yes");
            t.transform(new DOMSource(document), new StreamResult(new FileOutputStream("./resources/info.xml", false)));
        } catch (FileNotFoundException | TransformerException e) {
            e.printStackTrace();
        }

    }
}