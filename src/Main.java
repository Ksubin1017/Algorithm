import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int answer = 0;

            for (int i = 1; i <= 45; i++) {
                for (int j = 1; j <= 45; j++) {
                    for (int k = 1; k <= 45; k++) {
                        int t1 = (i * (i + 1) / 2);
                        int t2 = (j * (j + 1) / 2);
                        int t3 = (k * (k + 1) / 2);

                        if (t1 + t2 + t3 == n) {
                            answer = 1;
                        }
                    }
                }
            }

            System.out.println(answer);
        }
    }
}