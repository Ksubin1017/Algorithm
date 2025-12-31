import java.io.*;
import java.util.*;

public class Main {
    static boolean[] isPrime;

    public static void isPrime(int n) {
        isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(isPrime[i]) {
                for(int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }

    public static boolean isPalindrome(String x) {
        int left = 0, right = x.length() - 1;

        while(left < right) {
            if(x.charAt(left) != x.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int target = Integer.parseInt(br.readLine());
        isPrime(10000000);
        while(true) {
            if(isPrime[target] && isPalindrome(String.valueOf(target))) {
                break;
            }else {
                target++;
            }
        }

        bw.write(String.valueOf(target));
        bw.flush();
        bw.close();
    }
}