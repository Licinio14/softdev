package ex04;

import ex02.Logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {
    private static FileManager file;

    private String rootDirectory;

    private FileManager(String rootDirectory) {
        this.rootDirectory = rootDirectory;
    }

    public static FileManager getFileManager(String rootDirectory){
        if (file == null){
            file = new FileManager(rootDirectory);
        }
        return file;
    }

    public void setRootDirectory(String rootDirectory) {
        this.rootDirectory = rootDirectory;
    }

    public boolean createFile(String name){
        String filepath = rootDirectory + name;

        try {
            File file = new File(filepath);
            file.createNewFile();
            return true;
        }catch (IOException e){
            System.out.println("erro ao criar ficheiro!");
        }

        return false;
    }

    public boolean deleteFile(String name){
        String filepath = rootDirectory + name;

        File file = new File(filepath);
        file.deleteOnExit();
        return true;
    }
}
