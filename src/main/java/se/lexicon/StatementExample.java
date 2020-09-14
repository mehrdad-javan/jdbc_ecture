package se.lexicon;

import se.lexicon.model.Student;

import java.sql.*;
import java.time.LocalDate;

public class StatementExample {
    private static String URL = "jdbc:mysql://localhost:3306/jdbc_lecture?autoReconnect=true&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=Europe/Berlin";
    private static String USERNAME = "root";
    private static String PASSWORD = "root";

    public static Student getStudentById(int id) {
        Student student = new Student();

        try (
                Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("select id,first_name,last_name,personal_number,address,reagister_date,status from student where id =" + id)
        ) {

            if (resultSet.next()) {
                student.setId(resultSet.getInt("id"));
                student.setFirstName(resultSet.getString("first_name"));
                student.setLastName(resultSet.getString("last_name"));
                student.setPersonalNumber(resultSet.getBigDecimal("personal_number"));
                student.setAddress(resultSet.getString("address"));
                student.setRegisterDate(LocalDate.parse(resultSet.getDate("reagister_date").toString()));
                student.setStatus(resultSet.getBoolean("status"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return student;
    }

    public static int deleteStudentById(int id) {
        int rowsAffected = 0;
        Connection connection=null;
        Statement statement=null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = connection.createStatement();
            rowsAffected = statement.executeUpdate("delete from student where id =" + id);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return rowsAffected;
    }


    public static void main(String[] args) {
        int deleteResult = deleteStudentById(3);
        System.out.println("deleteResult: " + deleteResult);
        if (deleteResult == 1){
            System.out.println("Delete Operation is Done");
        }else{
            System.out.println("Student Dose not exist");
        }
//        Student findStudent = getStudentById(3);
//        System.out.println("findStudent = " + findStudent);
    }
}
