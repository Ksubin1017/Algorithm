import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Main main = new Main();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            arr[i] += Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        long answer = 0;

        for(int i = 0; i < n; i++) {
            int students = arr[i];
            students -= b;
            answer++;

            if(students > 0) {
                answer += (students + c - 1) / c;
            }
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
