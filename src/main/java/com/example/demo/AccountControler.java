package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AccountControler {
    List<Account> listOfAccounts = new ArrayList<>();
    @GetMapping("/students")
    public List<Account> getAccount() {
        listOfAccounts.add(new Account("Petr", "Novák", "35"));
        listOfAccounts.add(new Account("Jana", "Novakova", "18"));
        return listOfAccounts;
    }
    @GetMapping("/student/{name}/{surname}/{id}")
    public Account getSomeAccount(@PathVariable String name, @PathVariable String surname, @PathVariable String id) {
        return new Account(name, surname, id);
    }
}
