import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        double n = Double.parseDouble(br.readLine());
        System.out.println((int)Math.sqrt(n));


    }
}

//    public static long gcd(long a, long b) {
//        long r = a % b;
//
//        if (r == 0) {
//            return b;
//        } else {
//            return gcd(b, r);
//        }
//    }

