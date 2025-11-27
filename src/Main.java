import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] graph;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int heartX = 0;
        int heartY = 0;
        graph = new boolean[n + 1][n + 1];
        visited = new boolean[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            String[] sArr = br.readLine().split("");
            for (int j = 1; j <= sArr.length; j++) {
                if (sArr[j - 1].equals("*")) {
                    graph[i][j] = true;
                }
            }
        }
        outer:
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (graph[i + 1][j] && graph[i - 1][j] && graph[i][j + 1] && graph[i][j - 1]) {
                    heartX = j;
                    heartY = i;
                    break outer;
                }
            }
        }
        bw.write((heartY + " " + heartX) + "\n");

        // 왼쪽 팔
        int idx = -1;
        int cnt = 0;
        while (heartX + idx <= n && graph[heartY][heartX + idx]) {
            idx--;
            cnt++;
        }
        sb.append(cnt + " ");

        // 오른쪽 팔
        idx = 1;
        cnt = 0;
        while (heartX + idx <= n && graph[heartY][heartX + idx]) {
            idx++;
            cnt++;
        }
        sb.append(cnt + " ");

        // 허리
        idx = 1;
        cnt = 0;
        int waistY = 0;
        while (graph[heartY + idx][heartX]) {
            idx++;
            cnt++;
        }
        waistY = heartY + idx - 1;
        sb.append(cnt + " ");

        // 왼쪽 다리
        idx = 1;
        cnt = 0;
        while(waistY + idx <= n && graph[waistY + idx][heartX - 1]) {
            idx++;
            cnt++;
        }
        sb.append(cnt + " ");

        // 오른쪽 다리
        idx = 1;
        cnt = 0;
        while(waistY + idx <= n && graph[waistY + idx][heartX + 1]) {
            idx++;
            cnt++;
        }
        sb.append(cnt + " ");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}