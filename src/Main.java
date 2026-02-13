import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int[] day = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] dow = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};

        int sum = 0;

        for(int i = 1; i < x; i++) {
            sum += day[i];
        }

        sum += y;
        int idx = sum % 7;

        if(idx != 0) {
            bw.write(dow[idx - 1]);
        } else {
            bw.write(dow[6]);
        }
        bw.flush();
        bw.close();
    }
}
