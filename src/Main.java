import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();

        for(int i = 0; i < s.length(); i++) {
           if(i % 10 == 0 && i != 0) {
               sb.append("\n");
               sb.append(s.charAt(i));
           } else {
               sb.append(s.charAt(i));
           }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
