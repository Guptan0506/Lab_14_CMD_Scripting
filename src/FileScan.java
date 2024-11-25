import javax.swing.*;
import java.io.File;

public class FileScan {
    public static void main(String[] args) {
        String fileName;
        if (args.length > 0) {
            fileName = args[0];
        } else {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                fileName = selectedFile.getAbsolutePath();
            } else {
                System.out.println("No file selected. Exiting...");
                return;
            }
        }

        // Now you can use fileName for further processing
        System.out.println("File to scan: " + fileName);
        // Add your file scanning logic here
    }
}
