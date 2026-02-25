import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger k = new BigInteger(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        for(int i = 2; i < l; i++) {
            BigInteger n = BigInteger.valueOf(i);

            if(k.mod(n).equals(BigInteger.ZERO)) {
                System.out.println("BAD " + i);
                return;
            }
        }

        System.out.println("GOOD");
    }
}