import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[][] map = new boolean[101][101];

        for(int t = 1; t <= 4; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int i = x1; i < x2; i++) {
                for(int j = y1; j < y2; j++) {
                    map[i][j] = true;
                }
            }
        }

        int area = 0;

        for(int i = 0; i < 101; i++) {
            for(int j = 0; j < 101; j++) {
                if(map[i][j]) area++;
            }
        }

        System.out.println(area);
    }
}
