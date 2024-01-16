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
    private static List<AccountNOdetail> accountsNo= new ArrayList<>();

    public List<Account> getAccounts() {
        return accounts;
    }

    public List<AccountNOdetail> getNodetail() {
        return accountsNo;
    }

    public static void createNewAccount(Account account) {
        accounts.add(account);
        accountsNo.add(new AccountNOdetail(account.getName(), account.getSurname(), account.getPersonID()));
    }

    public void deleteAccount(Long id) {
        accounts.removeIf(account -> account.getId() == (id));
    }

    public void updateAccount(Long id, Account account) {
        for (Account acc: accounts) {
            if (acc.getId() == (id)) {
                acc.setName(account.getName());
                acc.setSurname(account.getSurname());
            }
        }
    }

}
