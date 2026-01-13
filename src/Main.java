import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        long sum = 0;

        for(int i = 1; i <= n; i++) {
            sum += (long) i * (n / i);
        }

        bw.write(sum + "\n");
        bw.flush();
        bw.close();
    }
}
