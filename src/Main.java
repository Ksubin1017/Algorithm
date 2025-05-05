import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>(); 
        Stack<Integer> stack2 = new Stack<>();

        int cnt = 1;
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            queue.offer(Integer.parseInt(st.nextToken()));
        }

        while (true) {
            if (queue.isEmpty() && stack2.isEmpty()) {
                System.out.println("Nice");
                break;
            }

            if (!queue.isEmpty() && queue.peek() == cnt) {
                queue.poll();
                cnt++;
            } else if (!stack2.isEmpty() && stack2.peek() == cnt) {
                stack2.pop();
                cnt++;
            } else if (!queue.isEmpty()) {
                stack2.push(queue.poll());
            } else {
                System.out.println("Sad");
                break;
            }
        }
    }
}
