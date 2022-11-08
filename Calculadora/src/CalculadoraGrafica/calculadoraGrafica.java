package CalculadoraGrafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class calculadoraGrafica{

    JFrame frame= new JFrame("Calculadora Gráfica V1");
    Image icono = Toolkit.getDefaultToolkit().getImage(getClass().getResource("calcIcon.png"));
    JPanel panelTexto = new JPanel(new BorderLayout());
    JTextField campoResultado = new JTextField();
    JPanel panelButton = new JPanel(new GridLayout(5,4));
    StringBuffer cadenaTextField = new StringBuffer();
    DecimalFormat decimal = new DecimalFormat("#0.00");

    public static void main(String[] args) {
        new calculadoraGrafica();
    }

    public calculadoraGrafica() {
        frame.setIconImage(icono);
        decimal.setRoundingMode(RoundingMode.DOWN);
        setFrame();
        setPanel();
    }

    public void setFrame() {
        frame.setVisible(true);
        frame.setBounds(100,100,450,600);
        frame.setMinimumSize(new Dimension(200,500));
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.add(panelTexto, BorderLayout.NORTH);
        frame.add(panelButton);
    }

    public void setPanel() {
        setTextPanel();
        setPanelButton();
    }

    public void setPanelButton() {
        String textButton = "π$%$CE$←$7$8$9$x$4$5$6$÷$1$2$3$-$,$0$=$+";
        String buttons[] = textButton.split("\\$");

        for(int i=0;i<buttons.length;i++) {
            JButton boton = new JButton(buttons[i]);
            boton.setBorder(BorderFactory.createLineBorder(new Color(236,236,236),1,true));
            boton.setBackground(Color.WHITE);
            boton.setFocusPainted(false);
            boton.setFont(new Font("Arial", Font.BOLD, 25));
            boton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    eventosCalculadora(boton);
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    super.mouseEntered(e);
                    boton.setBackground(new Color(230,230,230));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    super.mouseExited(e);
                    boton.setBackground(Color.white);
                }
            });

            panelButton.add(boton);
        }
    }

    public void setTextPanel() {
        campoResultado.setPreferredSize(new Dimension(frame.getWidth(),180));
        campoResultado.setBorder(BorderFactory.createLineBorder(new Color(236,236,236)));
        campoResultado.setBorder(BorderFactory.createEmptyBorder(0,0,0,20));
        campoResultado.setEditable(false);
        campoResultado.setFont(new Font("Arial", Font.PLAIN, 45));
        campoResultado.setHorizontalAlignment(JTextField.RIGHT);
        panelTexto.add(campoResultado);
    }

    public void eventosCalculadora(JButton boton) {
        String stringBoton = boton.getText();
        char charBoton = stringBoton.charAt(0);

        if (Character.isDigit(charBoton)||charBoton=='x'||charBoton=='÷'||charBoton=='+'||charBoton=='-'||charBoton==','||charBoton=='π'||charBoton=='%') {
            if (campoResultado.getText().equals(("Syntax Error"))){
                cadenaTextField.replace(0,cadenaTextField.length(),boton.getText());
                campoResultado.setText(String.valueOf(cadenaTextField));
            }
            else if (!cadenaTextField.equals("Syntax Error")) {
                cadenaTextField.append(boton.getText());
                campoResultado.setText(String.valueOf(cadenaTextField).replaceAll("\\.",","));
            }
        }
        else {
            if (charBoton=='=') {
                String resul;

                try {
                    resul = operaciones();
                }catch (NumberFormatException e) {
                    resul = "Syntax Error";
                }catch (IndexOutOfBoundsException e) {
                    resul = "Syntax Error";
                }

                cadenaTextField = new StringBuffer(resul);
                String cadenaTextField2;
                if (!cadenaTextField.equals("Syntax Error")) {
                    try {
                        cadenaTextField2 = decimal.format(Double.parseDouble(cadenaTextField.toString()));
                    }catch (NumberFormatException e) {
                        cadenaTextField2 =cadenaTextField.toString();
                    }
                }
                else cadenaTextField2 =cadenaTextField.toString();
                campoResultado.setText(String.valueOf(cadenaTextField2).replaceAll("\\.",","));
            }
            else if (charBoton=='←'){
                cadenaTextField.delete(cadenaTextField.length()-1,cadenaTextField.length());
                campoResultado.setText(String.valueOf(cadenaTextField));
            }
            else {
                if (cadenaTextField.length()>0) {
                    cadenaTextField.delete(0,cadenaTextField.length());
                    campoResultado.setText(String.valueOf(cadenaTextField));
                }
            }
        }
    }

    ArrayList<Double> listaNumeros = new ArrayList<>();
    ArrayList<Character> listaOperadores = new ArrayList<>();

    public String operaciones() {
        listaNumeros.clear();
        listaOperadores.clear();

        final double pi= 3.14159265359;
        String textoCalc = cadenaTextField.toString().replaceAll(",","\\.");
        String numbers[] = textoCalc.split("\\+|x|÷|(?=-)|%");

        for (int i=0;i<numbers.length;i++) {
            if (!numbers[i].isEmpty()||!numbers[i].equals("")) {
                if (!numbers[i].equals("π")&&!numbers[i].equals("-π")) {
                    listaNumeros.add(Double.parseDouble(numbers[i]));
                }
                else {
                    if(numbers[i].equals("-π")) listaNumeros.add(-(pi));
                    else listaNumeros.add(pi);
                }
            }
        }

        for (int i=0;i<textoCalc.length();i++){
            if (textoCalc.charAt(i)=='+'||textoCalc.charAt(i)=='x'||textoCalc.charAt(i)=='÷'||textoCalc.charAt(i)=='-'||textoCalc.charAt(i)=='%') {
                if ((cadenaTextField.charAt(0)=='-'&&i==0)||((cadenaTextField.charAt(i)=='-'||cadenaTextField.charAt(i)=='+')&&(cadenaTextField.charAt(i-1)=='x'||cadenaTextField.charAt(i-1)=='÷'))) {

                } else listaOperadores.add(textoCalc.charAt(i));
            }
        }

        operadoresPrioritarios();
        operadoresNoPrioritarios();

        String resul=String.valueOf(listaNumeros.get(0));

        return resul;
    }

    public void operadoresPrioritarios() {
        double resul;

        for (int i=0;i<listaOperadores.size();i++) {
            if (listaOperadores.get(i) == '%') {
                resul = listaNumeros.get(i) / 100;
                listaNumeros.remove(i);
                listaNumeros.add(i, resul);
                listaOperadores.remove(i);
                i--;
            }
        }

        for (int i=0;i<listaOperadores.size();i++) {
            if (listaOperadores.get(i) == 'x') {
                resul = listaNumeros.get(i) * listaNumeros.get(i+1);
                listaNumeros.remove(i);
                listaNumeros.add(i,resul);
                listaNumeros.remove(i+1);
                listaOperadores.remove(i);
                i--;
            }
            else if(listaOperadores.get(i) == '÷') {
                resul = listaNumeros.get(i) / listaNumeros.get(i+1);
                listaNumeros.remove(i);
                listaNumeros.add(i,resul);
                listaNumeros.remove(i+1);
                listaOperadores.remove(i);
                i--;
            }
        }
    }

    public void operadoresNoPrioritarios() {
        double resul;
        int i=0;

        while (listaNumeros.size()>1) {
            if (listaNumeros.get(i)>=0 && listaOperadores.size()>0) {
                resul = listaNumeros.get(i) + listaNumeros.get(i + 1);
                listaNumeros.remove(i);
                listaNumeros.add(i, resul);
                listaNumeros.remove(i + 1);
                listaOperadores.remove(i);
                i++;
                i--;
            } else {
                resul = listaNumeros.get(i) + listaNumeros.get(i + 1);
                listaNumeros.remove(i);
                listaNumeros.add(i, resul);
                listaNumeros.remove(i + 1);
            }
        }
    }
}
