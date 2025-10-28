import java.io.*;
import java.util.*;

public class Main {

    public int solution(int n) {
        int answer = 1;
        int idx = 666;

        while(true) {
            String str = String.valueOf(idx);
            if(str.contains("666")) {
                if(answer == n) {
                    return idx;
                } else {
                    answer++;
                }
            }
            idx++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Main T = new Main();

        int n = Integer.parseInt(br.readLine());

        bw.write(String.valueOf(T.solution(n)));
        bw.close();
        br.close();
    }
}
