import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    static int bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        visited = new boolean[N + 1];

        q.add(start);
        visited[start] = true;

        int cnt = 1;

        while(!q.isEmpty()) {
            int cur = q.poll();

            for(int next : graph[cur]) {
                if(!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[b].add(a);
        }

        int[] result = new int[N + 1];
        int max = 0;

        for(int i = 1; i <= N; i++) {
            result[i] = bfs(i);
            max = Math.max(max, result[i]);
        }

        for(int i = 1; i <= N; i++) {
            if(result[i] == max) {
                System.out.print(i + " ");
            }
        }
    }
}