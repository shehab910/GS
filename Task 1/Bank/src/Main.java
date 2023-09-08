import java.math.BigInteger;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        /* Questions:
            * 1. I feel the `Bank` class is redundant, redoing what `Account` does, duplicate code
            * 2. Should this logic be in `Account` or `Bank`, In reality the `Bank` should be
            *    responsible for the creation/management of the accounts, but it makes no sense
            *    to implement all of that in the `Bank` class.
            * 3. I think the constructor of `Account` should be private & creation of it managed
            *    by the bank, don't know exactly how.
        */
        Customer shehab = new Customer("Shehab", "011111111", LocalDate.of(2000,1,1), new BigInteger("3000000000111"));
        Bank mybank = new Bank("mybank");
        Account acc = new Account(1010123, shehab, 0);
        mybank.addAccount(acc);
        mybank.deposit(acc, 200);
        mybank.withdraw(acc, 100);
        System.out.println("Get account from customer, account number: " + shehab.getAccount(mybank).getAccountNo());
        System.out.println("Amount in the account: " + acc.getAmount());
    }
}