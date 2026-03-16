import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static String answer = "No";
    static boolean[][] graph;
    static boolean[][] visited;
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};

    static void dfs(int y, int x) {
        visited[y][x] = true;

        if(y == M - 1 && x == N - 1) {
            answer = "Yes";
            return;
        }

        for(int k = 0; k < 2; k++) {
            int ny = y + dy[k];
            int nx = x + dx[k];

            if(ny < 0 || ny >= M || nx < 0 || nx >= N) continue;

            if(graph[ny][nx] && !visited[ny][nx]) {
                visited[ny][nx] = true;
                dfs(ny,nx);
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new boolean[M][N];
        visited = new boolean[M][N];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                int x = Integer.parseInt(st.nextToken());

                if(x == 1) graph[i][j] = true;
            }
        }

        dfs(0, 0);
        System.out.println(answer);

    }
}
