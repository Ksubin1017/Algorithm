import java.io.*;
import java.util.*;

public class Main {
    static int n, m, r;
    static boolean[][] graph;
    static boolean[] visited;
    static ArrayList<Integer> queue;

    public static void dfs(int idx) {
        visited[idx] = true;
        System.out.print(idx + " ");

        for(int i = 1; i <= n; i++) {
            if(!visited[i] && graph[idx][i]) {
                dfs(i);
            }
        }
    }

    public static void bfs() {
        queue = new ArrayList<>();
        visited = new boolean[n + 1];

        queue.add(r);
        visited[r] = true;

        while(!queue.isEmpty()) {
            int idx = queue.remove(0);
            System.out.print(idx + " ");

            for(int i = 1; i <= n; i++) {
                if(!visited[i] && graph[idx][i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        graph = new boolean[n + 1][n + 1];
        visited = new boolean[n + 1];

        for(int i = 1; i <= m; i++) {
            st= new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = true;
            graph[y][x] = true;
        }

        dfs(r);
        System.out.println();
        bfs();

        bw.close();
        br.close();
    }
}
