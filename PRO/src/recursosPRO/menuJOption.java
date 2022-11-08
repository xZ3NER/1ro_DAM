package recursosPRO;

import javax.swing.*;

public class menuJOption {
    public static void main(String[] args) {
        int option = optionMenu();
        JOptionPane.showMessageDialog(null,option);
    }

    private static int optionMenu() {
        String[] optionVec = {"Opcion1","Opcion2","Opcion3"};

        int option;
        option = JOptionPane.showOptionDialog(null, "Seleccione su opcion","Selector",JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE,null,optionVec,optionVec[0]);

        return option;
    }
}
