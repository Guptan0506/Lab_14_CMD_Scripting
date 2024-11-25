import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DataSaver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> records = new ArrayList<>();

        boolean addMoreRecords;
        do {
            String firstName = SafeInput.getNonZeroLenString(scanner, "Enter first name");
            String lastName = SafeInput.getNonZeroLenString(scanner, "Enter last name");
            String idNumber = SafeInput.getNonZeroLenString(scanner, "Enter ID number (6 digits, e.g., 000001)");
            String email = SafeInput.getNonZeroLenString(scanner, "Enter email");
            int yearOfBirth = SafeInput.getInt(scanner, "Enter year of birth");

            String record = String.format("%s,%s,%s,%s,%d", firstName, lastName, idNumber, email, yearOfBirth);
            records.add(record);

            addMoreRecords = SafeInput.getYNConfirm(scanner, "Would you like to add another record?");
        } while (addMoreRecords);

        String fileName = SafeInput.getNonZeroLenString(scanner, "Enter the file name to save (with .csv extension)");
        try (PrintWriter writer = new PrintWriter(new File("src/" + fileName))) {
            for (String record : records) {
                writer.println(record);
            }
            System.out.println("Data saved successfully in " + fileName);
        } catch (FileNotFoundException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }
}
