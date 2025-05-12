import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String s = br.readLine();

            if(s.equals("ENTER")) {
                map.clear();
            } else {
                if(!map.containsKey(s)) {
                    map.put(s, 1);
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}