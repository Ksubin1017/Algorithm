import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] graph;
    static boolean[][] visited;
    static int answer, cnt, m, n, k;
    static int max = 100 + 10;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static void dfs(int y, int x) {
        visited[y][x] = true;
        cnt++;

        for (int k = 0; k < 4; k++) {
            int ny = y + dy[k];
            int nx = x + dx[k];

            if (ny >= 0 && ny < m && nx >= 0 && nx < n) {
                if (!visited[ny][nx] && !graph[ny][nx]) {
                    dfs(ny, nx);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        graph = new boolean[max][max];
        visited = new boolean[max][max];

        for (int i = 1; i <= k; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int y = y1; y < y2; y++) {
                for (int x = x1; x < x2; x++) {
                    graph[y][x] = true;
                }
            }
        }

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && !graph[i][j]) {
                    cnt = 0;
                    dfs(i, j);
                    answer++;
                    list.add(cnt);
                }
            }
        }
        Collections.sort(list);
        bw.write(answer + "\n");
        for (int i : list) {
            bw.write(i + " ");
        }

        bw.close();
        br.close();
    }
}