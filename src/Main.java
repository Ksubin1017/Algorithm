import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            long sum = 0;

            for (int j = 0; j < count; j++) {
                sum += Long.parseLong(st.nextToken());
            }
            arr[i] = sum;
        }

        Arrays.sort(arr);

        long total = 0;
        long answer = 0;

        for (long s : arr) {
            total += s;
            answer += total;
        }


        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }
}
