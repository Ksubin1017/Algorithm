import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[k + 1];

        q.offer(new int[]{a, 0});
        visited[a] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int num = cur[0];
            int cnt = cur[1];

            if(num == k) {
                System.out.println(cnt);
                break;
            }

            if(num + 1 <= k && !visited[num + 1]) {
                visited[num + 1] = true;
                q.offer(new int[]{num + 1, cnt + 1});
            }

            if(num * 2 <= k && !visited[num * 2]) {
                visited[num * 2] = true;
                q.offer(new int[]{num * 2, cnt + 1});
            }
        }
    }
}
