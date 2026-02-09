import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        int n = s.length();
        String answer = null;

        for (int i = 1; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {

                String a = new StringBuilder(s.substring(0, i)).reverse().toString();
                String b = new StringBuilder(s.substring(i, j)).reverse().toString();
                String c = new StringBuilder(s.substring(j)).reverse().toString();

                String result = a + b + c;

                if (answer == null || result.compareTo(answer) < 0) {
                    answer = result;
                }
            }
        }

        bw.write(answer);
        bw.flush();
        bw.close();
    }
}
