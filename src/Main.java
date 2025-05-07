import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i <= n; i++) {
            queue.add(i);
        }

        while(queue.size() > 1) {
            for(int i = 0; i < k-1; i++) {
                int temp = queue.poll();
                queue.add(temp);
            }

            int num = queue.poll();
            sb.append(num).append(", ");
        }

        int num = queue.poll();
        sb.append(num).append(">");

        System.out.println(sb.toString());
    }
}
