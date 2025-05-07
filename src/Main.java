import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        LinkedList<Integer> queue = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String command = st.nextToken();

            if(command.equals("push")) {
                int x = Integer.parseInt(st.nextToken());
                queue.offer(x);
            } else if(command.equals("pop")) {
                if(queue.isEmpty()) {
                    System.out.println("-1");
                } else {
                    int x = queue.poll();
                    System.out.println(x);
                }
            } else if(command.equals("size")) {
                System.out.println(queue.size());
            } else if(command.equals("empty")) {
                if(!queue.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(1);
                }
            } else if(command.equals("front")) {
                if(!queue.isEmpty()) {
                    System.out.println(queue.peek());
                } else {
                    System.out.println(-1);
                }
            } else if(command.equals("back")) {
                if(!queue.isEmpty()) {
                    System.out.println(queue.peekLast());
                } else {
                    System.out.println(-1);
                }
            }
        }
    }
}
