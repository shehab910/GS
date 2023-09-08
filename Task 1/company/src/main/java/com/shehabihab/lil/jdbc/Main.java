package com.shehabihab.lil.jdbc;

import java.sql.SQLException;

public class Main {

    public static void main(String... args) {
        DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost",
                "company", "postgres", "mypassword");

        System.out.println("-----------------------------------------------------------------");
        System.out.println("test getting all students");
        StudentDAO studentDAO = null;
        try {
            studentDAO = new StudentDAO(dcm.getConnection());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        studentDAO.findAll().forEach(s -> System.out.println(s.getName()));

        System.out.println("-----------------------------------------------------------------");
        System.out.println("test getting a student by id");
        Student student = studentDAO.findById(1L);
        System.out.println(student.getName());

        System.out.println("-----------------------------------------------------------------");
        System.out.println("test Selecting all students in specific department by inner join.");
        studentDAO.getFromDepartment(1L).forEach(s -> System.out.println(s.getId()));

        System.out.println("-----------------------------------------------------------------");
        System.out.println("test update");
        student.setGrade("F");
        student = studentDAO.update(student);
        System.out.println(student.getGrade());

        System.out.println("-----------------------------------------------------------------");
        System.out.println("test delete");
        studentDAO.delete(2L);
        studentDAO.findAll().forEach(s -> System.out.println(s.getName()));

        System.out.println("-----------------------------------------------------------------");
        System.out.println("test Get count of students in departments");
        studentDAO.countInEachDepartment().forEach((k, v) -> System.out.println("Dept: " + k + " count: " + v));

        System.out.println("-----------------------------------------------------------------");
        System.out.println("test List all students that has no departments. ");
        studentDAO.getUnassigned().forEach(s -> System.out.println(s.getName()));
    }
}