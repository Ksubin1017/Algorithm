import java.io.*;
import java.util.*;

public class Main {
    static int[][] graph;
    static int[][] dp;
    static int m, n;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int dfs(int y, int x) {
        if (y == m && x == n) return 1;

        if (dp[y][x] != -1) return dp[y][x];

        dp[y][x] = 0;

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx >= 1 && nx <= n && ny >= 1 && ny <= m) {
                if (graph[ny][nx] < graph[y][x]) {
                    dp[y][x] += dfs(ny, nx);
                }
            }
        }

        return dp[y][x];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        graph = new int[m + 1][n + 1];
        dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1; // 아직 방문 안 한 상태
            }
        }

        bw.write(dfs(1, 1) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
