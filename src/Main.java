import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<Integer, String> map2 = new HashMap<>();

        for(int i = 1; i <= n; i++) {
            String s = br.readLine();

            map1.put(s, i);
            map2.put(i, s);
        }

        for(int i = 1; i <= m; i++) {
            String s = br.readLine();
            if(49 <= s.charAt(0) &&  s.charAt(0) <= 57) {
                int key = Integer.parseInt(s);
                sb.append(map2.get(key)).append("\n");
            } else {
                sb.append(map1.get(s)).append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
