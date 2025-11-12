import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> mapA = new HashMap<>();
        HashMap<Integer, Integer> mapB = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            mapA.put(a, mapA.getOrDefault(a, 0) + 1);
        }

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < m; i++) {
            int b = Integer.parseInt(st.nextToken());
            mapB.put(b, mapB.getOrDefault(b, 0) + 1);
        }

        int cnt = 0;

        for(int i : mapB.keySet()) {
            if(!mapA.containsKey(i)) cnt++;
        }

        for(int i : mapA.keySet()) {
            if(!mapB.containsKey(i)) cnt++;
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
        br.close();
    }
}
