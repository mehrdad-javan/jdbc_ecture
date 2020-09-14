package se.lexicon;

import se.lexicon.db.MySQLConnection;
import se.lexicon.exception.MYSQLConnectionException;
import se.lexicon.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PreparedStatementExample {

    public static Student getStudentById(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Student student = new Student();
        try {
            connection = MySQLConnection.mysqlGetConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM STUDENT WHERE id=?");
            preparedStatement.setInt(1, id);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                student.setId(resultSet.getInt("id"));
                student.setFirstName(resultSet.getString("first_name"));
                student.setLastName(resultSet.getString("last_name"));
                student.setPersonalNumber(resultSet.getBigDecimal("personal_number"));
                student.setAddress(resultSet.getString("address"));
                student.setRegisterDate(LocalDate.parse(resultSet.getDate("reagister_date").toString()));
                student.setStatus(resultSet.getBoolean("status"));
            }
        } catch (MYSQLConnectionException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return student;
    }


    private static List<Student> getStudentByIdAndName(int id, String name) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Student> studentList = new ArrayList<>();
        try {
            connection = MySQLConnection.mysqlGetConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM STUDENT WHERE id = ? and first_name like ?");
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
/*                studentList.add(new Student(
                        resultSet.getInt("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getBigDecimal("personal_number"),
                        resultSet.getString("address"),
                        LocalDate.parse(resultSet.getDate("reagister_date").toString()),
                        resultSet.getBoolean("status")
                ));*/

                studentList.add(new Student(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getBigDecimal(4),
                        resultSet.getString(5),
                        LocalDate.parse(resultSet.getDate(6).toString()),
                        resultSet.getBoolean(7)
                ));
            }

        } catch (MYSQLConnectionException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentList;
    }

    public static void main(String[] args) {
//        Student student = getStudentById(2);
//        System.out.println("student = " + student);

        List<Student> studentList=getStudentByIdAndName(2,"Mehrdad");
        System.out.println("studentList = " + studentList);
    }
}
