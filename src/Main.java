import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] graph;
    static int n, k, m;

    static int bfs() {
        boolean[] visited = new boolean[n + m + 1];
        int[] dist = new int[n + m + 1];

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(1);
        visited[1] = true;
        dist[1] = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == n) {
                return dist[cur];
            }

            for (int next : graph[cur]) {
                if (visited[next]) continue;

                visited[next] = true;

                if (next > n) {
                    dist[next] = dist[cur];
                } else {
                    dist[next] = dist[cur] + 1;
                }

                q.offer(next);
            }
        }

        return -1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + m + 1];
        for (int i = 1; i <= n + m; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= m; i++) {
            int tubeNode = n + i;

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < k; j++) {
                int station = Integer.parseInt(st.nextToken());
                graph[station].add(tubeNode);
                graph[tubeNode].add(station);
            }
        }

        bw.write(bfs() + "\n");
        bw.flush();
        bw.close();
    }
}
