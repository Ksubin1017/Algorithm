import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            List<Integer> score = new ArrayList<>();
            for (int i = 1; i <= n; i++) score.add(Integer.parseInt(st.nextToken()));

            HashMap<Integer, Integer> teamCnt = new HashMap<>();
            for (int x : score) teamCnt.put(x, teamCnt.getOrDefault(x, 0) + 1);

            List<Integer> filterScore = new ArrayList<>();
            for (int x : score) if (teamCnt.get(x) == 6) filterScore.add(x);

            HashMap<Integer, Integer> top4Sum = new HashMap<>();
            HashMap<Integer, Integer> cnt4 = new HashMap<>();
            HashMap<Integer, Integer> fifth = new HashMap<>();

            int rank = 1;
            for (int team : filterScore) {
                int c = cnt4.getOrDefault(team, 0);

                if (c < 4) {
                    top4Sum.put(team, top4Sum.getOrDefault(team, 0) + rank);
                    cnt4.put(team, c + 1);
                } else if (c == 4) {
                    fifth.put(team, rank);
                    cnt4.put(team, 5);
                }
                rank++;
            }

            int winner = 0;
            int minScore = Integer.MAX_VALUE;

            for (int team : top4Sum.keySet()) {
                int sum = top4Sum.get(team);

                if (sum < minScore) {
                    minScore = sum;
                    winner = team;
                } else if (sum == minScore) {
                    if (fifth.get(team) < fifth.get(winner)) winner = team;
                }
            }

            bw.write(winner + "\n");
        }

        bw.flush();
        bw.close();
    }
}
