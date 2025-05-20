import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        System.out.println(facto(n));

    }

    static long facto(int x) {
        if(x <= 0) {
            return 1;
        }

        return x * facto(x - 1);
    }
}