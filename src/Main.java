import java.io.*;
import java.util.*;

public class Main {
    static int A, B;
    static long bfs() {
        Queue<long[]> q = new LinkedList<>();
        q.add(new long[]{A, 1});

        while(!q.isEmpty()) {
            long[] cur = q.poll();
            long pos = cur[0];
            long cnt = cur[1];

            if(pos == B) return cnt;
            if(pos > B) continue;

            q.offer(new long[]{pos * 2, cnt + 1});
            q.offer(new long[]{pos * 10 + 1, cnt + 1});
        }

        return -1;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        System.out.println(bfs());
    }
}