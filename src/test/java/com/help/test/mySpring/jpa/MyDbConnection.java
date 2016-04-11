package com.help.test.mySpring.jpa;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class MyDbConnection {

    private DataSource datasource;

	private JdbcTemplate jdbcTemplateObject;

	@Autowired
    public void setdatasource(DataSource ds) {
        this.datasource = ds;
        this.jdbcTemplateObject = new JdbcTemplate(datasource);
    }

    public void delstudentbyname(int id) {
        String sql = "DELETE FROM ftm_project WHERE id=?";
        jdbcTemplateObject.update(sql,id);
        return ;
    }
}
