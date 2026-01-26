import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int lt = 0;
        int rt = 0;
        int min = Integer.MAX_VALUE;

        while(lt <= rt && rt < arr.length) {
            int minus = arr[rt] - arr[lt];
            if(minus < m) rt++;
            else if(minus > m) {
                min = Math.min(min, minus);
                lt++;
            } else {
                min = minus;
                break;
            }
        }

        bw.write(min + "\n");
        bw.flush();
        bw.close();
    }
}
