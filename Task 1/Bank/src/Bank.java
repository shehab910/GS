import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

public class Bank {
    // Assuming the bank has an attribute `name`
    private String name;
    private List<Account> accounts;

    public Bank(String name) {
        this.name = name;
    }

    public Bank(String name, List<Account> accounts) {
        this.name = name;
        this.accounts = accounts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void removeAccount(Account account) {
        throw new NotImplementedException();
    }
}
