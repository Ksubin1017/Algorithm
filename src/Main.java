import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
    }
}

class Solution {
    boolean solution(String s) {
        boolean answer = false;
        Deque<Character> stack = new ArrayDeque<>();
        char[] arr = s.toCharArray();

        for(char c : arr) {
            if(c == '(') {
                stack.push(c);
            } else {
                if(!stack.isEmpty()) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        if(stack.isEmpty()) {
            answer = true;
        }


        return answer;
    }
}

