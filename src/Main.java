import java.io.*;
import java.util.*;

public class Main {

    public int solution(int n) {
        int cnt = 0;

        while(n > 0) {
            if(n % 5 == 0) {
                cnt += n / 5;
                return cnt;
            }

            if(n < 3) {
                return -1;
            }

            n -= 3;
            cnt++;
        }
        return cnt;
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
