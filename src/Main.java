import java.io.*;
import java.util.*;

public class Main {

    public static int dfs(int n) {

        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 1;

        return dfs(n-1) + dfs(n-2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());

        bw.write(dfs(n)+"");

        bw.flush();
        bw.close();
        br.close();
    }
}
