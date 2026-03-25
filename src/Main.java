import java.io.*;
import java.util.*;

public class Main {
    static int N, A, B;
    static int[] graph;
    static boolean[] visited;

    static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{A, 0});
        visited[A] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int loc = cur[0];
            int cnt = cur[1];

            if (loc == B) return cnt;

            int jump = graph[loc];

            for(int k = 1; loc + jump * k <= N; k++) {
                int next = loc + jump * k;
                if(visited[next]) continue;

                visited[next] = true;
                q.offer(new int[]{next, cnt + 1});
            }

            for(int k = 1; loc - jump * k >= 1; k++) {
                int next = loc - jump * k;
                if(visited[next]) continue;

                visited[next] = true;
                q.offer(new int[]{next, cnt + 1});
            }
        }

        return -1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        graph = new int[N + 1];
        visited = new boolean[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            graph[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        System.out.println(bfs());
    }
}