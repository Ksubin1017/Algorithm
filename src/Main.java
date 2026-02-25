import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            list.add(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n - 1; i++) {
            list.remove(st.nextToken());
        }

        for(String s : list) System.out.println(list.get(0));
    }
}