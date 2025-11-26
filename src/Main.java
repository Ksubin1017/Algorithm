import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        String game = st.nextToken();

        Set<String> players = new HashSet<>();

        for(int i = 0; i < n; i++) {
            players.add(br.readLine());
        }

        int answer = 0;

        if(game.equals("Y")) answer = players.size();
        if(game.equals("F")) answer = players.size() / 2;
        if(game.equals("O")) answer = players.size() / 3;

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
