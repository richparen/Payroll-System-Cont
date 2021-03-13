package kz.iitu.java.payroll.dataBase;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.*;

@Component
public class DBConnection {
    @Value("${application.URL}")
    private String URL;
    @Value("${application.USERNAME}")
    private String USERNAME;
    @Value("${application.PASSWORD}")
    private String PASSWORD;

    private Connection connect;

    public DBConnection() {
    }

    public DBConnection(String URL, String USERNAME, String PASSWORD) {
        this.URL = URL;
        this.USERNAME = USERNAME;
        this.PASSWORD = PASSWORD;
    }

    public void openConnect() throws Exception {
        connect = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public void closeConnect() throws Exception {
        connect.close();
    }

    @PostConstruct
    public void init() {
        try {
            openConnect();
        } catch (Exception ex) {
            System.out.println("Connection failed!");
            System.out.println(ex);
        }
    }

    @PreDestroy
    public void destroy(){
        try {
            closeConnect();
        } catch (Exception ex) {
            System.out.println("Closing failed!");
            System.out.println(ex);
        }
    }

    public ResultSet getData(String sql) {
        ResultSet resultSet = null;
        try {
            PreparedStatement preparedStatement = connect.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException sqlEx) {
            System.out.println("SQL query failed!");
            System.out.println(sqlEx);
        }
        return resultSet;
    }

    public void updateData(String sql) {
        try {
            PreparedStatement preparedStatement = connect.prepareStatement(sql);
            preparedStatement.executeUpdate();
        } catch (SQLException sqlEx) {
            System.out.println("Date update failed!");
            System.out.println(sqlEx);
        }
    }
}
