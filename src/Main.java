import java.io.*;
import java.util.*;

public class Main {
    static int cnt;
    public static int dfs(String s, int lt, int rt) {
        cnt++;
        if(lt >= rt) return 1;
        else if(s.charAt(lt) != s.charAt(rt)) return 0;
        else return dfs(s, lt + 1, rt - 1);
    }

    public static int isPalindrome(String s) {
        return dfs(s, 0, s.length() - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String s = br.readLine();
            cnt = 0;
            int result = isPalindrome(s);
            sb.append(result).append(" ").append(cnt).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
