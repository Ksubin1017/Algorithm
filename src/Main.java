import java.io.*;
import java.util.*;

public class Main {
    static int N, S;
    static int[] graph;
    static boolean[] visited;

    static int bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(S);
        visited[S] = true;
        int cnt = 1;

        while(!q.isEmpty()) {
            int cur = q.poll();
            int jump = graph[cur];

            int next1 = cur + jump;
            int next2 = cur - jump;

            if(next1 <= N && !visited[next1]) {
                q.offer(next1);
                visited[next1] = true;
                cnt++;
            }

            if(next2 >= 1 && !visited[next2]) {
                q.offer(next2);
                visited[next2] = true;
                cnt++;
            }
        }

        return cnt;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        graph = new int[N + 1];
        visited = new boolean[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= N; i++) {
            graph[i] = Integer.parseInt(st.nextToken());
        }

        S = Integer.parseInt(br.readLine());

        System.out.println(bfs());
    }
}