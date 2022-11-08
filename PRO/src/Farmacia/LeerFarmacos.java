package Farmacia;

import java.io.*;
import java.util.Objects;

public class LeerFarmacos {

    private final FileReader fileReader;
    private final BufferedReader bufferedReader;

    public LeerFarmacos(String fileName) throws FileNotFoundException {
        File ficheroFarmacos = new File(Objects.requireNonNull(this.getClass().getResource(fileName + ".txt")).getFile());

        if (!ficheroFarmacos.exists()) {
            System.err.println("Fichero .txt no existente, créalo antes de ejecutar el programa");
            System.exit(0);
        }

        fileReader = new FileReader(ficheroFarmacos);
        bufferedReader= new BufferedReader(fileReader);
    }

    public void CloseAll() throws IOException {
        fileReader.close();
        bufferedReader.close();
    }

    public BufferedReader getBufferedReader() {
        return this.bufferedReader;
    }
}
