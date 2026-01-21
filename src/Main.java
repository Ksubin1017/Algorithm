import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] graph;
    static int[] dist;
    static int n, m;

    static void bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        Arrays.fill(dist, -1);

        q.offer(start);
        dist[start] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : graph[cur]) {
                if (dist[next] == -1) {
                    dist[next] = dist[cur] + 1;
                    q.offer(next);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        dist = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        bfs(1);

        int maxDistance = 0;
        int num = Integer.MAX_VALUE;
        int cnt = 0;

        for (int i = 1; i <= n; i++) {
            if (dist[i] > maxDistance) {
                maxDistance = dist[i];
                num = i;
                cnt = 1;
            } else if (dist[i] == maxDistance) {
                cnt++;
                num = Math.min(num, i);
            }
        }

        System.out.println(num + " " + maxDistance + " " + cnt);
    }
}
