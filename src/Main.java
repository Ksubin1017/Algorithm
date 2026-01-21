import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] graph;
    static boolean[] visited;
    static int n, m;

    static int bfs(int idx) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {idx, 0});
        visited[idx] = true;

        int count = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int node = cur[0];
            int depth = cur[1];

            if(depth >= 2) continue;

            for(int i = 1; i <= n; i++) {
                if(!visited[i] && graph[node][i]) {
                    visited[i] = true;
                    count++;
                    q.offer(new int[]{i, depth + 1});
                }
            }
        }

        return count;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        graph = new boolean[n + 1][n + 1];
        visited = new boolean[n + 1];

        for(int i = 1; i <= m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = true;
            graph[b][a] = true;
        }

        bw.write(bfs(1) + "\n");
        bw.flush();
        bw.close();
    }
}