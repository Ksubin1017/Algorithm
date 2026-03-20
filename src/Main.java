import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] penny;

    static int bfs(int start) {
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[2001];
        int offset = 1000;

        q.offer(new int[]{start, 0});
        visited[offset] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int money = cur[0];
            int cnt = cur[1];

            if(money == M) return cnt;

            for(int i = 0; i < N; i++) {
                int next = money + penny[i];

                if (next < -1000 || next > 1000) continue;

                if (!visited[next + offset]) {
                    visited[next + offset] = true;
                    q.offer(new int[]{next, cnt + 1});
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        penny = new int[N];

        if (N > 0) {
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                penny[i] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs(0));
    }
}