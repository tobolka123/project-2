// Michal H. -> jmeno na discordu
package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AccountControler {
    @Autowired
    AccountService accserv;

    @GetMapping("/user/{id}")
    public Object getAccount(@PathVariable long id, @RequestParam(value = "detail", required = false) boolean detail) {
        for (Account acc: accserv.getAccounts()) {
            if (id == acc.getId()) {
                if (detail) {
                    return acc;
                } else {
                    return new AccountNOdetail(acc.getName(), acc.getSurname(), acc.getPersonID());
                }
            }
        }
        return null;
    }
    @GetMapping("/users")
    public List<?> getAccounts(@RequestParam(value = "detail", required = false) boolean detail) {
        if (detail) {
            return accserv.getAccounts();
        }
        else {
            return accserv.getNodetail();
        }
    }

    @PutMapping("/user/{id}")
    public Account changeAccount(@PathVariable long id, @RequestBody Account account) {
        accserv.updateAccount(id ,account);
        return account;
    }
    @PostMapping("/user")
    public Account getSomeAccount(@RequestBody Account account) {
        accserv.createNewAccount(account);
        return account;
    }
    @DeleteMapping("/user/{id}")
    public void deleteAccount(@PathVariable long id) {
        accserv.deleteAccount(id);
    }
}
