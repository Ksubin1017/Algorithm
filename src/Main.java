import java.io.*;
import java.util.*;

public class Main {
    static char[][] graph;
    static int answer;
    static int max = 20 + 10;
    static HashMap<Character, Integer> map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static void dfs(int y, int x, int cnt) {
        map.put(graph[y][x], map.getOrDefault(graph[y][x], 0) + 1);
        answer = Math.max(answer, cnt);

        for (int k = 0; k < 4; k++) {
            int ny = y + dy[k];
            int nx = x + dx[k];

            if(graph[ny][nx] != 0 && map.get(graph[ny][nx]) == null) {
                dfs(ny, nx, cnt + 1);
                map.remove(graph[ny][nx]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        graph = new char[max][max];
        answer = 0;

        map = new HashMap<>();

        for(int i = 1; i <= r; i++) {
            String str = br.readLine();
            for(int j = 1; j <= c; j++) {
                graph[i][j] = str.charAt(j - 1);
            }
        }

        map.put(graph[1][1], 1);
        dfs(1, 1, 1);


        bw.write(answer + "\n");
        bw.close();
        br.close();
    }
}
