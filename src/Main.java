import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        boolean[][] graph = new boolean[110][110];

        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            for(int j = 0; j < n; j++) {
                if(str.charAt(j) == '.') {
                    graph[i][j] = true;
                } else {
                    graph[i][j] = false;
                }
            }
        }

        int rcnt = 0;
        int lcnt = 0;
        int row = 0;
        int col = 0;

        for(int i = 0; i < n; i++) {
            rcnt = 0;
            lcnt = 0;
            for(int j = 0; j < n; j++) {
                if(graph[i][j]) rcnt++;
                else {
                    if(rcnt >= 2) row++;
                    rcnt = 0;
                }

                if(graph[j][i]) lcnt++;
                else {
                    if(lcnt >= 2) col++;
                    lcnt = 0;
                }
            }
            if(rcnt >= 2) row++;
            if(lcnt >= 2) col++;
        }


        bw.write(row + " " + col);
        bw.flush();
        bw.close();
    }
}