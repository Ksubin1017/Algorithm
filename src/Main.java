import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
    }
}

class Solution {
    public int solution(int[] priorities, int location) {
        Deque<int[]> q = new ArrayDeque<>();

        for(int i = 0; i < priorities.length; i++) {
            q.offer(new int[]{priorities[i], i});
        }

        int order = 0;
        while(!q.isEmpty()) {
            int[] cur = q.poll();

            boolean higher = false;

            for(int[] chk: q) {
                if(cur[0] < chk[0]) {
                    higher = true;
                    break;
                }
            }

            if(higher) {
                q.offer(cur);
            } else {
                order++;

                if(cur[1] == location) {
                    return order;
                }
            }
        }

        return order;
    }
}

