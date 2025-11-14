import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++) {
            int a = Integer.parseInt(br.readLine());

            if(a == 0) {
                stack.pop();
            } else {
                stack.push(a);
            }
        }

        int answer = 0;
        for(int i : stack) {
            answer += i;
        }
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
