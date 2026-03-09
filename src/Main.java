import java.io.*;
import java.util.*;

public class Main {
    static boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }

        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] arr = new String[n];

            boolean flag = false;

            for(int i = 0; i < n; i++) {
                arr[i] = br.readLine();
            }

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(i == j) continue;
                    flag = isPalindrome(arr[i] + arr[j]);
                    if(flag) {
                        System.out.println(arr[i] + arr[j]);
                        break;
                    }
                }

                if(flag) break;
            }

            if(!flag) {
                System.out.println(0);
            }
        }
    }
}
