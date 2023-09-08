public class Account {
    private final long accountNo;
    private final Customer owner;
    private double amount;

    //Assuming the owner of the account can't change without changing the account number
    public Account(long accountNo, Customer owner) {
        this.accountNo = accountNo;
        this.owner = owner;
    }
    public Account(long accountNo, Customer owner, double amount) {
        this(accountNo, owner);
        this.amount = amount;
    }

    public Customer getOwner() {
        return owner;
    }

    public long getAccountNo() {
        return accountNo;
    }

    public double getAmount() {
        return amount;
    }

    public boolean deposit(double depositedAmount) {
        if (depositedAmount <= 0){
            System.out.println("You can't deposit a non-positive amount of money");
        }
        try {
            //assuming a real deposit logic will be more complex
            this.amount += depositedAmount;
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    public boolean withdraw(double withdrawnAmount) {
        if (withdrawnAmount > this.amount) {
            System.out.println("Not enough balance to complete this operation");
        }
        try {
            //assuming a real withdraw logic will be more complex
            this.amount -= withdrawnAmount;
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
