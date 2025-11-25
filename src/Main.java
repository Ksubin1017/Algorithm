import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        int[][] arr = new int[t][2];

        while(t-- > 0) {
            int[] line = new int[20];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            for(int i = 0; i < 20; i++) line[i] = Integer.parseInt(st.nextToken());
            int cnt = 0;

            for(int i = 19; i > 0; i--) {
                for(int j = i - 1; j >= 0; j--) {
                    if(line[i] < line[j]) {
                        cnt++;
                    }
                }
            }

            arr[n - 1][0] = n;
            arr[n - 1][1] = cnt;
        }

        for(int[] i : arr) {
            bw.write(i[0] + " " + i[1] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
