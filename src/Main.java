import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr = new int[M + 1];
    static boolean[] visited = new boolean[N + 1];
    public static void main(String[] args) throws IOException {


        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 숫자 범위
        M = sc.nextInt(); // 몇 개 뽑을지

        arr = new int[M];        // 선택된 숫자 저장
        visited = new boolean[N+1]; // 숫자 사용 여부

        back(0); // 깊이 0부터 시작
    }

    static void back(int position) {
        if(position == M) {
            for(int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 1; i <= N; i++) {
            if(!visited[i]) {
                arr[position] = i;
                visited[i] = true;
                back(position + 1);
                visited[i] = false;
            }
        }
    }

}