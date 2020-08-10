package bankAccount;

public class Checking extends Account {

    private String debitCardNo = "";
    private String pin = "";

    public Checking (String name, String ssn, double initDeposit) {
        super(name, ssn, initDeposit);
        this.accountNumber = "2" + this.accountNumber;
        this.debitCardNo = generateDebitCardNo();
        this.pin = generatePin();
    }

    @Override
    public void setInterestRate() {
        this.rate = getBaseRate() * 0.15;
    }

    private String generateDebitCardNo () {
        String numerical = "0123456789";
        for (int i= 0; i < 12; i++) {
            int index = (int)(Math.random()*numerical.length());
            this.debitCardNo += numerical.charAt(index);
        }
        return this.debitCardNo;
    }

    private String generatePin () {
        String numerical = "0123456789";
        for (int i= 0; i < 3; i++) {
            int index = (int)(Math.random()*numerical.length());
            this.pin += numerical.charAt(index);
        }
        return this.pin;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("\tYour CHECKING account features:\n\t  Debit Card NO: "+ this.debitCardNo + "\n\t  PIN: " + this.pin);
    }

}
