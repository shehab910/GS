import java.util.ArrayList;
import java.util.List;

public class Bank {
    // Assuming the bank has an attribute `name`
    private String name;


    private List<Account> accounts;

    public Bank(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public Bank(String name, List<Account> accounts) {
        this.name = name;
        this.accounts = accounts;
    }

    public List<Account> getAccounts() {
        return accounts;
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
        accounts.remove(account);
    }

    public void deposit(Account account, double amount) {
        if(!account.deposit(amount)) {
            System.out.println("Operation failed, please try again");
        }
    }

    public void withdraw(Account account, double amount) {
        if(!account.withdraw(amount)) {
            System.out.println("Operation failed, please try again");
        }
    }
}
