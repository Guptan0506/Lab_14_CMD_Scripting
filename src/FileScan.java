import javax.swing.*;
import java.io.File;

public class FileScan {
    public static void main(String[] args) {
        File file;

        if (args.length > 0) {
            file = new File(args[0]);
        } else {
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                file = fileChooser.getSelectedFile();
            } else {
                System.out.println("No file selected. Exiting...");
                return;
            }
        }
    }

    public static void processFile(File file) {
        System.out.println("Processing file: " + file.getAbsolutePath());
    }
}

