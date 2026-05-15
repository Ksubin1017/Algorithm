import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[] coins = {9, 4, 1};
        System.out.println(solution.solution(coins, 12));
    }
}

class Solution {
    public int solution(int[] coins, int amount) {
        Queue<int[]> q = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        q.add(new int[]{amount, 0});
        visited.add(amount);

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int curAmount = cur[0];
            int cnt = cur[1];

            if(curAmount == 0) return cnt;

            for(int coin : coins) {
                int nextAmount = curAmount - coin;
                if(nextAmount < 0) continue;
                if(!visited.contains(nextAmount)) {
                    visited.add(nextAmount);
                    q.add(new int[]{nextAmount, cnt + 1});
                }
            }
        }

        return -1;
    }
}

