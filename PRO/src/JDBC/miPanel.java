package JDBC;

import javax.swing.*;
import java.awt.*;

public class miPanel extends JPanel {

    int columnas, filas;
    campoTexto[][] labels;

    public miPanel(int filas, int columnas) {
        this.filas=filas;
        this.columnas=columnas;
        this.labels = new campoTexto[filas][columnas];

        setLayout(new GridLayout(filas,columnas));
    }

    public void setLabels(int fila, int columna, String texto) {
        labels[fila][columna] = new campoTexto(texto);
        add(labels[fila][columna]);
    }
}

