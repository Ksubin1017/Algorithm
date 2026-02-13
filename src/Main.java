import java.io.*;
import java.util.*;

public class Main {
    static int d(int n) {
        int sum = n;

        while(n > 0) {
            sum += n % 10;
            n /= 10;
        }

        return sum;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] check = new boolean[10001];

        for(int i = 1; i <= 10000; i++) {
            int dn = d(i);
            if(dn <= 10000) check[dn] = true;
        }

        for(int i = 1; i <= 10000; i++) {
            if(!check[i]) {
                bw.write(i + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
