import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        Integer[] arr = new Integer[n];

        if (n > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
        }

        if (p == 0) {
            bw.write("-1");
            bw.flush();
            return;
        }

        if (n == p && n > 0) {
            Arrays.sort(arr, Collections.reverseOrder());
            if (target <= arr[arr.length - 1]) {
                bw.write("-1");
                bw.flush();
                return;
            }
        }

        int rank = 1;
        for (int i = 0; i < n; i++) {
            if (arr[i] > target) rank++;
            else break;
        }

        bw.write(String.valueOf(rank));
        bw.flush();
    }
}
