import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        String d = st.nextToken();
        int answer = 0;

        for(int i = 1; i <= n; i++) {
            String target = String.valueOf(i);

            for(String c : target.split("")) {
                if(c.equals(d)) answer++;
            }
        }

        System.out.println(answer);
    }
}