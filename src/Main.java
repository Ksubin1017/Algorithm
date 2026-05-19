import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
    }
}

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> b = new LinkedList<>();

        for(int i = 0; i < bridge_length; i++) {
            b.offer(0);
        }


        int time = 0;
        int cur = 0;
        int index = 0;

        while(index < truck_weights.length) {
            time++;
            cur -= b.poll();

            if(cur + truck_weights[index] <= weight) {
                b.offer(truck_weights[index]);
                cur += truck_weights[index];
                index++;
            } else {
                b.offer(0);
            }

        }
        return time + bridge_length;
    }
}