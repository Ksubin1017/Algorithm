import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String target = br.readLine();
        int n = Integer.parseInt(br.readLine());
        int answer = 0;

        for(int i = 1; i <= n; i++) {
            String s = br.readLine().repeat(2);

            if(s.contains(target)) answer++;
        }

        System.out.println(answer);
    }
}