import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static List<Integer>[] partyOfPerson;
    static List<Integer>[] peopleInParty;
    static boolean[] knowTruth;
    static boolean[] visitedParty;

    static void dfs(int person) {
        for (int party : partyOfPerson[person]) {
            if (visitedParty[party]) continue;

            visitedParty[party] = true;

            for (int nextPerson : peopleInParty[party]) {
                if (!knowTruth[nextPerson]) {
                    knowTruth[nextPerson] = true;
                    dfs(nextPerson);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        knowTruth = new boolean[N + 1];
        partyOfPerson = new ArrayList[N + 1];
        peopleInParty = new ArrayList[M + 1];
        visitedParty = new boolean[M + 1];

        for (int i = 1; i <= N; i++) {
            partyOfPerson[i] = new ArrayList<>();
        }
        for (int i = 1; i <= M; i++) {
            peopleInParty[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        int cnt = Integer.parseInt(st.nextToken());
        for (int i = 0; i < cnt; i++) {
            int person = Integer.parseInt(st.nextToken());
            knowTruth[person] = true;
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            for (int j = 0; j < num; j++) {
                int person = Integer.parseInt(st.nextToken());
                peopleInParty[i].add(person);
                partyOfPerson[person].add(i);
            }
        }

        for (int i = 1; i <= N; i++) {
            if (knowTruth[i]) {
                dfs(i);
            }
        }

        int answer = 0;
        for (int i = 1; i <= M; i++) {
            boolean canLie = true;
            for (int person : peopleInParty[i]) {
                if (knowTruth[person]) {
                    canLie = false;
                    break;
                }
            }
            if (canLie) answer++;
        }

        System.out.println(answer);
    }
}
