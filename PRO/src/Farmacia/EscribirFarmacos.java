package Farmacia;

import java.io.*;

public class EscribirFarmacos {

    private final FileWriter fileWriter;

    public EscribirFarmacos(String fileName) throws IOException {
        File ficheroFarmacos = new File("./PRO/src/Farmacia/" + fileName + ".txt");

        fileWriter = new FileWriter(ficheroFarmacos);
    }

    public void CloseAll() throws IOException {
        fileWriter.close();
    }

   public void Write(String line) throws IOException {
        fileWriter.write(line);
   }
}
