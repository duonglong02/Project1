package main.db;

import main.obj.Student;

import java.sql.*;

public class DbUtils {
    private static DbInfo dbInfo = new DbInfo();
    public static void addStudent(Student student) throws ClassNotFoundException, SQLException {
        Class.forName(dbInfo.getDriver());
        Connection connection = DriverManager.getConnection(dbInfo.getUrl(), dbInfo.getUser(), dbInfo.getPassword());

        String query = " insert into thuctap.student(name,code,age,className,address,mark)" + " values(?,?,?,?,?,?)";
        PreparedStatement preparedStmt = connection.prepareStatement(query);
        preparedStmt.setString(1, student.getName());
        preparedStmt.setString(2, student.getCode());
        preparedStmt.setInt(3, student.getAge());
        preparedStmt.setString(4, student.getClassName());
        preparedStmt.setString(5, student.getAddress());
        preparedStmt.setFloat(6, student.getMark());

        preparedStmt.execute();
        connection.close();
    }

    public static int getTheNumberOfStudents() throws ClassNotFoundException, SQLException {
        Class.forName(dbInfo.getDriver());
        Connection connection = DriverManager.getConnection(dbInfo.getUrl(), dbInfo.getUser(), dbInfo.getPassword());
        String query = "select count(*) as amount from thuctap.student;";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(query);
        int amount = 0;
        while (rs.next()) {
            amount = rs.getInt("amount");
        }
        return amount;
    }
}
