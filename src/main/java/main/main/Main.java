package main.main;

import main.thread.ThreadOne;
import main.thread.ThreadTwo;
import main.ws.StudentWs;

import javax.xml.ws.Endpoint;

public class Main {
    public static void main(String[] args) {
        ThreadOne threadOne = new ThreadOne("thread_1");
        threadOne.start();
        ThreadTwo threadTwo = new ThreadTwo();
        Thread thread = new Thread(threadTwo);
        thread.start();
        Endpoint publish = Endpoint.publish("http://localhost:9898/student-webservice?wsdl", new StudentWs());
        System.out.println("Running : http://localhost:9898/student-webservice?wsdl");
    }
}
