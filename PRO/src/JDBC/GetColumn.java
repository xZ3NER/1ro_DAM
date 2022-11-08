package JDBC;
import java.sql.*;

public class GetColumn {
    public static void main(String[] args) {

        try {

            /*
             * //Oracle Class.forName("oracle.jdbc.driver.OracleDriver");
             *
             * //Se establece conexi�n con BD Oracle Connection
             * conexion=DriverManager.getConnection
             * ("jdbc:oracle:thin:@localhost:1521:XE","rita","rita");
             */
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion=DriverManager.getConnection
                    ("jdbc:mysql://ualq7jtsbrkdloq0:BnnGdxXPbnp9MPo4cMke@brl9tb8g3nimmtuxx8xa-mysql.services.clever-cloud.com:3306/brl9tb8g3nimmtuxx8xa",
                            "ualq7jtsbrkdloq0","BnnGdxXPbnp9MPo4cMke");

            DatabaseMetaData dbmd=conexion.getMetaData();

            //Informaci�n de la BD
            String nombre=dbmd.getDatabaseProductName();
            String driver=dbmd.getDriverName();
            String url=dbmd.getURL();
            String usuario=dbmd.getUserName();

            System.out.println("Nombre de la BD: "+nombre);
            System.out.println("Driver: "+driver);
            System.out.println("URL: "+url);
            System.out.println("Usuario "+usuario+"\n");

            //Informaci�n de las tablas
            //EN el resultset se devuelve por posiciones:
            // 1: cat�logo, 2: esquema, 3:tabla, 4: tipo

            ResultSet resul = dbmd.getTables("brl9tb8g3nimmtuxx8xa", null, null, null);
            while (resul.next()) {
                String tabla=resul.getString("TABLE_NAME");
                System.out.println(" - Tabla: "+tabla);
            }

            //Informaci�n de columna de la tabla Departamentos
            //todos los par�metros a null ser�a de TODAS las tablas
            //ResultSet columnas=dbmd.getColumns(null,"RITA", "DEPARTAMENTOS", null);
            ResultSet columnas=dbmd.getColumns(null,"brl9tb8g3nimmtuxx8xa","vehiculos", null);
            System.out.println("\n"+"Informacion de columnas"+"\n");
            while (columnas.next()) {
                String nombrecolumna=columnas.getString("COLUMN_NAME");
                String tipocolumna=columnas.getString("TYPE_NAME");
                String tamano=columnas.getString("COLUMN_SIZE");
                String nula=columnas.getString("IS_NUllABLE");
                System.out.print("Columna: "+ nombrecolumna);
                System.out.print(" - Tipo: "+ tipocolumna);
                System.out.print(" - tamanio: "+ tamano);
                System.out.println(" - Nula?: "+ nula);
            }

            /*
             * //Sobre claves ResultSet pk=dbmd.getPrimaryKeys(null, "RITA",
             * "DEPARTAMENTOS"); String pkDep=""; String sep=""; while (pk.next()){
             * pkDep=pkDep+sep+pk.getString("COLUMN_NAME"); sep=" + "; }
             * System.out.println("Clave primaria: " + pkDep);
             *
             * ResultSet fk=dbmd.getExportedKeys(null, "RITA", "DEPARTAMENTOS"); while
             * (fk.next()){ String fk_name=fk.getString("FKCOLUMN_NAME"); String
             * pk_name=fk.getString("PKCOLUMN_NAME"); String
             * pk_tablename=fk.getString("PKTABLE_NAME"); String
             * fk_tablename=fk.getString("FKTABLE_NAME"); System.out.println("TablaPK: "+
             * pk_tablename+"  con clave primaria: "+ pk_name);
             * System.out.println("TablaFK: "+ fk_tablename+"  con clave ajena: "+ fk_name);
             * } //Utilizaci�n id�ntica para getImportedKeys
             *
             * ResultSet proc= dbmd.getProcedures(null, "RITA", null); while (proc.next()) {
             * String proc_name=proc.getString("PROCEDURE_NAME"); String
             * proc_type=proc.getString("PROCEDURE_TYPE"); System.out.println("Nombre:"+
             * proc_name+"   tipo: "+proc_type); }
             *
             *
             * //Datos con RESULTSETMETADATA
             *
             * Statement sentencia=conexion.createStatement(); ResultSet
             * rs=sentencia.executeQuery("SELECT * FROM departamentos"); ResultSetMetaData
             * rsmd=rs.getMetaData();
             *
             * String nula; int numcol=rsmd.getColumnCount(); for (int i=1; i<=numcol; i++){
             * System.out.print("Columna "+i+": ");
             * System.out.print("   Nombre: "+rsmd.getColumnName(i));
             * System.out.print("   Tipo: "+rsmd.getColumnTypeName(i));
             * if(rsmd.isNullable(i)==0) nula="No"; else nula="Si";
             * System.out.print("   Puede ser nula: "+nula);
             * System.out.println("   Ancho columna: "+ rsmd.getColumnDisplaySize(i)); }
             */
            conexion.close();
        }
        catch (ClassNotFoundException ec) {ec.printStackTrace();}
        catch (SQLException es) {es.printStackTrace();}
    }
}

