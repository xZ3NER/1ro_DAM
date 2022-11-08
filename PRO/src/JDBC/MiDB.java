package JDBC;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

public class MiDB { //MySQL
    public static void main(String[] args) {
        try {
            //Cargamos el driver de la base de datos (obligatorio)
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conexion=DriverManager.getConnection //Establecemos la conexion
                    ("jdbc:mysql://localhost:3306/bbdd_restaurante?characterEncoding=utf8&serverTimezone=UTC","root","qwerty@123");
            //asignamos la url, en nuestro caso la bbdd esta en localhost con puerto 3306 (por defecto)/ el nombre de la bbdd, y añadimos al final
            //?characterEncoding=utf8&serverTimezone=UTC para evitar errores de SQLException, el nombre del usuario (root), y su contraseña

            //Se prepara una consulta
            Statement sentencia=conexion.createStatement();

            //Para solamente un insert into o consultas sin resultado, directamente con statement
            //sentencia.executeUpdate("INSERT INTO usuarios VALUES ('" + username.getText() + "','" + password.getText() + "'," +
            //"'" + name.getText() + "','" + surname.getText() + "','" + secondlastname.getText() + "')");

            //almacena en el objeto resul la consulta ejecutada en el query
            ResultSet resul=sentencia.executeQuery(" SELECT SUM(cantidad_preparada),  \n" +
                    " nombre_producto, codigo_empleado, id_preparacion\n" +
                    " FROM preparaciones, empleados, productos\n" +
                    " WHERE empleados.codigo_empleado = preparaciones.codigo_empleado_preparacion\n" +
                    " AND preparaciones.codigo_producto_preparacion = productos.codigo_producto\n" +
                    " GROUP BY id_preparacion;");

            //desde aqui es interfaz gráfica
            miFrame frame = new miFrame();

            int filas=0,columna=1, maxColumnas=3;
            ArrayList<String> registros = new ArrayList<>();
            String[] campos = {"Cantidad preparada", "Nombre del producto","Código del empleado"};

            filas = getFilas(resul, filas, columna, registros);

            setRegistros(frame, filas, maxColumnas, registros, campos);

            //Cerramos todas las sentencias (muy importante)
            resul.close();
            sentencia.close();
            conexion.close();
        }
        catch (ClassNotFoundException ec) {ec.printStackTrace();}
        catch (SQLException es) {es.printStackTrace();}
    }

    private static int getFilas(ResultSet resul, int filas, int columna, ArrayList<String> registros) throws SQLException {
        //mientras resul tenga valor (filas o registros), podemos obtener el valor de su respectiva columna
        while (resul.next()){
            while (columna <=3) {
                registros.add(resul.getString(columna));
                columna++;
            }
            columna =1;
            filas++;
        }

        filas++;
        return filas;
    }
    //asignamos los registros de la tabla
    private static void setRegistros(miFrame frame, int filas, int maxColumnas, ArrayList<String> registros, String[] campos) {
        frame.setPanelFondo(new miPanel(filas,maxColumnas));
        Iterator iteRegistros = registros.iterator();

        for (int i = 0; i< filas; i++){
            for (int j = 0; j< maxColumnas; j++) {
                if (i==0) {
                    setCampos(frame, campos, i, j);
                } else {
                    setTexto(frame, i, j, (String) iteRegistros.next(), Color.lightGray);
                }
            }
        }
    }
    //asignar texto (datos)
    private static void setTexto(miFrame frame, int i, int j, String iteRegistros, Color color) {
        frame.panelFondo.setLabels(i, j, iteRegistros);
        frame.panelFondo.labels[i][j].setBackground(color);
        frame.panelFondo.labels[i][j].setOpaque(true); //utilizar opaque para que el color del label se vea
    }
    //asignar campos (cabecera de columnas)
    private static void setCampos(miFrame frame, String[] campos, int i, int j) {
        setTexto(frame, i, j, campos[j], Color.GRAY);
    }
}

