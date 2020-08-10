package bankAccount;

public class Savings extends Account {

    private String safetyDepositBoxNo = "";
    private String code = "";

    public Savings (String name, String ssn, double initDeposit) {
        super(name, ssn, initDeposit);
        this.accountNumber = "1" + this.accountNumber;
        this.safetyDepositBoxNo = generateSafetyDepositBoxNo();
        this.code = generateCode();

    }

    @Override
    public void setInterestRate() {
        this.rate = getBaseRate() - 0.25;
    }

    private String generateSafetyDepositBoxNo () {
        String numerical = "0123456789";
        for (int i= 0; i < 3; i++) {
            int index = (int)(Math.random()*numerical.length());
            this.safetyDepositBoxNo += numerical.charAt(index);
        }
        return this.safetyDepositBoxNo;
    }

    private String generateCode () {
        String numerical = "0123456789";
        for (int i= 0; i < 4; i++) {
            int index = (int)(Math.random()*numerical.length());
            this.code += numerical.charAt(index);
        }
        return this.code;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("\tYour SAVINGS account features: \n\t  Safety Deposit Box NO: " + this.safetyDepositBoxNo + "\n\t  Code: " + this.code);
    }
}
