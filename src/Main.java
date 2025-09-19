import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        T.DFS(n);
    }

    public void DFS(int n) {
        if(n == 0) return;
        else {
            DFS(n / 2);
            System.out.print(n % 2+ "");
        }
    }
}
