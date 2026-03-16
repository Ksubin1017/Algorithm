import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[][] graph;
    static boolean[] visited;
    static int CNT = -1;

    static void dfs(int x) {
        visited[x] = true;
        CNT++;

        for(int i = 1; i <= N; i++) {
            if(!visited[i] && graph[x][i]) {
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];

        for(int i = 1; i <= M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = true;
            graph[b][a] = true;
        }

        dfs(1);

        System.out.println(CNT);
    }
}
