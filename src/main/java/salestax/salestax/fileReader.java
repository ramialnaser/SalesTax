package salestax.salestax;

import java.io.*;
import java.util.ArrayList;

public class fileReader {

    private ArrayList<String> productName ;

    public ArrayList<String> readInputFile(String inputFileName){
        productName = new ArrayList<>();
        try {

            BufferedReader br = new BufferedReader(new FileReader(inputFileName));

        String st;
        while ((st = br.readLine()) != null)
            productName.add(st);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return productName;
    }


}
