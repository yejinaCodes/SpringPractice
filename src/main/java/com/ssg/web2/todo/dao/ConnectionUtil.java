package com.ssg.web2.todo.dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;

public enum ConnectionUtil {

    INSTANCE;
    private HikariDataSource ds;
    ConnectionUtil(){
        HikariConfig config = new HikariConfig();

        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setJdbcUrl("jdbc:mysql://localhost:3306/ssg?characterEncoding=UTF-8&serverTimezone=UTC");
        config.setUsername("webuser");
        config.setPassword("1234");
        config.addDataSourceProperty("cachePrespStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSql", "2048");

        ds = new HikariDataSource(config);
    }
    public Connection getConnection() throws Exception{
        return ds.getConnection();
    }

}
