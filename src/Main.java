import java.io.*;
import java.util.*;

public class Main {
    static int H, W, MAX = 110;
    static boolean[][] graph;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static void dfs(int y, int x) {
        visited[y][x] = true;

        for (int k = 0; k < 4; k++) {
            int ny = y + dy[k];
            int nx = x + dx[k];

            if(!visited[ny][nx] && graph[ny][nx]) {
                dfs(ny, nx);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            graph = new boolean[MAX][MAX];
            visited = new boolean[MAX][MAX];

            for(int i = 1; i <= H; i++) {
                String s = br.readLine();
                for(int j = 1; j <= W; j++) {
                    if(s.charAt(j - 1) == '#') graph[i][j] = true;
                }
            }

            int cnt = 0;

            for(int i = 1; i <= H; i++) {
                for(int j = 1; j <= W; j++) {
                    if(graph[i][j] && !visited[i][j]) {
                        dfs(i, j);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }
}