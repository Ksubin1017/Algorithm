import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];

        for(int i = 1; i <= n; i++) {
            arr[i] = i;
        }

        int lt = 1;
        int rt = 1;
        int answer = 0;
        int sum = 0;

        while(rt <= n) {
            if(sum + arr[rt] < n) {
                sum += arr[rt++];
            } else if(sum + arr[rt] == n) {
                answer++;
                sum -= arr[lt++];
            } else {
                sum -= arr[lt++];
            }
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }
}
