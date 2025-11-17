import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i <= n; i++) {
            q.offer(i);
        }

        int idx = 1;

        while(q.size() > 1) {
            if(idx % 2 != 0) {
                q.poll();
            } else {
                q.offer(q.poll());
            }

            idx++;
        }

        bw.write(q.poll().toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
