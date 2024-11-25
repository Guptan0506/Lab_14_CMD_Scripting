import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class FileInspector {
    public static void main(String[] args){
        JFileChooser fileChooser = new JFileChooser(new File("src"));
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION){
            File selectedFile = fileChooser.getSelectedFile();
            try(Scanner scanner = new Scanner(selectedFile)){
                int lineCount = 0;
                int wordCount = 0;
                int charCount = 0;

                while(scanner.hasNextLine()){
                    String line = scanner.nextLine();
                    System.out.println(line);
                    lineCount++;

                    String[] words = line.split("\\s+");
                    wordCount += words.length;

                    charCount += line.length();
                }

                System.out.println("\nSummary report");
                System.out.println("File name: "+ selectedFile.getName());
                System.out.println("Number of lines: "+ lineCount);
                System.out.println("Number of Words: "+ wordCount);
                System.out.println("Number of Characters: "+ charCount);

            } catch (FileNotFoundException e){
                System.out.println("File not found : "+selectedFile.getAbsolutePath());
            }
        }
    }

}
