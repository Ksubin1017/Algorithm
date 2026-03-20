import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K, X;
    static List<Integer>[] graph;
    static int[] DIST;

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(X);
        DIST[X] = 0;

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int next : graph[now]) {
                if (DIST[next] == -1) {
                    DIST[next] = DIST[now] + 1;
                    q.offer(next);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph[A].add(B);
        }

        DIST = new int[N + 1];
        Arrays.fill(DIST, -1);

        bfs();

        boolean found = false;
        for (int i = 1; i <= N; i++) {
            if (DIST[i] == K) {
                System.out.println(i);
                found = true;
            }
        }

        if (!found) System.out.println(-1);
    }
}