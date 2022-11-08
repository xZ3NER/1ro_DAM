package JFRAME;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class jframe1 implements ActionListener { //implementa actionlistener para las acciones

    JFrame frame = new JFrame("Mi JFrame"); //incluye titulo, frame inicial
    JTextField texto = new JTextField(20); //campo de texto, pero con un hueco para escribir
    JTextField respuesta = new JTextField(20);
    JPanel panelBG = new JPanel(new FlowLayout()); //panel de color de fondo
    JLabel label1 = new JLabel("HOLA MUNDO"); //label es campo de texto

    public static void main(String[] args) {

        new jframe1(); //accede a jframe1()
    }

    public jframe1() {

        frame.setBounds(100,100,800,500); //ventana principal, sus dimensiones
        frame.setLocationRelativeTo(null); //centrado el frame al iniciar
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //cierra al darle a la 'x'
        //frame.setResizable(false); para evitar que modifique las dimensiones del frame


        panelBG.setBackground(Color.orange);
        frame.add(panelBG);

        panelBG.add(label1);

        respuesta.setEditable(false); //no permite que el usuario modifique el valor
        panelBG.add(texto);
        panelBG.add(respuesta);

        texto.addActionListener(this); //añade un actionListener, que en caso de JTextFiel es cuando le da enter

        frame.setVisible(true); //que frame sea visible
    }

    @Override
    public void actionPerformed(ActionEvent e) { //creado automaticamente cuando implementa ActionListener en la clase
        respuesta.setText(texto.getText());
        //cuando se ejecuta un enter accede a este metodo y ejecuta lo de dentro,
        //que setea en respuesta el texto que devuelve el texto que introducimos
    }
}
