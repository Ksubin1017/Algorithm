import java.io.*;
import java.util.*;

public class Main {
    public static boolean[][] graph;
    public static boolean[] visited;
    public static int answer, n, m;

    public static void DFS(int idx) {
        visited[idx] = true;
        answer++;

        for(int i = 1; i <= n; i++) {
            if(!visited[i] && graph[idx][i]) {
                DFS(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        graph = new boolean[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x][y] = true;
            graph[y][x] = true;
        }
        DFS(1);
        bw.write(String.valueOf(answer - 1));
        bw.close();
        br.close();
    }
}
