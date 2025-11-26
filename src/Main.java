import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int rank = 1;

        int[][] arr = new int[n][4];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 4; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] target = new int[4];

        for(int i = 0; i < n; i++) {
            if(arr[i][0] == m) {
                target = arr[i];
            }
        }

        for(int i = 0; i < n; i++) {
            if(target[1] < arr[i][1]) {
                rank++;
            } else if(target[1] == arr[i][1]) {
                if(target[2] < arr[i][2]) {
                    rank++;
                } else if(target[2] == arr[i][2]) {
                    if(target[3] < arr[i][3]) {
                        rank++;
                    }
                }
            }
        }


        bw.write(rank + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
