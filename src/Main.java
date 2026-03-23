import java.io.*;
import java.util.*;

public class Main {
    static char[][] board;
    static boolean[][] visited;
    static int N, M, curN, curM, CNT = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{curN, curM});

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int posN = cur[0];
            int posM = cur[1];

            if(board[posN][posM] == 'P') CNT++;

            for(int i = 0; i < dx.length; i++) {
                int ny = posN + dy[i];
                int nx = posM + dx[i];

                if(ny < 0 || ny >= N || nx < 0 || nx >= M) continue;

                if(!visited[ny][nx] && board[ny][nx] != 'X') {
                    visited[ny][nx] = true;
                    q.offer(new int[]{ny, nx});
                }
            }
        }

        return CNT;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];

        for(int i = 0; i < N; i++) {
            char[] arr = br.readLine().toCharArray();
            for(int j = 0; j < M; j++) {
                if(arr[j] == 'I') {
                    curN = i;
                    curM = j;
                }
                board[i][j] = arr[j];
            }
        }

        System.out.println(bfs() != 0 ? bfs() : "TT");
    }
}