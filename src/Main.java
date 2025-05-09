import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int x = Integer.parseInt(br.readLine());

        for (int i = 0; i < x; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());


            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int n = Math.max(a, b);
            int k = Math.min(a, b);

            BigInteger result = factorial(n)
                    .divide(factorial(k).multiply(factorial(n - k)));

            System.out.println(result);
        }
    }

    static BigInteger factorial(int num) {
        BigInteger result = BigInteger.ONE;

        for (int i = 2; i <= num; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }

        return result;
    }
}
