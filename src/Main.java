import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashMap<Integer, Integer> map1 = new HashMap<>();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            map1.put(a, map1.getOrDefault(a, 0) + 1);
        }

        int m = Integer.parseInt(br.readLine());
        int[] target = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            target[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> list = new ArrayList<>();

        for(int i : target) {
            list.add(map1.getOrDefault(i, 0));
        }

        for (int i : list) {
            bw.write(i + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
