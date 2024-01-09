package com.example.demo;

import com.example.demo.Account;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {

    private AccountRepos AccountRepos;

    public AccountService(AccountRepos accountRepos) {
        this.AccountRepos = accountRepos;
    }

    private static List<Account> accounts= new ArrayList<>();

    public void createDefualtAccounts() {
        Account acc = new Account("step", "ahoj", "nejakeid");
        Account acc2 = new Account("fra", "acc", "ahoj69");
        acc.setName("Franta");
        acc2.setSurname("Account");

        accounts.add(acc);
        accounts.add(acc2);
    }

    public List<Account> returnAccount() {
        return accounts;
    }

    public static void createNewAccount(Account account) {
        accounts.add(account);
    }

    public void deleteAccount(Long id) {
        accounts.removeIf(account -> account.getPersonID().equals(id));
    }

    public void updateAccount(Long id, Account account) {
        for (Account acc: accounts) {
            if (acc.getPersonID().equals(id)) {
                acc.setName(account.getName());
                acc.setSurname(account.getSurname());
            }
        }
    }
}
