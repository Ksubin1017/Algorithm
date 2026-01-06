import java.io.*;
import java.util.*;

public class Main {
    static int a, b;
    static long bfs() {
        Queue<long[]> q = new ArrayDeque<>();
        q.offer(new long[]{a, 1});

        while(!q.isEmpty()) {
            long[] cur = q.poll();
            long pos = cur[0];
            long cnt = cur[1];

            if(pos == b) return cnt;
            if(pos > b) continue;

            q.offer(new long[]{pos * 2, cnt + 1});
            q.offer(new long[]{pos * 10 + 1, cnt + 1});
        }

        return -1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        bw.write(String.valueOf(bfs()));

        bw.flush();
        bw.close();
    }
}
