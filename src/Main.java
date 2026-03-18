import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] graph;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int dfsB(int y, int x) {
        visited[y][x] = true;
        int cnt = 1;

        for(int k = 0; k < 4; k++) {
            int ny = y + dy[k];
            int nx = x + dx[k];

            if(ny < 1 || ny > M || nx < 1 || nx > N) continue;

            if(!visited[ny][nx] && graph[ny][nx] == 'B') {
                cnt += dfsB(ny, nx);
            }
        }

        return cnt;
    }

    static int dfsW(int y, int x) {
        visited[y][x] = true;
        int cnt = 1;

        for(int k = 0; k < 4; k++) {
            int ny = y + dy[k];
            int nx = x + dx[k];

            if(ny < 1 || ny > M || nx < 1 || nx > N) continue;

            if(!visited[ny][nx] && graph[ny][nx] == 'W') {
                cnt += dfsW(ny, nx);
            }
        }

        return cnt;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new char[M + 1][N + 1];
        visited = new boolean[M + 1][N + 1];

        for(int i = 1; i <= M; i++) {
            String s = br.readLine();
            for(int j = 1; j <= N; j++) {
                graph[i][j] = s.charAt(j - 1);
            }
        }

        int sumB = 0;
        int sumW = 0;

        for(int i = 1; i <= M; i++) {
            for(int j = 1; j <= N; j++) {
                if(!visited[i][j] && graph[i][j] == 'B') {
                    int size = dfsB(i, j);
                    sumB += size * size;
                }
            }
        }

        visited = new boolean[M + 1][N + 1];
        for(int i = 1; i <= M; i++) {
            for(int j = 1; j <= N; j++) {
                if(!visited[i][j] && graph[i][j] == 'W') {
                    int size = dfsW(i, j);
                    sumW += size * size;
                }
            }
        }

        System.out.println(sumW + " " + sumB);
    }
}