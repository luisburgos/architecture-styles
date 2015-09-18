package mvc.votations.misc;

import com.google.gson.Gson;
import mvc.votations.model.Candidate;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by luisburgos on 2/09/15.
 */
public class JSONtoCandidates {

    private static String FILE_PATH = "src/main/java/mvc/votations/candidates.json";

    public static ArrayList<Candidate> loadCandidates() {

        Gson gson = new Gson();
        Candidate[] result = null;
        ArrayList<Candidate> candidates = null;

        try {
            BufferedReader br = new BufferedReader(new FileReader(FILE_PATH));
            result = gson.fromJson(br, Candidate[].class);
            candidates = new ArrayList<Candidate>();
            candidates.addAll(Arrays.asList(result));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return candidates;
    }
}
