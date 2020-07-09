package com.tutorialspoint.e12;

import javax.sql.DataSource;
import java.util.List;

public interface StudentDAO {
    public void setDataSource(DataSource dataSource);

    public void create(String name, Integer age);

    public Student getStudent(Integer id);

    public List<Student> listStudents();
}
