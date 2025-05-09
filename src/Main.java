import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        System.out.println(factorial(n) / (factorial(k) * factorial(n - k)));
    }

    static int factorial(int num)
    {
        int result = 1; //0과 1 팩토리얼은 1이기 때문에 1부터 시작

        for(int i = 2; i <= num; i++)
        {
            result = result * i;
        }
        return result;
    }
}
