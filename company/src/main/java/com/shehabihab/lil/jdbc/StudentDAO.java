package com.shehabihab.lil.jdbc;

import com.shehabihab.lil.jdbc.util.DataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class StudentDAO extends DataAccessObject<Student> {
    public static final String GET = "select id, name, birthdate, grade, faculty_serial_number from students";
    public static final String GET_ONE = GET + "where id=?";
    public static final String GET_DEPT = ""
    public StudentDAO(Connection connection) {
        super(connection);
    }

    @Override
    public Student findById(long id) {
        Student student = new Student();
        try(PreparedStatement preparedStatement = this.connection.prepareStatement(GET_ONE)){
            preparedStatement.setLong(1, id);
            preparedStatement.executeQuery();
            ResultSet rs = preparedStatement.getResultSet();
            while (rs.next()){
                student.setId(rs.getLong(1));
                student.setName(rs.getString(2));
                student.setBirthdate(rs.getDate(3));
                student.setGrade(rs.getString(4));
                student.setFaculty_serial_number(rs.getLong(5));
            }
        } catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<Student> findAll() {
        return null;
    }

    @Override
    public Student update(Student dto) {
        return null;
    }

    @Override
    public Student create(Student dto) {
        return null;
    }

    @Override
    public void delete(long id) {

    }

    public Department getDepartmentForStudent() {

    }
}
