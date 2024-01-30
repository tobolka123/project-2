package com.example.demo;

import com.example.demo.AccountNOdetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private AccountRepos AccountRepos;
    private static List<Account> accounts= new ArrayList<>();
    private static List<AccountNOdetail> accountsNo= new ArrayList<>();

    public AccountService(AccountRepos accountRepos) {
        this.AccountRepos = accountRepos;
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
                accounts.add(new Account(result.getString("Name"), result.getString("Surname"),
                        result.getString("PersonId"), result.getLong("Id"), result.getString("uuid")));
                accountsNo.add(new AccountNOdetail(result.getString("Name"), result.getString("Surname"),
                        result.getString("PersonId")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public List<AccountNOdetail> getNodetail() {
        return accountsNo;
    }

    public void createNewAccount(Account account) {
        jdbcTemplate.update("INSERT into acount (Id, Name, Surname, PersonId, uuid) VALUES(?, ?, ?, ?, ?)", account.getId(),
                account.getName(), account.getSurname(), account.getPersonID(), account.getUuid());

        accounts.add(account);
        accountsNo.add(new AccountNOdetail(account.getName(), account.getSurname(), account.getPersonID()));
    }
    public AccountNOdetail toNodetail(Account acc) {
        return new AccountNOdetail(acc.getName(), acc.getSurname(), acc.getPersonID());
    }

    public void deleteAccount(Long id) {
        Account accoun = null;
        for (Account accc:accounts) {
            if (accc.getId() == id) {
                accoun = accc;
            }
        }
        accounts.removeIf(account -> account.getId() == (id));
        Account finalAccoun = accoun;
        accountsNo.removeIf(accountNOdetail -> {
            assert finalAccoun != null;
            return accountNOdetail.equals(toNodetail(finalAccoun));
        });
        String sql = "DELETE from acount  where Id = " + id;
        jdbcTemplate.update(sql);
    }

    public void updateAccount(Long id, Account account) {
        for (Account acc: accounts) {
            if (acc.getId() == (id)) {
                jdbcTemplate.update("update acount set Name = ? where Id = ?", account.getName(), id);
                jdbcTemplate.update("update acount set Surname = ? where id = ?", account.getSurname(), id);
                acc.setName(account.getName());
                acc.setSurname(account.getSurname());
            }
        }
    }

}
