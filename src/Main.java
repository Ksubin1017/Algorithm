import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {

            String line = br.readLine();
            if(line == null) break;

            StringTokenizer st = new StringTokenizer(line);

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int cnt = 0;

            for (int i = a; i <= b; i++) {
                char[] arr = String.valueOf(i).toCharArray();
                boolean flag = true;

                for(int x = 0; x < arr.length; x++) {
                    for(int y = x + 1; y < arr.length; y++) {
                        if(arr[x] == arr[y]) {
                            flag = false;
                            break;
                        }
                    }
                }

                if(flag) cnt++;
            }

            System.out.println(cnt);
        }
    }
}
