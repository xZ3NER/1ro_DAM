package Farmacia;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

public class FarmaciaMain {

    private static LeerFarmacos leerFarmacos;
    private static EscribirFarmacos escribirFarmacos;
    private static final ArrayList<Productos> productosList = new ArrayList<>();
    private static final ArrayList<String> ticketConRecetas = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        SetOptionPaneStyle();

        leerFarmacos = new LeerFarmacos("ProductosFarmacia");
        ExecuteFileReader();

        MostrarProductos();

        VentaProductos();

        WriteRecetas();

        leerFarmacos.CloseAll();
        escribirFarmacos.CloseAll();
    }

    private static void WriteRecetas() throws IOException {
        escribirFarmacos = new EscribirFarmacos("Recetas");

        for (String line: ticketConRecetas) {
            escribirFarmacos.Write(line+"\n");
        }
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

    private static void VentaProductos() {
        String[] opciones = {"Medicina","Natural"};

        int selec = JOptionPane.showOptionDialog(
                null,"¿Qué objeto deseas comprar?",
                "Venta",JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE,null,opciones,opciones[0]
        );

        if (selec==-1) {
            return;
        }

        if (selec==0) {
            PanelMedicina();
        } else {
            if (selec == 1) {
                PanelNatural();
            }
        }
    }

    private static void PanelMedicina() {
        Vector<String> opcionesVec = new Vector<>();

        for (Productos productos: productosList) {
            if (productos instanceof Medicinas) {
                opcionesVec.add(productos.getNombre());
            }
        }

        SeleccionProductos(opcionesVec);
    }

    private static void PanelNatural() {
        Vector<String> opcionesVec = new Vector<>();

        for (Productos productos: productosList) {
            if (productos instanceof Naturales) {
                opcionesVec.add(productos.getNombre());
            }
        }

        SeleccionProductos(opcionesVec);
    }

    private static void SeleccionProductos(Vector<String> opcionesVec) {
        String selec = (String) JOptionPane.showInputDialog(
                null,"¿Qué objeto deseas comprar?",
                "Venta", JOptionPane.PLAIN_MESSAGE,null, opcionesVec.toArray(), opcionesVec.toArray()[0]
        );

        if (selec==null) {
            VentaProductos();
        }else {
            ProcesarVenta(selec);
        }
    }

    private static void ProcesarVenta(String selec) {
        int cantidad = SeleccionarCantidad();

        String message;

        for (Productos productos: productosList) {
            if (productos.getNombre().equals(selec)) {
                message = "Referencia: " + productos.getReferencia() + "\n" +
                        "Nombre: " + productos.getNombre() + "\n" +
                        "Precio: " + productos.getPrecio() + "\n" +
                        "Stock: " + productos.getStock() + "\n";

                if (productos instanceof Medicinas) {
                    message+="Seguridad Social: " + ((Medicinas) productos).getSegSocial() + "\n" +
                            "Receta: " + ((Medicinas) productos).getReceta() + "\n";

                    if (((Medicinas) productos).getReceta()) {
                        ticketConRecetas.add(productos.getNombre()+"                 "+productos.PrecioFinal(cantidad)+"€");
                    }
                }
                if (productos instanceof Naturales) {
                    message+="Distribuidor: " + ((Naturales) productos).getDistribuidor() +"\n";
                }

                JOptionPane.showMessageDialog(null,message,"Detalles",JOptionPane.PLAIN_MESSAGE);

                if(!productos.Vender(cantidad)) {
                    JOptionPane.showMessageDialog(null,"Stock insuficiente","Detalles",JOptionPane.PLAIN_MESSAGE);
                }
            }
        }
        VentaProductos();
    }

    private static int SeleccionarCantidad() {
        int cantidad=0;
        boolean rep = true;

        while (rep||cantidad<0) {
            try {
                cantidad = Integer.parseInt(JOptionPane.showInputDialog("Introduzca la cantidad"));
                rep=false;
            } catch (NumberFormatException ignored) {
            }
        }

        return cantidad;
    }

    private static void MostrarProductos() {
        for (Productos productos: productosList) {
            if (productos instanceof Medicinas) {
                System.out.print(
                        productos.getReferencia()+", "+productos.getNombre()+", "+productos.getPrecio()+", "+productos.getStock()+", "+
                        ((Medicinas) productos).getSegSocial()+", "+((Medicinas) productos).getReceta()+"\n"
                );
            }else {
                if (productos instanceof Naturales) {
                    System.out.print(
                            productos.getReferencia() + ", " + productos.getNombre() + ", " + productos.getPrecio() + ", " + productos.getStock() + ", " +
                                    ((Naturales) productos).getDistribuidor()+"\n"
                    );
                }
            }
        }
    }

    private static void CheckType(String[] farmacoInfo) {
        if (farmacoInfo[0].charAt(0) == 'M') {
            CreateMedicina(farmacoInfo);
        }else {
            CreateNatural(farmacoInfo);
        }
    }

    private static void CreateMedicina(String[] farmacoInfo) {

        for (int i=4;i<farmacoInfo.length;i++) {
            if (farmacoInfo[i].equals("No")) {
                farmacoInfo[i] = String.valueOf(false);
            } else {
                farmacoInfo[i] = String.valueOf(true);
            }
        }

        productosList.add(
                new Medicinas(
                        farmacoInfo[0],farmacoInfo[1],Double.parseDouble(farmacoInfo[2]),
                        Integer.parseInt(farmacoInfo[3]),Boolean.parseBoolean(farmacoInfo[4]),Boolean.parseBoolean(farmacoInfo[5])
                )
        );
    }

    private static void CreateNatural(String[] farmacoInfo) {

        productosList.add(
                new Naturales(
                        farmacoInfo[0],farmacoInfo[1],Double.parseDouble(farmacoInfo[2]),
                        Integer.parseInt(farmacoInfo[3]),farmacoInfo[4]
                )
        );
    }

    private static void ExecuteFileReader() throws IOException {
        String linea;
        String[] farmacoInfo;

        while ((linea=leerFarmacos.getBufferedReader().readLine())!=null) {
            farmacoInfo = linea.split(",");

            CheckType(farmacoInfo);
        }
    }
}
