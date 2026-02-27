import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int max = Integer.MIN_VALUE;
        int winner = 0;

        for(int person = 1; person <= n; person++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] card = new int[5];

            for(int i = 0; i < 5; i++) {
                card[i] = Integer.parseInt(st.nextToken());
            }

            int top = 0;

            for(int i = 0; i < 3; i++) {
                for(int j = i + 1; j < 4; j++) {
                    for(int k = j + 1; k < 5; k++) {
                        int sum = card[i] + card[j] + card[k];
                        top = Math.max(top, sum % 10);
                    }
                }
            }

            if(top >= max) {
                winner = person;
                max = top;
            }
        }

        System.out.println(winner);
    }
}