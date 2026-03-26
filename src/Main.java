import java.io.*;
import java.util.*;

public class Main {
    static int A, B, N, M;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{A, 0});
        visited[A] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int loc = cur[0];
            int cnt = cur[1];

            if(loc == B) return cnt;

            for(int next : graph[loc]) {
                if(!visited[next]) {
                    visited[next] = true;
                    q.offer(new int[]{next, cnt + 1});
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for(int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }

        System.out.println(bfs());
    }
}