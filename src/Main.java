import java.io.*;
import java.util.*;

public class Main {
    static int x, y;
    static boolean[][] graph;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0, 1});
        visited[0][0] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int by = cur[0];
            int bx = cur[1];
            int cnt = cur[2];

            if(by == y - 1 && bx == x - 1) return cnt;

            for(int k = 0; k < 4; k++) {
                int ny = by + dy[k];
                int nx = bx + dx[k];

                if(ny < 0 || ny >= y || nx < 0 || nx >= x) continue;
                if(!graph[ny][nx]) continue;
                if(visited[ny][nx]) continue;

                visited[ny][nx] = true;

                q.offer(new int[]{ny, nx, cnt + 1});
            }

        }

        return -1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        graph = new boolean[y][x];
        visited = new boolean[y][x];

        for(int i = 0; i < y; i++) {
            String line = br.readLine();
            for(int j = 0; j < x; j++) {
                graph[i][j] = line.charAt(j) == '1';
            }
        }

        bw.write(String.valueOf(bfs()));

        bw.flush();
        bw.close();
    }
}
