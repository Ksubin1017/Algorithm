import java.io.*;
import java.util.*;

public class Main {
    static int f, s, g, u, d;
    static boolean[] visited;
    static String bfs() {
        if((s < g && u <= 0) || (s > g && d <= 0)) return "use the stairs";

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{s, 0});
        visited[s] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int curS = cur[0];
            int cnt = cur[1];

            if(curS == g) return String.valueOf(cnt);

            int up = curS + u;
            if(up <= f && !visited[up]) {
                visited[up] = true;
                q.offer(new int[]{up, cnt + 1});
            }

            int down = curS - d;
            if(down >= 1 && !visited[down]) {
                visited[down] = true;
                q.offer(new int[]{down, cnt + 1});
            }
        }

        return "use the stairs";
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        visited = new boolean[f + 1];
        bw.write(bfs());

        bw.flush();
        bw.close();
    }
}
