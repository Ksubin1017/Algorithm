import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int answer = 0;

        for(int a = 1; a <= 500; a++) {
            for(int b = 1; b <= a; b++) {
                if(a * a == b * b + n) answer++;
            }
        }

        System.out.println(answer);
    }
}