package se.lexicon;

import se.lexicon.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IntroduceJDBC {

    public static void main(String[] args) {
        try {
            // first step
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/jdbc_lecture?autoReconnect=true&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=Europe/Berlin",
                    "root",
                    "root");
            // second step
            Statement statement = connection.createStatement();
            // write query
            String SELECT_STUDENT = "select * from student";
            //third step
            ResultSet resultSet = statement.executeQuery(SELECT_STUDENT);

            List<Student> studentList = new ArrayList<>();
            while (resultSet.next()) {
                studentList.add(new Student(
                        resultSet.getInt("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getBigDecimal("personal_number"),
                        resultSet.getString("address")));
            }

            studentList.forEach(System.out::println);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
