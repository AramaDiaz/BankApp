package utilities;

import bankAccount.Account;
import bankAccount.Checking;
import bankAccount.Savings;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class CSV {

    public static List<String[]> readCsvFile(String file) {

        List<String[]> database = new LinkedList<>();

        try {
            BufferedReader csvReader = new BufferedReader(new FileReader(file));
            String row = "";
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(",");
                database.add(data);
            }
//            csvReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Could not find file");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return database;
    }
}
