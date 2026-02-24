import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int answer = 0;

        for(int a = 1; a <= n; a++) {
            for(int b = 1; b <= n; b++) {
                for(int c = 1; c <= n; c++) {
                    if(a - b >= 2 && c % 2 == 0 && a + b + c == n) {
                        answer++;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}