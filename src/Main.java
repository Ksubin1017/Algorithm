import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int answer = 5;
        int l = 0;

        for(int r = 0; r < n; r++) {
            while(arr[r] - arr[l] > 4) {
                l++;
            }
            int len = r - l + 1;
            answer = Math.min(answer, 5 - len);
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }
}
