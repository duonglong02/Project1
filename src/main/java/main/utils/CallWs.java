package main.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class CallWs {
    public static void callStudentWs(String username, String password, String name, String age, String code, String className, String address, String mark) throws IOException {
        HttpURLConnection conn = (HttpURLConnection) new URL("http://localhost:8585/student-webservice?wsdl").openConnection();
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type","text/xml;charset=UTF-8");
        conn.setRequestProperty("soapaction","");
        conn.connect();
        OutputStream os=conn.getOutputStream();
        String xml="<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ws=\"http://ws.main/\">\n" +
                "   <soapenv:Header/>\n" +
                "   <soapenv:Body>\n" +
                "      <ws:addStudentReal>\n" +
                "         <username>"+username+"</username>\n" +
                "         <password>"+password+"</password>\n" +
                "         <name>"+name+"</name>\n" +
                "         <age>"+age+"</age>\n" +
                "         <code>"+code+"</code>\n" +
                "         <className>"+className+"</className>\n" +
                "         <address>"+address+"</address>\n" +
                "         <mark>"+mark+"</mark>\n" +
                "      </ws:addStudentReal>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>";
        os.write(xml.getBytes());
        os.flush();
        os.close();
        InputStream is = conn.getInputStream();
        byte[] bts=new byte[is.available()];
        is.read(bts);
    }
}