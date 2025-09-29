import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int max = 1000 + 10;
    static boolean[][] map;
    static boolean[][] visited;
    static String answer;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void dfs(int y, int x) {
        visited[y][x] = true;
        if(y == m) {
            answer = "YES";
            return;
        }
        for(int k = 0; k < 4; k++) {
            int ny = y + dy[k];
            int nx = x + dx[k];

            if(!visited[ny][nx] && map[ny][nx]) {
                dfs(ny, nx);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new boolean[max][max];
        visited = new boolean[max][max];
        answer = "NO";

        for(int i = 1; i <= m; i++) {
            String str = br.readLine();
            for(int j = 1; j <= n; j++) {
                if(str.charAt(j - 1) == '0') {
                    map[i][j] = true;
                }
            }
        }

        for (int j = 1; j <= n; j++)
            if (map[1][j]) dfs(1, j);

        bw.write(answer);
        bw.close();
        br.close();
    }
}
