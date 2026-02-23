import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[5];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int i = 1;

        while(true) {
            int cnt = 0;

            if(i % arr[0] == 0) cnt++;
            if(i % arr[1] == 0) cnt++;
            if(i % arr[2] == 0) cnt++;
            if(i % arr[3] == 0) cnt++;
            if(i % arr[4] == 0) cnt++;

            if(cnt >= 3) break;
            else i++;
        }

        System.out.println(i);
    }
}