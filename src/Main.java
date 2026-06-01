import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int t = 0; t < n; t++) {
            int[] a = new int[5];
            int[] b = new int[5];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());

            for(int i = 0; i < cnt; i++) {
                a[Integer.parseInt(st.nextToken())]++;
            }

            st = new StringTokenizer(br.readLine());
            cnt = Integer.parseInt(st.nextToken());

            for(int i = 0; i < cnt; i++) {
                b[Integer.parseInt(st.nextToken())]++;
            }

            String result = "D";

            for(int i = 4; i >= 0; i--) {
                if(a[i] > b[i]) {
                    result = "A";
                    break;
                }

                if(a[i] < b[i]) {
                    result = "B";
                    break;
                }
            }

            System.out.println(result);
        }
    }
}