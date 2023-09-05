package com.shehabihab.lil.jdbc;

import com.shehabihab.lil.jdbc.util.DataTransferObject;

import java.sql.Date;
import java.time.LocalDate;

public class Student implements DataTransferObject {
    private long id;
    private String name;
    private Date birthdate;
    private String grade;
    private String department;
    private long faculty_serial_number;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public long getFaculty_serial_number() {
        return faculty_serial_number;
    }

    public void setFaculty_serial_number(long faculty_serial_number) {
        this.faculty_serial_number = faculty_serial_number;
    }

    public long getAge() {
        return Date.valueOf(LocalDate.now()).getTime() - this.birthdate.getTime();
    }

}
