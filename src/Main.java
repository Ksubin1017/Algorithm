import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int lt = 0;
        int rt = 0;
        int cnt = 0;
        int maxLen = 0;

        while(rt < n) {
            if(cnt < k) {
                if(arr[rt] % 2 != 0) {
                    cnt++;
                }
                rt++;
                maxLen = Math.max(maxLen, rt - lt - cnt);
            } else if(arr[rt] % 2 == 0) {
                rt++;
                maxLen = Math.max(maxLen, rt - lt - cnt);
            } else {
                if(arr[lt] % 2 != 0) {
                    cnt--;
                }
                lt++;
            }
        }

        bw.write(maxLen + "");
        bw.flush();
        bw.close();
    }
}
