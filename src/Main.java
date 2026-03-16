import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        boolean[] visited = new boolean[n];

        int cur = 0;
        int cnt = 0;

        while(true) {
            if(cur == k) {
                System.out.println(cnt);
                return;
            }

            if(visited[cur]) {
                System.out.println(-1);
                return;
            }

            visited[cur] = true;
            cur = arr[cur];
            cnt++;
        }
    }
}
