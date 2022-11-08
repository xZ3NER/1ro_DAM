package ExamenUT7y8.FilesManagement;

import java.io.*;
import java.util.Objects;

public class ReadFile {

    private File file;
    private FileReader fileReader;
    private BufferedReader bufferedReader;

    public ReadFile(String path) throws IOException {
        try {
            this.file = new File(Objects.requireNonNull(this.getClass().getResource(path)).getFile());

            this.fileReader = new FileReader(this.file);
            this.bufferedReader = new BufferedReader(this.fileReader);
        }catch (NullPointerException e) {
            System.out.println("File doesn't exists");
        }
    }

    public void readLines() throws IOException {
        String line;

        while ((line = this.bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
    }

    public void close() throws IOException {
        bufferedReader.close();
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public FileReader getFileReader() {
        return fileReader;
    }

    public void setFileReader(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    public BufferedReader getBufferedReader() {
        return bufferedReader;
    }

    public void setBufferedReader(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }
}
