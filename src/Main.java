import java.io.*;
import java.util.*;

public class Main {
    public static boolean[] getPrimeFlags(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);

        if (n >= 0) isPrime[0] = false;
        if (n >= 1) isPrime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        return isPrime;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        boolean[] isPrime = getPrimeFlags(n);

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if(isPrime[i]) primes.add(i);
        }

        int lt = 0;
        int rt = 0;
        int sum = 0;
        int cnt = 0;

        while(lt < n && rt < n) {
            if(sum >= n) sum -= primes.get(lt++);
            else if(rt == primes.size()) break;
            else sum += primes.get(rt++);

            if(sum == n) cnt++;
        }

        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
    }
}
