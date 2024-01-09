package com.example.demo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.sql.*;


@RestController
public class MainControler {
    public static void main(String[] args) {
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/save_account", "root", "Michal-123")) {
            Statement statement = null;
            try {
                statement = con.createStatement();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            statement.executeQuery("SELECT * FROM acount;");
            ResultSet result = statement.getResultSet();
            while (result.next()) {
                System.out.println(result.getString("Name") + " : " + result.getString("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @GetMapping("/accounts")
    public String accounts () {
    return "hello";
    }
    @PostMapping("/students")
    public Account createStudent(@RequestBody Account account) {
        AccountService.createNewAccount(account);
        return account;
    }
}