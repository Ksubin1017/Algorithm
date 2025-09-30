import java.io.*;
import java.util.*;

public class Main {
    static char[][] graph;
    static boolean[][] visited;
    static int answer;
    static int[] dx = {1, -1};
    static int[] dy = {1, -1};

    public static void dfs(int y, int x) {
        visited[y][x] = true;

        if(graph[y][x] == '-' && graph[y][x + 1] == '-') dfs(y, x + 1);
        else if(graph[y][x] == '|' && graph[y + 1][x] == '|') dfs(y + 1 , x);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new char[n + 10][m + 10];
        visited = new boolean[n + 10][m + 10];
        answer = 0;

        for(int i = 1; i <= n; i++) {
            String s = br.readLine();
            for(int j = 1; j <= m; j++) {
                graph[i][j] = s.charAt(j - 1);
            }
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(!visited[i][j]) {
                    dfs(i, j);
                    answer++;
                }
            }
        }

        bw.write(String.valueOf(answer));
        bw.close();
        br.close();
    }
}
