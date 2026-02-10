import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        int count = 0;

        while(s.length() > 1) {
            int sum = 0;
            for(int i = 0; i < s.length(); i++) {
                sum += s.charAt(i) - '0';
            }

            s = String.valueOf(sum);
            count++;
        }

        int num = s.charAt(0) - '0';

        bw.write(count + "\n" + (num % 3 == 0 ? "YES" : "NO"));

        bw.flush();
        bw.close();
    }
}
