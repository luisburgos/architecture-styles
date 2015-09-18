package pipesandfilters.kwiclogger.filtro.logger;

import pipesandfilters.kwiclogger.filtro.util.*;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * Created by luisburgos on 27/08/15.
 */
public class FileHandler extends LogHandler {

    public static final String TAG = "FILE: ";
    private final String FILE_PATH = "src/log.txt";
    private PrintWriter bw;

    public FileHandler(){
        createLogFile();
    }

    @Override
    public void log(Class className, String message) {
        addToLogFile(
                Utils.getCurrentDate()    + " | " +
                Utils.getCurrentHour()    + " | " +
                className.getSimpleName() + " | " +
                message
        );
    }

    public void createLogFile(){
        try {
            File archivo = new File(FILE_PATH);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al crear bitacora.");
        }
    }

    public void addToLogFile(String finalMessage){
        try {
            bw = new PrintWriter(new FileWriter(FILE_PATH, true));
            bw.println(finalMessage);
            bw.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
