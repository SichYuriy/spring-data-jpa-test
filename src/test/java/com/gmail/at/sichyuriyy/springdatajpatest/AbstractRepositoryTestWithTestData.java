package com.gmail.at.sichyuriyy.springdatajpatest;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Application.class)
@Transactional
@Rollback
public abstract class AbstractRepositoryTestWithTestData {

    private static final String INSERT_SCRIPT = "database/insert_test_data.sql";
    private static final String DELETE_SCRIPT = "database/delete_test_data.sql";
    private static final String CONNECTION_PROPERTIES = "persistence.properties";

    private static final String URL_PROPERTY = "spring.datasource.url";
    private static final String USERNAME_PROPERTY = "spring.datasource.username";
    private static final String PASSWORD_PROPERTY = "spring.datasource.password";


    @BeforeClass
    public static void setUp() throws IOException, SQLException {
        executeScript(DELETE_SCRIPT);
        executeScript(INSERT_SCRIPT);
    }

    private static void executeScript(String scriptPath) throws IOException, SQLException {
        var connectionProperties = PropertiesLoaderUtils.loadAllProperties(CONNECTION_PROPERTIES);
        var url = connectionProperties.get(URL_PROPERTY).toString();
        var username = connectionProperties.get(USERNAME_PROPERTY).toString();
        var password = connectionProperties.get(PASSWORD_PROPERTY).toString();
        var conn = DriverManager.getConnection(url, username, password);
        ScriptUtils.executeSqlScript(conn, new ClassPathResource(scriptPath));
    }
}
