import java.io.*;
import java.util.*;

public class Main {
    static int[][] graph;
    static boolean[][] visited;
    static int n, answer, cnt;
    static int size = 100 + 10;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static void dfs(int y, int x, int water) {
        visited[y][x] = true;

        for(int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if(!visited[ny][nx] && graph[ny][nx] > water) {
                dfs(ny, nx, water);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int maxHeight = 0;
        graph = new int[size][size];
        answer = 0;

        for(int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, graph[i][j]);
            }
        }

        for(int water = 0; water <= maxHeight; water++) {
            cnt = 0;
            visited = new boolean[size][size];
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    if(!visited[i][j] && (graph[i][j] > water)) {
                        dfs(i, j, water);
                        cnt++;
                    }
                }
            }
            answer = Math.max(answer, cnt);
        }

        bw.write(answer + "\n");
        bw.close();
        br.close();
    }
}
