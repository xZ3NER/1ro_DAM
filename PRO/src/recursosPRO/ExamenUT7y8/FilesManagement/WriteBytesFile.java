package recursosPRO.ExamenUT7y8.FilesManagement;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class WriteBytesFile {

    private File file;
    private FileOutputStream fileOutputStream;

    public WriteBytesFile(String path) throws IOException {

        this.file = new File(path); //ruta relativa (PRO/...)

        this.fileOutputStream = new FileOutputStream(this.file);

    }

    public void writeLines(String line) throws IOException {
        line += "\n";

        fileOutputStream.write(line.getBytes(StandardCharsets.UTF_8));
    }

    public void close() throws IOException {
        fileOutputStream.close();
    }
}
