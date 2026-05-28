import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][n];

        int x = 0;
        int y = 0;

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                int a = Integer.parseInt(st.nextToken());
                if(a == 0) {
                    x = j;
                    y = i;
                }
                arr[i][j] = a;
            }
        }

        int sum = 0;

        for(int i = 0; i < n; i++) {
            sum += arr[y][i];
        }

        for(int i = 0; i < n; i++) {
            sum += arr[i][x];
        }

        System.out.println(sum);
    }
}