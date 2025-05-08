import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Deque<Integer> deque = new ArrayDeque<>();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            switch (a) {
                case 1:
                    deque.addFirst(Integer.parseInt(st.nextToken()));
                    break;

                case 2:
                    deque.addLast(Integer.parseInt(st.nextToken()));
                    break;

                case 3:
                    if (deque.isEmpty()) {
                        System.out.println(-1);
                        break;
                    } else {
                        System.out.println(deque.pollFirst());
                        break;
                    }
                case 4:
                    if (deque.isEmpty()) {
                        System.out.println(-1);
                        break;
                    } else {
                        System.out.println(deque.pollLast());
                        break;
                    }
                case 5:
                    System.out.println(deque.size());
                    break;

                case 6:
                    int x = deque.isEmpty() ? 1 : 0;
                    System.out.println(x);
                    break;

                case 7:
                    int y = !deque.isEmpty() ? deque.peekFirst() : -1;
                    System.out.println(y);
                    break;

                case 8:
                    int z = !deque.isEmpty() ? deque.peekLast() : -1;
                    System.out.println(z);
                    break;
            }
        }
    }
}
