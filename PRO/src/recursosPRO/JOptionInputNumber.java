package recursosPRO;

import javax.swing.*;

public class JOptionInputNumber {
    public static void main(String[] args) {
        int number = numberInput();
        JOptionPane.showMessageDialog(null,number);
    }

    private static int numberInput() {
        int num=-1;
        boolean rep;
        do{
            rep = false;

            try {

                num = Integer.parseInt(JOptionPane.showInputDialog("Introduzca un número"));
                if (num<0) JOptionPane.showMessageDialog(null,"Formato incorrecto","AVISO",JOptionPane.WARNING_MESSAGE);

            }catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,"Formato incorrecto","AVISO",JOptionPane.WARNING_MESSAGE);
                rep=true;
            }
        }while (rep||num<0);

        return num;
    }
}
