import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if(n == 0 && m == 0) break;

            int[] a = new int[n];
            int[] b = new int[m];

            for(int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(br.readLine());
            }

            for(int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(br.readLine());
            }

            int i = 0;
            int j = 0;
            int answer = 0;

            while(i < n && j < m) {
                if(a[i] == b[j]) {
                    answer++;
                    i++;
                    j++;
                } else if(a[i] < b[j]) {
                    i++;
                } else {
                    j++;
                }
            }

            bw.write(answer + "\n");
        }

        bw.flush();
        bw.close();
    }
}
