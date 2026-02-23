import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int answer = 0;

        for(int i = 1; i <= n; i++) {
            String s = String.valueOf(i);
            for(char c : s.toCharArray()) {
                if(c == '3' || c == '6' || c == '9') answer++;
            }
        }

        System.out.println(answer);
    }
}
