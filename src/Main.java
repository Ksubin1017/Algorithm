import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < n ; i++){
            String s = br.readLine();
            Stack<Character> stack = new Stack<>();

            for(int j = 0 ; j < s.length() ; j++){
                if(s.charAt(j) == '('){
                    stack.push(s.charAt(j));
                } else {
                    if(stack.isEmpty()){
                        stack.push(s.charAt(j));
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }

            if(stack.isEmpty()){
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}




