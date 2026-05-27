import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<Integer> set = new HashSet<>();

        int answer = -1;

        for(int i = 1; i <= m; i++) {

            int card = Integer.parseInt(br.readLine());

            set.add(card);

            if(set.size() == n) {
                answer = i;
                break;
            }
        }

        System.out.println(answer);
    }
}