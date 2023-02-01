package TaskOne;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserTaskOne {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/assets/file.txt"), 24);

        Pattern pattern1 = Pattern.compile("[(][0-9]{3}[)][\\s]?[0-9]{3}[-\\s]?[0-9]{4}");
        Pattern pattern2 = Pattern.compile("[0-9]{3}[-]?[0-9]{3}[-]?[0-9]{4}");

        while (br.ready()){
           String s = br.readLine();
           Matcher m = pattern1.matcher(s);
           Matcher m2 = pattern2.matcher(s);
           if (m.matches() || m2.matches()){
               System.out.println(s);
           }
       }
       br.close();
    }
}
