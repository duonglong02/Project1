package main.ws;

import main.obj.Student;
import main.thread.ThreadOne;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.nio.file.Files;
import java.nio.file.Paths;

@WebService
public class StudentWs {

    @WebMethod
    public String addStudentFake(@WebParam(name = "username") String username, @WebParam(name = "password") String password,
                                 @WebParam(name = "name") String name, @WebParam(name = "age") String age,
                                 @WebParam(name = "code") String code, @WebParam(name = "className") String className,
                                 @WebParam(name = "address") String address, @WebParam(name = "mark") String mark) {
        try {
            int ageFake = Integer.parseInt(age);
            float markFake = Float.parseFloat(mark);
            if (CheckPasswordUser.check(username,password)) {
                Student student = new Student(name,ageFake,code,className,address,markFake);
                ThreadOne.addQueue(student);
                return "Thành công";
            }
            return "Username và password không hợp lệ.";
        }catch (Exception e){
            return "Thất bại";
        }
    }

    public static class CheckPasswordUser {
        public static Boolean check(String username, String password){
            try{
                String usernameAdmin = Files.readAllLines(Paths.get("C:/Users/HP/IdeaProjects/OceanTech/ChuaBT/Pj1/lib/app.conf")).get(0);
                String passwordAdmin = Files.readAllLines(Paths.get("C:/Users/HP/IdeaProjects/OceanTech/ChuaBT/Pj1/lib/app.conf")).get(1);

                if(username.equals(usernameAdmin) && password.equals(passwordAdmin)){
                    return true;
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
            return false;
        }
    }
}