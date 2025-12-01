import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] light = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            light[i] = Integer.parseInt(st.nextToken());
        }

        int sCnt = Integer.parseInt(br.readLine());

        int[][] sArr = new int[sCnt][2];

        for(int i = 0; i < sCnt; i++) {
            st = new StringTokenizer(br.readLine());
            sArr[i][0] = Integer.parseInt(st.nextToken());
            sArr[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < sCnt; i++) {
            if(sArr[i][0] == 1) {
                int num = sArr[i][1];
                for(int j = num; j <= n; j += num) {
                    light[j] = 1 - light[j];
                }
            } else {
                int num = sArr[i][1];
                int lt = num - 1;
                int rt = num + 1;

                while (lt >= 1 && rt <= n && light[lt] == light[rt]) {
                    lt--;
                    rt++;
                }

                for(int j = lt + 1; j <= rt - 1; j++) {
                    light[j] = 1 - light[j];
                }
            }
        }

        for(int i = 1; i <= n; i++) {
            bw.write(light[i] + " ");
            if(i % 20 == 0) bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}
