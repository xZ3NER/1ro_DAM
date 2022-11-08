package recursosPRO.ExamenUT7y8;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {

//    private static ReadFile readFile;
//    private static WriteFile writeFile;
//    private static ReadBytesFile readBytesFile;
//    private static WriteBytesFile writeBytesFile;

    public static void main(String[] args) throws IOException {
        SetOptionPaneStyle();


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
