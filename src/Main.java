import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] graph;
    static boolean[][] visited;
    static int n, cnt, answer;
    static int max = 25 + 10;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static void dfs(int y, int x) {
        visited[y][x] = true;
        cnt++;

        for(int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if(!visited[ny][nx] && graph[ny][nx]) dfs(ny, nx);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        answer = 0;
        graph = new boolean[max][max];
        visited = new boolean[max][max];
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 1; i <= n; i++) {
            String line = br.readLine();
            for(int j = 1; j <= n; j++) {
                if(line.charAt(j - 1) == '1') graph[i][j] = true;
            }
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(!visited[i][j] && graph[i][j]) {
                    cnt = 0;
                    dfs(i, j);
                    answer++;
                    list.add(cnt);
                }
            }
        }

        Collections.sort(list);
        bw.write(answer + "\n");

        for(int i : list) {
            bw.write(i + "\n");
        }
        bw.close();
        br.close();
    }
}
