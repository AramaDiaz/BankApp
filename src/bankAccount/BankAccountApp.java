package bankAccount;

import utilities.CSV;

import java.util.ArrayList;
import java.util.List;

public class BankAccountApp {
    public static void main(String[] args) {

        List<Account> accounts = new ArrayList<>();

        List<String[]> newAccountHolders = CSV.readCsvFile("E:/java/BankApp/NewBankAccounts.csv");
        for (String[] accountHolder: newAccountHolders) {
            String name = accountHolder[0];
            String ssn = accountHolder[1];
            String accountType = accountHolder[2];
            double initDeposit = Double.parseDouble(accountHolder[3]);
            if (accountType.equals("Savings")) {
                accounts.add(new Savings(name, ssn, initDeposit));
            } else if (accountType.equals("Checking")) {
                accounts.add(new Checking(name, ssn, initDeposit));
            }
        }
//        for (Account account : accounts) {
//            System.out.println("**********************************");
//            account.showInfo();
//        }
        accounts.get(0).showInfo();
        accounts.get(0).deposit(2000);
        accounts.get(0).withdraw(500);
        accounts.get(0).transfer("Brokerage", 1230);
    }
}
