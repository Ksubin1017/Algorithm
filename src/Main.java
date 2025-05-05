import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String str = br.readLine();
            Stack<Character> stack = new Stack<>();
            if(str.equals(".")) break;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                if(c == '(' || c == '[') {
                    stack.push(c);
                }

                if(c == ')') {
                    if(stack.isEmpty()) {
                        stack.push(c);
                        break;
                    }

                    if(stack.peek() == '(') {
                        stack.pop();
                    } else {
                        break;
                    }
                } else if(c == ']') {
                    if(stack.isEmpty()) {
                        stack.push(c);
                        break;
                    }

                    if(stack.peek() == '[') {
                        stack.pop();
                    } else {
                        break;
                    }
                }
            }

            if(stack.isEmpty()) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }


    }
}