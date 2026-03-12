import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int dasom = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 1; i < n; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int cnt = 0;

        while(!pq.isEmpty() && pq.peek() >= dasom) {
            int top = pq.poll();
            top--;
            dasom++;
            cnt++;

            pq.add(top);
        }

        System.out.println(cnt);
    }
}
