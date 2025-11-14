import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        while(true){
            String s = br.readLine();
            if(s.equals(".")) break;
            Stack<Character> stack = new Stack<>();

            for(int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if(c == '(' || c == '[') {
                    stack.push(c);
                } else if (c == ')') {
                    if(stack.isEmpty()) {
                        stack.push(c);
                        break;
                    }

                    if(stack.peek() == '(') {
                        stack.pop();
                    } else {
                        break;
                    }
                } else if (c == ']') {
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
                bw.write("yes\n");
            } else {
                bw.write("no\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
