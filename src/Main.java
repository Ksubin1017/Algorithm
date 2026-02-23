import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int answer = 0;

            for(int a = 1; a < n - 1; a++) {
                for(int b = a + 1; b < n; b++) {
                    if(((a * a) + (b * b) + m) % (a * b) == 0) {
                        answer++;
                    }
                }
            }

            System.out.println(answer);

        }


    }
}