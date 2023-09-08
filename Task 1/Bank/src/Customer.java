import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class Customer {
    private String name;
    private String mobileNo;
    private LocalDate birthDate;
    private BigInteger nationalId;

    public Customer(String name, String mobileNo, LocalDate birthDate, BigInteger nationalId) {
        this.name = name;
        this.mobileNo = mobileNo;
        this.birthDate = birthDate;
        this.nationalId = nationalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public BigInteger getNationalId() {
        return nationalId;
    }

    public void setNationalId(BigInteger nationalId) {
        this.nationalId = nationalId;
    }

    public Account getAccount(Bank bank) {
        List<Account> accounts = bank.getAccounts().stream().filter(acc -> acc.getOwner() == this).collect(Collectors.toList());
        return accounts.get(0);
    }
}
