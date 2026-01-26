import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int lt = 0;
        int rt = 0;
        int sum = 0;
        int len = Integer.MAX_VALUE;

        while(true) {
            if(sum >= s) {
                len = Math.min(len, rt - lt);
                sum -= arr[lt++];
            } else {
                if(rt == n) break;
                sum += arr[rt++];
            }

        }

        if(len == Integer.MAX_VALUE) len = 0;
        bw.write(len + "\n");
        bw.flush();
        bw.close();
    }
}
