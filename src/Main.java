import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] graph;
    static boolean[][] visited;
    static int n, m, cnt, area, maxWidth;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static void dfs(int y, int x) {
        visited[y][x] = true;
        area++;

        for(int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;

            if(!visited[ny][nx] && graph[ny][nx]) {
                dfs(ny, nx);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new boolean[510][510];
        visited = new boolean[510][510];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                if(Integer.parseInt(st.nextToken()) == 1) {
                    graph[i][j] = true;
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!visited[i][j] && graph[i][j]) {
                    area = 0;
                    dfs(i, j);
                    cnt++;
                    maxWidth = Math.max(maxWidth, area);
                }
            }
        }

        bw.write(cnt + "\n" + maxWidth);
        bw.flush();
        bw.close();
    }
}