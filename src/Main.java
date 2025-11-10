import java.io.*;
import java.util.*;

public class Main {
    public int solution(HashMap<String,Integer> map, String[] arr) {
        int answer = 0;
        for(String s : arr) {
            if(map.containsKey(s)) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Main main = new Main();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            String string = br.readLine();
            map.put(string, map.getOrDefault(string, 0) + 1);
        }

        String[] arr = new String[m];

        for(int i = 0; i < m; i++) {
            arr[i] = br.readLine();
        }

        bw.write(main.solution(map, arr) + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
