import java.io.*;
import java.util.*;

public class OpenCsv {
    public ArrayList<ArrayList<String>> openCsv(String filename) {
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        try {
            File f = new File("./", filename + ".csv");
            BufferedReader p = new BufferedReader(new FileReader(f));

            String line; //
            while ((line = p.readLine()) != null) {
                ArrayList<String> record = new ArrayList<>(Arrays.asList(line.split(",", 0)));
                data.add(record);
            }

            p.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}