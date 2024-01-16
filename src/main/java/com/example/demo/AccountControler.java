package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AccountControler {
    @Autowired
    AccountService accserv;
    @GetMapping("/user/{id}")
    public Account getAccount(@PathVariable long id, @RequestParam(value = "detail", required = false) boolean detail) {
        for (Account acc: accserv.getAccounts()) {
            if (id == acc.getId()) {
                if (!detail) {
                    return acc;
                } else {
                    return acc;
                }
            }
        }
        return null;
    }
    @GetMapping("/users")
    public List<Account> getAccounts(@RequestParam(value = "detail", required = false) boolean detail) {

        if (detail) {
            return accserv.getAccounts();
        }
        else {
            return accserv.getAccounts();
        }
    }

    @PutMapping("/user/{id}")
    public Account changeAccount(@PathVariable long id, @RequestBody Account account) {
        for (Account acc:accserv.getAccounts()) {
            if (acc.getId() == id) {
                acc.setName(account.getName());
                acc.setSurname(account.getSurname());
                return acc;
            }
        }
        return null;
    }
    @PostMapping("/user")
    public Account getSomeAccount(@RequestBody Account account) {
        accserv.createNewAccount(account);
        return account;
    }
    @DeleteMapping("/user/{id}")
    public void deleteAccount(@PathVariable int id) {
        accserv.getAccounts().remove(id);
    }
}
