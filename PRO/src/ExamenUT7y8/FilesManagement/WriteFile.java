package ExamenUT7y8.FilesManagement;

import java.io.*;

public class WriteFile {

    private File file;
    private FileWriter fileWriter;
    private BufferedWriter bufferedWriter;

    public WriteFile(String path) throws IOException {
        this.file = new File(path); //ruta relativa (PRO/...)

        this.fileWriter = new FileWriter(this.file);
        this.bufferedWriter = new BufferedWriter(this.fileWriter);

    }

    public void writeLine(String line) throws IOException {
        bufferedWriter.write(line);
        bufferedWriter.flush();
    }

    public void close() throws IOException {
        bufferedWriter.close();
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public FileWriter getFileWriter() {
        return fileWriter;
    }

    public void setFileWriter(FileWriter fileWriter) {
        this.fileWriter = fileWriter;
    }

    public BufferedWriter getBufferedWriter() {
        return bufferedWriter;
    }

    public void setBufferedWriter(BufferedWriter bufferedWriter) {
        this.bufferedWriter = bufferedWriter;
    }
}
