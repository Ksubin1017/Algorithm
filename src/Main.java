import java.io.*;
import java.util.*;

public class Main {

    public int solution(String str) {
        int n = Integer.parseInt(str);
        int len = str.length();

        int start = Math.max(1, n - 9 * len);

        for (int i = start; i < n; i++) {
            int sum = i;
            int tmp = i;

            while (tmp > 0) {
                sum += tmp % 10;
                tmp /= 10;
            }

            if (sum == n) return i;
        }

        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Main T = new Main();

        String str = br.readLine();

        bw.write(String.valueOf(T.solution(str)));
        bw.close();
        br.close();
    }
}
