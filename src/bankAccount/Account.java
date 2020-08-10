package bankAccount;

public abstract class Account implements IBaseRate {
    private final String name;
    private final String ssn;
    private final double initDeposit;
    protected double balance;
    protected double rate;
    protected String accountNumber = "";
    private static int index = 10000;

    public Account (String name, String ssn, double initDeposit) {
        this.name = name;
        this.ssn = ssn;
        this.initDeposit = initDeposit;
        this.balance = this.initDeposit;
        index++;
        this.accountNumber = generateAccNo();
        setInterestRate();
    }

    private String generateAccNo () {
        this.accountNumber += ssn.substring(ssn.length()-2) + index;
        int last3digits = (int) (Math.random() * Math.pow(10, 3));
        return this.accountNumber += last3digits;
    }

    public abstract void setInterestRate ();

    public void deposit(double amount) {
        System.out.println("Depositing $" + amount);
        this.balance = this.balance + amount;
        printBalance();
    }

    public void withdraw (double amount) {
        if (amount > this.balance) {
            System.out.println("Not enough funds. Balance: " + balance);
        } else {
            System.out.println("Withdrawing $" + amount);
            this.balance = this.balance - amount;
        }
        printBalance();
    }

    public void transfer (String toWhere, double amount) {
        this.balance = balance - amount;
        System.out.println("Transferring $" + amount + " to " + toWhere);
        printBalance();
    }

    public void printBalance() {
        System.out.println("Your balance is now: $" + this.balance);
    }

    public void showInfo() {
        System.out.println("Name: " + this.name + "\n\tAccount number: " + this.accountNumber
                + "\n\tBalance: " + this.balance + "\n\tInterest Rate: " + this.rate + "%");
    }

}
