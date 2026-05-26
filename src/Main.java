import java.io.*;

class Main {
    static final long MOD = 1000000007L;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());

        if(k == 1) {
            System.out.println(0);
            return;
        }

        long a = 0;
        long b = 1;

        for(int i = 3; i <= k; i++) {
            long temp = (a + b) % MOD;
            a = b;
            b = temp;
        }

        System.out.println(b);
    }
}