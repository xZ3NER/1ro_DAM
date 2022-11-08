import javax.swing.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class banco {

    static ArrayList<Clientes> listaClientes = new ArrayList<>();
    static ArrayList<Cuentas> listaCuentas = new ArrayList<>();
    static DecimalFormat decimal= new DecimalFormat("#0.00");

    public static void main(String[] args) {
        boolean rep=true; //panel inicial

        do {

            String[] selec = {"Nuevo Cliente", "Nueva Cuenta","Gestionar cuentas","Salir"};
            int option = JOptionPane.showOptionDialog(null, "¿Qué acción desea realizar?", "Seleccione", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, selec, selec[0]);

            if (option == 0) newCliente();
            if (option == 1) newCuentas();
            if (option==  2) panelCuentas();
            if (option == 3) rep=false;

        }while(rep);
    }

    private static void newCliente() { //añade a la lista un nuevo objeto de clase Clientes
        String nombreCliente=JOptionPane.showInputDialog("Nombre del cliente: ");
        String telefonoCliente = setTelefono();
        String numNif = setNif();

        listaClientes.add(new Clientes(nombreCliente,telefonoCliente,numNif)); //parametros del constructor
        listaCuentas.add(null); //añadimos una posible cuenta en esa posición, que será modificada más tarde si queremos crear una.

        JOptionPane.showMessageDialog(null,"¡Cliente creado!\n\nNombre: "+nombreCliente+"\nNif: "+numNif+"\nTeléfono: "+telefonoCliente);
    }

    private static String setTelefono() { //telefono con datos coherentes
        String telefonoCliente = "";
        do {
                telefonoCliente = JOptionPane.showInputDialog("Teléfono del cliente: ");
                if (telefonoCliente.length()!=9|| !soloNumeros(telefonoCliente)) JOptionPane.showMessageDialog(null,"INTRODUZCA UN NÚMERO VÁLIDO");

        }while(telefonoCliente.length()!=9|| !soloNumeros(telefonoCliente));
        return telefonoCliente;
    }

    private static String setNif() { //nif con datos coherentes, y autoasignacion de la letra final
        String numNif="";
        do {
            try {

                numNif = JOptionPane.showInputDialog("Número Nif del cliente (Solo número): ");
                if (numNif.length() != 8 || !soloNumeros(numNif))
                    JOptionPane.showMessageDialog(null, "INTRODUZCA UN NIF VÁLIDO");

            }catch (NumberFormatException e) {

                JOptionPane.showMessageDialog(null, "INTRODUZCA UN NIF VÁLIDO");

            }
        }while(numNif.length()!=8||!soloNumeros(numNif));

        numNif+=letraNIF(numNif);
        return numNif;
    }

    private static boolean soloNumeros(String dato) { //verificar el telefono, nif y numero cuenta para que solo sean digitos
        boolean esnum=true;

        for (int i=0;i<dato.length();i++) {
            if (Character.isDigit(dato.charAt(i))==false)
                esnum=false;
        }

        return esnum;
    }

    private static char letraNIF(String nif) { //buscar letra del nif

        final String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        int numeros = Integer.parseInt(nif);
        char letra=letras.charAt(numeros%23);

        return letra;
    }

    private static void newCuentas() {  //seleccion de clientes disponibles para crear una cuenta, si no hay, muestra que no existen clientes.

        if(listaClientes.size()!=0) {
            String[] selec=new String[listaClientes.size()+1];

            for(int i=0;i<listaClientes.size();i++) {  //almacenar el nif de los clientes de los objetos de la lista clientes
                    selec[i] = listaClientes.get(i).getNif();
            }
            selec[selec.length-1] = "Atrás";

            int posCliente=JOptionPane.showOptionDialog(null, "¿Para quién desea crear una cuenta?", "Seleccione", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, selec, selec[0]);

            if(posCliente!=selec.length-1)
            crearCuenta(posCliente);
        }
        else {
            JOptionPane.showMessageDialog(null,"Ningún cliente existente, intente crear un nuevo cliente");
        }
    }

    private static void crearCuenta(int posCliente) { //creacion de cuentas almacenandolos en la lista Cuentas


            if (confirmarCuenta(posCliente)) {
                String numeroCuenta = setCuenta(posCliente);
                double numRojo = setNumRojo();

                listaCuentas.set(posCliente, new Cuentas(listaClientes.get(posCliente), numeroCuenta, numRojo)); //creacion del objeto de clase Cuentas con su respectivo constructor

                JOptionPane.showMessageDialog(null, "¡Cuenta del cliente " + listaClientes.get(posCliente).getNif() + " creada!\n\nNúmero de cuenta: " + numeroCuenta + "\nSaldo: " + listaCuentas.get(posCliente).getSaldo() + " €\nLímite números rojos: " + numRojo+" €");
            } else {

                JOptionPane.showMessageDialog(null, "Este cliente ya tiene una cuenta existente");
            }
    }

    private static boolean confirmarCuenta(int posCliente) { //sentencias para verificar si hay o no una cuenta existente para un cliente
        if (listaCuentas.get(posCliente)==null) return true;
        else return false;

    }

    private static String setCuenta(int posCliente) { //asigna el numero de cuenta
        String numeroCuenta;
        do {

            numeroCuenta = JOptionPane.showInputDialog("Asigna un número de cuenta al cliente " + listaClientes.get(posCliente).getNif());
            if (numeroCuenta.length()!=10||!soloNumeros(numeroCuenta)) JOptionPane.showMessageDialog(null,"Formato de cuenta no válido");

        }while(numeroCuenta.length()!=10||!soloNumeros(numeroCuenta));
        return numeroCuenta;
    }

    private static double setNumRojo() { //asigna el límite de números rojos
        double numRojo=1;

        do{
            try {

                numRojo = Double.parseDouble(JOptionPane.showInputDialog("Asigne a la cuenta un límite de números rojos (números negativos)"));
                if(numRojo>0) JOptionPane.showMessageDialog(null,"Formato no admitido, permite: números negativos");

            }catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,"Formato no admitido, permite: números negativos");
            }
        }while(numRojo>0);
        return numRojo;
    }

    private static void panelCuentas() { //panel de gestor de cuentas, donde muestra solo los clientes con cuentas, si no hay cuentas, lo indica con un mensaje

        if(listaCuentas.size()!=0&&listaCuentas.get(0)!=null) {
            String[] selec=new String[listaCuentas.size()+1];

            for(int i=0;i<listaCuentas.size();i++) {
                selec[i] = listaCuentas.get(i).getTitular().getNif(); //almacena en las opciones a elegir, cada objeto de la lista, de los cuales
                //solo almacena en la matriz el nif del titular, podemos acceder al nif del cliente pq en Cuentas hay un objeto de clase clientes.
            }
            selec[selec.length-1] = "Atrás";

            int posCuenta=JOptionPane.showOptionDialog(null, "Cuentas disponibles: ", "Seleccione", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, selec, selec[0]);

            if(posCuenta!=selec.length-1)
                modifCuenta(posCuenta);
        }
        else {
            JOptionPane.showMessageDialog(null,"Ninguna cuenta existente, intente crear una nueva cuenta");
        }
    }

    private static void modifCuenta(int posCuenta) { //panel de modificacion

        String[] actions = {"Info. Titular", "Ingresar dinero", "Retirar dinero", "Modificar Números Rojos", "Atrás"};
        boolean rep;
        do {
            rep=true; //String para mostrar número cuenta, saldo...
            String mensaje="Número de cuenta: \t"+listaCuentas.get(posCuenta).getNumeroCuenta()+"\n" +
                    "Nif del titular: \t"+listaCuentas.get(posCuenta).getTitular().getNif()+"\n" +
                    "Saldo disponible: \t"+decimal.format(listaCuentas.get(posCuenta).getSaldo())+" €\n" +
                    "Límite de números rojos establecido: \t"+decimal.format(listaCuentas.get(posCuenta).limiteNumerosRojos)+" €";

            int opcion = JOptionPane.showOptionDialog(null, mensaje, "Gestor de cuentas", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, actions, actions[0]);

            if (opcion == 0) infoTitular(posCuenta);
            if (opcion == 1) ingresar(posCuenta);
            if (opcion == 2) retirar(posCuenta);
            if (opcion == 3) modifNumRojo(posCuenta);
            if (opcion == 4) rep=false;

        }while(rep);
    }

    private static void infoTitular(int posCuenta) { //muestra la información del titular
        String mensaje="Titular: \t"+listaCuentas.get(posCuenta).getTitular().getNombre()+"\n" +
                        "Nif: \t"+listaCuentas.get(posCuenta).getTitular().getNif()+"\n" +
                        "Teléfono: \t"+listaCuentas.get(posCuenta).getTitular().getTelefono();

        JOptionPane.showMessageDialog(null,mensaje);
    }

    private static void ingresar(int posCuenta) { //ingresa dinero, no puede ser negativos ni letras
        boolean rep;
        double valor=0;
        do {
            rep=false;
            try {

                valor = Double.parseDouble(JOptionPane.showInputDialog("Introduzca el valor a ingresar: "));
                if(valor<=0) JOptionPane.showMessageDialog(null,"VALOR A INGRESAR NO PERMITIDO");
            }
            catch (NumberFormatException e) {
                rep=true;
                JOptionPane.showMessageDialog(null,"VALOR A INGRESAR NO PERMITIDO");
            }

        }while(rep||valor<=0);

        listaCuentas.get(posCuenta).ingresar(valor);
    }

    private static void retirar(int posCuenta) {
    //retirar dinero, no puede retirar si es igual al límite de números rojos, o cuando es menor al límite

        if(listaCuentas.get(posCuenta).getSaldo()!=listaCuentas.get(posCuenta).getLimiteNumerosRojos()&&listaCuentas.get(posCuenta).getSaldo()>listaCuentas.get(posCuenta).getLimiteNumerosRojos()) {

            boolean rep;
            double valor = 0;
            do {
                rep = false;
                try {

                    valor = Double.parseDouble(JOptionPane.showInputDialog("Introduzca el valor a retirar: \n" + //muestra un mensaje con el saldo y el  límite
                            "Saldo disponible: " + decimal.format(listaCuentas.get(posCuenta).getSaldo()) + " €\n" +
                            "Límite de Números Rojos: " + decimal.format(listaCuentas.get(posCuenta).getLimiteNumerosRojos()) + " €"));

                    if (valor <= 0 || listaCuentas.get(posCuenta).getSaldo() - valor < listaCuentas.get(posCuenta).getLimiteNumerosRojos()) {
                        JOptionPane.showMessageDialog(null, "VALOR A RETIRAR NO PERMITIDO");
                        rep = true; //verifica si cuando se resta el saldo con el valor introducido, es menor que el límite
                    }
                } catch (NumberFormatException e) {
                    rep = true;
                    JOptionPane.showMessageDialog(null, "VALOR A RETIRAR NO PERMITIDO");
                }

            } while (rep);

            listaCuentas.get(posCuenta).retirar(valor);
        }
        else JOptionPane.showMessageDialog(null,"Límite de Números rojos alcanzado, no puede retirar más dinero");
    }

    private static void modifNumRojo(int posCuenta) { //modificar números rojos

        String[] action={"Modificar manualmente","Establecer a 0"};
        int opcion=JOptionPane.showOptionDialog(null,"¿Qué acción desea relizar?","Modificación de números rojos",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,action,action[0]);

        if(opcion!=1) { //accede al método anterior de setNumRojo, la cual devuelve un double con su respectivo control de errores.
            listaCuentas.get(posCuenta).setLimiteNumerosRojos(setNumRojo());
        }
        else listaCuentas.get(posCuenta).setLimiteNumerosRojos(0);
    }
}
