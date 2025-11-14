import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        Stack<Integer> s = new Stack<>();
        int cnt = 1;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            q.offer(Integer.parseInt(st.nextToken()));
        }

        while(true) {
            if(q.isEmpty() && s.isEmpty()) {
                bw.write("Nice\n");
                break;
            }

            if(!q.isEmpty() && q.peek() == cnt) {
                q.poll();
                cnt++;
            } else if(!s.isEmpty() && s.peek() == cnt) {
                s.pop();
                cnt++;
            } else if(!q.isEmpty()) {
                s.push(q.poll());
            } else {
                bw.write("Sad\n");
                break;
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
