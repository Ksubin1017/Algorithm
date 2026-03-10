import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int[] cnt = new int[10];

        for(char c : s.toCharArray()) {
            cnt[c - '0']++;
        }

        int max = (cnt[6] + cnt[9] + 1) / 2;

        for(int i = 0; i < 10; i++) {
            if(i == 6 || i == 9) continue;
            max= Math.max(max, cnt[i]);
        }

        System.out.println(max);
    }
}
