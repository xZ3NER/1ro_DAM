package ExamenUT7y8.FilesManagement;

import java.io.*;
import java.util.Objects;
import java.util.Vector;

public class ReadBytesFile {

    private File file;
    private FileInputStream fileInputStream;

    public ReadBytesFile(String path) throws IOException {
        try {
            this.file = new File(Objects.requireNonNull(this.getClass().getResource(path)).getFile());

            this.fileInputStream = new FileInputStream(this.file);

        }catch (NullPointerException e) {
            System.out.println("File doesn't exists");
        }
    }

    public void readLines() throws IOException {
        int character;

        while ((character=this.fileInputStream.read())!=-1) {
            System.out.print((char)(character-4));
        }
    }

    public Vector<Character> readLinesCodificado() throws IOException {
        Vector<Character> vector = new Vector<>();

        int character;

        while ((character=this.fileInputStream.read())!=-1) {
            vector.add((char)(character+4));
        }

        return vector;
    }

    public void close() throws IOException {
        fileInputStream.close();
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public FileInputStream getFileInputStream() {
        return fileInputStream;
    }

    public void setFileInputStream(FileInputStream fileInputStream) {
        this.fileInputStream = fileInputStream;
    }
}
