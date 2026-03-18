import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static boolean[][] graph;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int dfs(int y, int x) {
        visited[y][x] = true;
        int cnt = 1;

        for (int k = 0; k < 4; k++) {
            int ny = y + dy[k];
            int nx = x + dx[k];

            if (ny < 0 || ny > N || nx < 0 || nx > M) continue;

            if (graph[ny][nx] && !visited[ny][nx]) {
                cnt += dfs(ny, nx);
            }
        }

        return cnt;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new boolean[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];

        for (int i = 1; i <= K; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a][b] = true;

        }

        int max = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (graph[i][j] && !visited[i][j]) {
                    int size = dfs(i, j);
                    max = Math.max(max, size);
                }
            }
        }

        System.out.println(max);
    }
}