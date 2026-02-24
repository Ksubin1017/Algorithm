import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int max = 0;
            for(int i = 1; i <= n; i++) {
                int time = (i * i) + i;
                if(time <= n) {
                    max = Math.max(max, i);
                }
            }
            System.out.println(max);
        }
    }
}