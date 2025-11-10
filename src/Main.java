import java.io.*;
import java.util.*;

public class Main {
    public int[] solution(HashMap<Integer,Integer> map, int[] target) {

        int[] answer = new int[target.length];

        for(int i = 0; i < target.length; i++) {
            if(map.containsKey(target[i])) {
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Main main = new Main();

        int n = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        int m = Integer.parseInt(br.readLine());
        int[] target = new int[m];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            target[i] = Integer.parseInt(st.nextToken());
        }

        for(int i : main.solution(map, target)) {
            bw.write(i + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
