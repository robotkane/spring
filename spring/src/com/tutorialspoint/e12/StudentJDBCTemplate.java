package com.tutorialspoint.e12;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

public class StudentJDBCTemplate implements StudentDAO {
    private DataSource dataSource;
    private SimpleJdbcCall jdbcCall;

    @Override
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("getRecord");
    }

    @Override
    public void create(String name, Integer age) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "insert into Student(name, age) value(?, ?)";
        jdbcTemplate.update(sql, name, age);
        System.out.println("Created Record Name = " + name + " Age = " + age);
        return;
    }

    @Override
    public Student getStudent(Integer id) {
        SqlParameterSource in = new MapSqlParameterSource().addValue("in_id", id);
        Map<String, Object> out = jdbcCall.execute(in);
        Student student = new Student();
        student.setId(id);
        student.setName((String) out.get("out_name"));
        student.setAge((Integer) out.get("out_age"));
        return student;
    }

    @Override
    public List<Student> listStudents() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "select * from Student";
        List<Student> students = jdbcTemplate.query(sql, new StudentMapper());
        return students;
    }
}
