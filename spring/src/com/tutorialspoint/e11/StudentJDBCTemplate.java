package com.tutorialspoint.e11;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class StudentJDBCTemplate implements StudentDAO {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Override
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void create(String name, Integer age) {
        String sql = "insert into Student(name, age) value(?, ?)";
        jdbcTemplate.update(sql, name, age);
        System.out.println("Created Record Name = " + name + " Age = " + age);
        return;
    }

    @Override
    public Student getStudent(Integer id) {
        String sql = "select * from Student where id = ?";
        Student student = jdbcTemplate.queryForObject(sql, new Object[]{id}, new StudentMapper());
        return student;
    }

    @Override
    public List<Student> listStudents() {
        String sql = "select * from Student";
        List<Student> students = jdbcTemplate.query(sql, new StudentMapper());
        return students;
    }

    @Override
    public void delete(Integer id) {
        String sql = "delete from Student where id = ?";
        jdbcTemplate.update(sql, id);
        System.out.println("Deleted Record with Id = " + id);
        return;
    }

    @Override
    public void update(Integer id, Integer age) {
        String sql = "update Student set age = ? where id = ?";
        Integer result = jdbcTemplate.update(sql, age, id);
        System.out.println("Updated Record Age = " + age + " with Id = " + id + " Result = " + result);
        return;
    }
}
