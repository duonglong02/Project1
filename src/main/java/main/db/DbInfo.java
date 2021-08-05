package main.db;

public class DbInfo {
    private final  String url = "jdbc:mysql://localhost:3306/thuctap";
    private final  String driver = "com.mysql.cj.jdbc.Driver";
    private final  String user = "root";
    private final  String password = "123456";

    public String getUrl() {
        return url;
    }

    public String getDriver() {
        return driver;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}
