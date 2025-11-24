import java.io.*;
import java.util.*;

public class Main {
    public int solution(String s) {
        int answer = 0;
        char x = s.charAt(0);
        int same = 0, diff = 0;

        for (int i = 0; i < s.length(); i++) {
            char now = s.charAt(i);

            if (same == 0 && diff == 0) {
                x = now;
            }

            if (now == x) same++;
            else diff++;

            if (same == diff) {
                answer++;
                same = 0;
                diff = 0;
            }
        }

        if (same != 0 || diff != 0) answer++;

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Main main = new Main();

        bw.write(main.solution(br.readLine()) + "");

        bw.flush();
        bw.close();
        br.close();
    }
}
