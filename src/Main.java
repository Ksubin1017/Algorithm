import java.io.*;
import java.util.*;

public class Main {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
        boolean[] skipArr = new boolean[26];

        for(char c : skip.toCharArray()) {
            skipArr[c - 'a'] = true;
        }

        for(char c : s.toCharArray()) {
            int cnt = 0;
            char cur = c;

            while(cnt < index) {
                cur++;

                if(cur > 'z') cur = 'a';
                if(!skipArr[cur - 'a']) cnt++;
            }
            answer.append(cur);
        }

        return answer.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Main main = new Main();

        bw.write(main.solution("aukks", "wbqd", 5));

        bw.flush();
        bw.close();
        br.close();
    }
}
