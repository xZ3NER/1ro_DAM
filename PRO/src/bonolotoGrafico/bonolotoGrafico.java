package bonolotoGrafico;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class bonolotoGrafico extends JFrame {

    Image icono = Toolkit.getDefaultToolkit().getImage(getClass().getResource("./bonoloto.png"));
    static resultadoBonoloto resultado = new resultadoBonoloto();
    static int[] bonoloto = new int[8];

    public static void main(String[] args) {
        generaBonoloto();
        for (int a=0;a<bonoloto.length;a++) {
            System.out.print(bonoloto[a]+"   ");
        }
        new bonolotoGrafico();
    }

    public bonolotoGrafico() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bonoloto");
        setIconImage(icono);
        setBounds(100,100,800,500);
        setLocationRelativeTo(null);
        setResizable(false);

        add(new panelPrincipal());
        setVisible(true);
    }

    public static void generaBonoloto() {
        for (int i = 0; i<bonoloto.length-1; i++) {
            int num = (int) Math.floor(Math.random()*49+1);

            if (!esRepetido(num, bonoloto)) {
                bonoloto[i] = num;
            } else {
                i--;
            }
        }

        bonoloto[bonoloto.length-1] = (int) Math.floor(Math.random()*10);
    }

    public static boolean esRepetido(int valor, int[] valorBono) {
        for (int j = 0; j < bonoloto.length; j++) {
            if (valor == valorBono[j]) {
                return true;
            }
        }
        return false;
    }
}


class panelPrincipal extends JPanel {

    public panelPrincipal() {
        setLayout(new GridLayout(4,1));
        setBackground(new Color(233,255,225));

        add(new filaTexto());
        add(new panelBono());
        add(new panelBono.panelNumeros());
        add(bonolotoGrafico.resultado);
    }
}

class panelBono extends JPanel {

    public panelBono() {
        GridLayout layout = new GridLayout(1,10);
        layout.setHgap(15);
        setLayout(layout);
        setBorder(BorderFactory.createEmptyBorder(30,20,30,20));
        setBackground(new Color(233,255,225));

        addBotones();
    }

    static botonBono[] arrayBotones = new botonBono[8];

    public void addBotones() {

        for (int i = 0; i<arrayBotones.length; i++) {
            arrayBotones[i] = new botonBono("", i);
            add(arrayBotones[i]);
        }
    }

    static class panelNumeros extends JPanel{

        public panelNumeros() {
            GridLayout layout = new GridLayout(5,10);
            layout.setHgap(5);
            layout.setVgap(5);
            setLayout(layout);
            setBorder(BorderFactory.createEmptyBorder(0,20,0,20));
            setBackground(new Color(233,255,225));

            addBotones();
        }

        static botonNumerico[] numBotones = new botonNumerico[50];

        public void addBotones() {


            for (int i = 0; i<numBotones.length; i++) {
                if (i!=49) {
                    numBotones[i] = new botonNumerico(String.valueOf(i + 1));
                    add(numBotones[i]);
                } else {
                    numBotones[i] = new botonNumerico("✔");
                    add(numBotones[i]);
                }
            }

        }
    }

    class botonBono extends JButton {

        static int posicion;

        public static int getPosicion() {
            return posicion;
        }

        public botonBono(String text, int pos) {
            setText(text);
            setFocusPainted(false);
            if (pos!=0) {
                setBackground(new Color(144, 238, 144));
            } else {
                setBackground(new Color(91,214,91));
            }
            setBorder(BorderFactory.createLineBorder(new Color(20,180,20)));
            setFont(new Font("Default", Font.PLAIN, 30));
            setVerticalAlignment(JButton.CENTER);

            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    posicion = pos;
                    arrayBotones[posicion].setBackground(new Color(91,214,91));

                    for (int i = 0; i<arrayBotones.length; i++) {
                        if(i!=pos) {
                            arrayBotones[i].setBackground(new Color(144, 238, 144));
                        }
                    }

                    esReintegro(pos);
                }
            });
        }

        private void esReintegro(int pos) {
            if (pos ==7) {
                for(int i=10;i<panelNumeros.numBotones.length-1;i++) {
                    panelNumeros.numBotones[i].setVisible(false);
                }
                panelNumeros.numBotones[9].setText("0");
            }else {
                for(int i=10;i<panelNumeros.numBotones.length-1;i++) {
                    panelNumeros.numBotones[i].setVisible(true);
                }
                panelNumeros.numBotones[9].setText("10");
            }
        }

    }

    static class botonNumerico extends JButton{

        public botonNumerico(String text) {
            setText(text);
            setFocusPainted(false);
            if (text!="✔") {
                setBackground(new Color(144, 238, 144));
            } else {
                setBackground(new Color(91,214,91));
            }
            setFont(new Font("Default", Font.PLAIN, 15));
            setBorder(BorderFactory.createLineBorder(new Color(20,180,20)));
            setVerticalAlignment(JButton.CENTER);

            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    if (getText()!="✔"&&!esRepetido()) {
                        asignaNum();
                    }
                    else if (getText().equals("✔")&&!hayNull()){
                        int aciertos = verificaBonoloto();
                        bonolotoGrafico.resultado.setText(imprimeTexto(aciertos, verificaReintegro()));
                    }
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    super.mouseEntered(e);
                    setBackground(new Color(91,214,91));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    super.mouseExited(e);
                    if (text!="✔") {
                        setBackground(new Color(144, 238, 144));
                    }
                }
            });
        }

        private boolean hayNull() {
            for (int i=0; i<panelBono.arrayBotones.length;i++) {
                if (arrayBotones[i].getText().equals("")){
                    return true;
                }
            }

            return false;
        }

        private int verificaBonoloto() {
            int aciertos=0;

            for (int i = 0;i<bonolotoGrafico.bonoloto.length-1;i++) {
                if (bonolotoGrafico.bonoloto[i] == Integer.parseInt(panelBono.arrayBotones[i].getText())) {
                    aciertos++;
                    panelBono.arrayBotones[i].setBackground(new Color(115, 247, 70));
                } else {
                    panelBono.arrayBotones[i].setBackground(new Color(180, 180, 180));
                }
            }

            return aciertos;
        }

        private boolean verificaReintegro() {
            int ultimaPos = bonolotoGrafico.bonoloto.length-1;

            if(bonolotoGrafico.bonoloto[ultimaPos] == Integer.parseInt(panelBono.arrayBotones[ultimaPos].getText())) {
                panelBono.arrayBotones[ultimaPos].setBackground(new Color(115,247,70));
                return true;
            } else {
                panelBono.arrayBotones[ultimaPos].setBackground(new Color(180,180,180));
                return false;
            }
        }

        private String imprimeTexto(int aciertos, boolean reintegro) {
            double premio=0;

            if (reintegro) {
                premio+= 2;
            }
            if (aciertos==1 || aciertos ==2) {
                premio+=0;
            } else if (aciertos == 3) {
                premio+=6.5;
            } else if (aciertos == 4) {
                premio+=1025.16;
            } else if (aciertos==5) {
                premio+=159800.50;
            } else if (aciertos == 6) {
                premio+=200150.25;
            }

            String texto = "¡SU BONOLOTO TIENE UN VALOR DE "+premio+" €!";

            return texto;
        }

        public void asignaNum() {
            arrayBotones[botonBono.getPosicion()].setText(getText());
        }

        private boolean esRepetido() {
            for (int i = 0; i<arrayBotones.length-1; i++) {
                String botonBonoloto = arrayBotones[i].getText();
                String botonNum = getText();

                if (botonBonoloto.equals(botonNum)&&botonBono.getPosicion()!=7) {
                    return true;
                }
            }

            return false;
        }
    }
}

class filaTexto extends JLabel {

    public filaTexto() {
        setText("C              R");
        setFont(new Font("Candara Light", Font.PLAIN, 25));
        setHorizontalAlignment(RIGHT);
        setVerticalAlignment(BOTTOM);
        setBorder(BorderFactory.createEmptyBorder(0,0,0,55));
    }
}

class resultadoBonoloto extends JLabel {

    public resultadoBonoloto() {
        setText("<html><body>¡Introduce tu número del bonoloto para saber si eres un afortunado!<br/><div align='center'>Utiliza el botón '✔' para verificar</div></body></html>");
        setHorizontalAlignment(CENTER);
        setFont(new Font("Candara Light", Font.PLAIN, 25));
    }
}