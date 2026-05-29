import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Queue<Integer> q = new ArrayDeque<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = 0;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if(st.hasMoreTokens()) {
                x = Integer.parseInt(st.nextToken());
            }

            if(s.equals("push")) {
                if(q.size() < m) q.offer(x);
                else System.out.println("Overflow");
            } else {
                if(q.isEmpty()) System.out.println("Underflow");
                else System.out.println(q.poll());
            }
        }


    }
}