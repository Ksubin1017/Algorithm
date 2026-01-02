import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static boolean[] visited = new boolean[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        bw.write(bfs() + "\n");
        bw.flush();
        bw.close();
    }

    static int bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{n, 0});
        visited[n] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int pos = cur[0];
            int sec = cur[1];

            if (pos == k) return sec;

            int[] next = {pos - 1, pos + 1, pos * 2};
            for (int nx : next) {
                if (nx < 0 || nx > 100000) continue;
                if (visited[nx]) continue;

                visited[nx] = true;
                q.offer(new int[]{nx, sec + 1});
            }
        }
        return -1;
    }
}
