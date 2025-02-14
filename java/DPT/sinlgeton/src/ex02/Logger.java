package ex02;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Logger {
    private static Logger log;

    private String name;

    private Logger(String name) {
        this.name = name;
    }

    public static Logger getInstance(String name){
        if (log == null){
            log = new Logger(name);
        }
        return log;
    }

    public boolean log(String logText){

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("application_log.txt", true));
            //BufferedWriter bw = new BufferedWriter(new FileWriter("ex01.txt", true));
            bw.write(logText + ";\n");
            bw.close();
        } catch (IOException e) {
            return false;
        }

        return true;
    }
}
