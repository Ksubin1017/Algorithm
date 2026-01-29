import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int x = Integer.parseInt(br.readLine());

        int lt = 0;
        int rt = n - 1;
        int answer = 0;

        while(lt < rt) {
            int sum = arr[lt] + arr[rt];

            if(sum == x) {
                answer++;
                lt++;
                rt--;
            } else if(sum > x) {
                rt--;
            } else {
                lt++;
            }
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }
}
