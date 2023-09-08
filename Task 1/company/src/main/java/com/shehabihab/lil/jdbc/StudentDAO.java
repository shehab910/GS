package com.shehabihab.lil.jdbc;

import com.shehabihab.lil.jdbc.util.DataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDAO extends DataAccessObject<Student> {
    public static final String GET = "select id, name, birthdate, grade, faculty_serial_number from students";
    public static final String GET_ONE = GET + " where id=?";
    public static final String GET_DEPT = "SELECT d.id, d.name, d.boss " +
            "FROM departments d " +
            "INNER JOIN students_departments sd ON d.id = sd.department_id " +
            "INNER JOIN students s ON s.id = sd.student_id " +
            "WHERE s.id = ?;";
    public static final String GET_FROM_DEPT = "SELECT s.id, s.name, s.birthdate, s.grade, s.faculty_serial_number " +
            "FROM students s " +
            "INNER JOIN students_departments sd ON s.id = sd.student_id " +
            "INNER JOIN departments d ON d.id = sd.department_id " +
            "WHERE d.id = ?;";
    public static final String UPDATE = "UPDATE students SET name=?, birthdate=?, grade=?, faculty_serial_number=? WHERE id=?";
    public static final String DELETE = "DELETE FROM students WHERE id=?";
    public static final String COUNT_IN_EACH_DEPT = "SELECT department_id, COUNT(*) FROM students_departments GROUP BY department_id";
    public static final String GET_UNASSIGNED = "SELECT s.id, s.name, s.birthdate, s.grade, s.faculty_serial_number " +
            "FROM students s " +
            "LEFT JOIN students_departments sd ON s.id = sd.student_id " +
            "WHERE sd.student_id IS NULL;";
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
        return student;
    }

    @Override
    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        try(PreparedStatement preparedStatement = this.connection.prepareStatement(GET)){
            preparedStatement.executeQuery();
            ResultSet rs = preparedStatement.getResultSet();
            while (rs.next()){
                // Question: Is this considered as bad practice?
                Student student = new Student();
                student.setId(rs.getLong(1));
                student.setName(rs.getString(2));
                student.setBirthdate(rs.getDate(3));
                student.setGrade(rs.getString(4));
                student.setFaculty_serial_number(rs.getLong(5));
                students.add(student);
            }
        } catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return students;
    }

    @Override
    public Student update(Student dto) {
        Student student = null;
        try(PreparedStatement statement = this.connection.prepareStatement(UPDATE);){
            statement.setString(1, dto.getName());
            statement.setDate(2, dto.getBirthdate());
            statement.setString(3, dto.getGrade());
            statement.setLong(4, dto.getFaculty_serial_number());
            statement.setLong(5, dto.getId());
            statement.execute();
            student = this.findById(dto.getId());
        }catch(SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return student;
    }

    @Override
    public Student create(Student dto) {
        return null;
    }

    @Override
    public void delete(long id) {
        try(PreparedStatement statement = this.connection.prepareStatement(DELETE)){
            statement.setLong(1, id);
            statement.execute();
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<Student> getFromDepartment(long deptId) {
        List<Student> students = new ArrayList<>();
        try(PreparedStatement preparedStatement = this.connection.prepareStatement(GET_FROM_DEPT)){
            preparedStatement.setLong(1, deptId);
            preparedStatement.executeQuery();
            ResultSet rs = preparedStatement.getResultSet();
            while (rs.next()){
                Student student = new Student();
                student.setId(rs.getLong(1));
                student.setName(rs.getString(2));
                student.setBirthdate(rs.getDate(3));
                student.setGrade(rs.getString(4));
                student.setFaculty_serial_number(rs.getLong(5));
                students.add(student);
            }
        } catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return students;
    }

    public Map<Long, Long> countInEachDepartment() {
        Map<Long, Long> map = new HashMap<>();
        try(PreparedStatement preparedStatement = this.connection.prepareStatement(COUNT_IN_EACH_DEPT)){
            preparedStatement.executeQuery();
            ResultSet rs = preparedStatement.getResultSet();
            while (rs.next()){
                map.put(rs.getLong(1), rs.getLong(2));
            }
        } catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return map;
    }

    public List<Student> getUnassigned() {
        List<Student> students = new ArrayList<>();
        try(PreparedStatement preparedStatement = this.connection.prepareStatement(GET_UNASSIGNED)){
            preparedStatement.executeQuery();
            ResultSet rs = preparedStatement.getResultSet();
            while (rs.next()){
                Student student = new Student();
                student.setId(rs.getLong(1));
                student.setName(rs.getString(2));
                student.setBirthdate(rs.getDate(3));
                student.setGrade(rs.getString(4));
                student.setFaculty_serial_number(rs.getLong(5));
                students.add(student);
            }
        } catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return students;
    }
}
