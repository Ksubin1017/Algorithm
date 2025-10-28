import java.io.*;
import java.util.*;

public class Main {

    public int[] solution(int[] arr) {
        int[] result = new int[2];

        for(int x = -999; x < 1000; x++) {
            for(int y = -999; y < 1000; y++) {
               if(arr[0] * x + arr[1] * y == arr[2] && arr[3] * x + arr[4] * y == arr[5]) {
                   result[0] = x;
                   result[1] = y;
               }
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Main T = new Main();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[6];

        for(int i = 0; i < 6; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < 2; i++) {
            bw.write(T.solution(arr)[i] + " ");
        }

        bw.close();
        br.close();
    }
}
