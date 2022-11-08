package ExamenUT7y8;


import ExamenUT7y8.FilesManagement.ReadBytesFile;
import ExamenUT7y8.FilesManagement.WriteFile;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Vector;

public class Main {

//    private static ReadFile readFile;
      private static WriteFile writeFile;
      private static ReadBytesFile readBytesFile;
//    private static WriteBytesFile writeBytesFile;

    public static void main(String[] args) throws IOException {
        SetOptionPaneStyle();

        readBytesFile = new ReadBytesFile("../encriptado.txt");
        readBytesFile.readLines();
        readBytesFile.close();

        writeFile = new WriteFile("./PRO/src/ExamenUT7y8/encriptado.txt");

        readBytesFile = new ReadBytesFile("../fichero1.ar");

        Vector<Character> vector = readBytesFile.readLinesCodificado();
        for (Character character: vector) {
            writeFile.writeLine(String.valueOf(character));
        }

        writeFile.close();
        readBytesFile.close();
    }

    private static void SetOptionPaneStyle() {
        UIManager.put("OptionPane.minimumSize",new Dimension(300,200));
        UIManager.put("Button.background", new Color(185, 185, 185));
        UIManager.put("OptionPane.okButtonText", "Continue");
        UIManager.put("OptionPane.cancelButtonText", "Exit");
        UIManager.put("OptionPane.messageFont",new Font("Candara",Font.BOLD,20));
        UIManager.put("TextField.font", new Font("Candara Light",Font.PLAIN,20));
        UIManager.put("Button.font",new Font("Candara Light",Font.BOLD,20));
    }
}
