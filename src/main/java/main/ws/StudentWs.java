package main.ws;

import main.utils.CallWs;

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
            if (!CheckPassword.check(username,password)){
                return "Username và password không hợp lệ";
            }
            int ageFake = Integer.parseInt(age);
            float markFake = Float.parseFloat(mark);
            if (name.length() == 0 || code.length() == 0 || address.length() == 0 || className.length() == 0){
                return "Thất bại: Điền thiếu thông tin sinh viên.";
            }
            else {
                CallWs.callStudentWs(username, password, name, age, code, className, address, mark);
                return "Thành công";
            }
        }catch (Exception e){
            return "Thất bại";
        }
    }

    public static class CheckPassword {
        public static Boolean check(String username, String password){
            try{
                String usernameAdmin = Files.readAllLines(Paths.get("C:/Users/HP/IdeaProjects/OceanTech/ChuaBT/Poject1/lib/app.conf")).get(0);
                String passwordAdmin = Files.readAllLines(Paths.get("C:/Users/HP/IdeaProjects/OceanTech/ChuaBT/Poject1/lib/app.conf")).get(1);

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