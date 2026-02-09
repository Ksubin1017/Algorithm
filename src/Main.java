import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        String youngest = "";
        String oldest = "";
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            int d = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int birth = y * 10000 + m * 100 + d;

            if (birth > max) {
                max = birth;
                youngest = name;
            }
            if (birth < min) {
                min = birth;
                oldest = name;
            }
        }

        bw.write(youngest + "\n" + oldest);
        bw.flush();
        bw.close();
    }
}
