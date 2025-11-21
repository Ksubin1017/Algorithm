import java.io.*;
import java.util.*;

public class Main {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for(int i = 0; i < dx.length; i++) {
            if(h + dy[i] >= 0 && w + dx[i] >= 0 && h + dy[i] < board.length && w + dx[i] < board.length) {
                if (board[h][w].equals(board[h + dy[i]][w + dx[i]])) answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Main main = new Main();


        bw.flush();
        bw.close();
        br.close();
    }
}
