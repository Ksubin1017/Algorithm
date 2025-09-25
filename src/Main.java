import java.io.*;
import java.util.*;

public class Main {
    static int n, m, start, end, answer = -1;
    static boolean[][] graph;
    static boolean[] visited;

    public static void dfs(int idx, int count) {
        visited[idx] = true;
        if(idx == end) {
            answer = count;
            return;
        }

        for(int i = 1; i <= n; i++) {
            if(!visited[i] && graph[idx][i]) {
                dfs(i, count + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());

        graph = new boolean[n + 1][n + 1];
        visited = new boolean[n + 1];

        for(int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = true;
            graph[y][x] = true;
        }

        dfs(start, 0);

        bw.write(String.valueOf(answer));

        bw.close();
        br.close();
    }
}
