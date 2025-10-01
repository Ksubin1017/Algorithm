import java.io.*;
import java.util.*;

public class Main {
    static int[][] graph;
    static boolean[][] visited;
    static int n;
    static String answer = "Hing";

    public static void dfs(int y, int x) {
        if(y > 3 || x > 3) return;
        if(y == n && x == n) answer = "HaruHaru";
        visited[y][x] = true;
        int cnt = graph[y][x];

        if(!visited[y + cnt][x]) dfs(y + cnt, x);
        if(!visited[y][x + cnt]) dfs(y, x + cnt);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int max = 100 + 10;
        n = Integer.parseInt(br.readLine());
        graph = new int[max][max];
        visited = new boolean[max][max];
        for(int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(1, 1);

        bw.write(String.valueOf(answer));
        bw.close();
        br.close();
    }
}
