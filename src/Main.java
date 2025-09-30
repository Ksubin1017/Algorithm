import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] graph;
    static boolean[][] visited;
    static int answer;
    static int max = 50 + 10;
    static int n, m;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void dfs(int y, int x) {
        visited[y][x] = true;

        for(int k = 0; k < dx.length; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if(!visited[ny][nx] && graph[ny][nx]) {
                dfs(ny, nx);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            if(w == 0 && h == 0) break;

            graph = new boolean[max][max];
            visited = new boolean[max][max];
            answer = 0;

            for(int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < w; j++) {
                    int x = Integer.parseInt(st.nextToken());
                    if(x == 1) graph[i + 1][j + 1] = true;
                }
            }

            for(int i = 1; i <= h; i++) {
                for(int j = 1; j <= w; j++) {
                    if(graph[i][j] && !visited[i][j]) {
                        dfs(i, j);
                        answer++;
                    }
                }
            }

            bw.write(answer + "\n");
        }

        bw.close();
        br.close();
    }
}
