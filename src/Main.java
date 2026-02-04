import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n  = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int l = 0;
        int r = n - 1;
        int answer = 0;

        while(l < r) {
            if(arr[l] + arr[r] == m) {
                answer++;
                l++;
                r--;
            } else if(arr[l] + arr[r] < m){
                l++;
            } else {
                r--;
            }
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }
}
