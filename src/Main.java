import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        while(queue.size() > 1) {
            queue.poll();

            int a = queue.poll();
            queue.offer(a);
        }
        System.out.println(queue.poll());
    }
}
