import java.io.*;
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] coins = {40, 20, 10, 5, 1};

        int count = 0;

        for(int coin : coins) {
            count += n / coin;
            n %= coin;
        }

        System.out.println(count);
    }
}