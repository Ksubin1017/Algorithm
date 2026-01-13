import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = "";

        while((s = br.readLine()) != null) {
            int n = Integer.parseInt(s);
            int m = 1;
            int length = 1;

            while(m % n != 0) {
                m = (m * 10 + 1) % n;
                length++;
            }
            bw.write(length + "\n");
        }

        bw.flush();
        bw.close();
    }
}
