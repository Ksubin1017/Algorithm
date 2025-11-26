import java.io.*;
import java.util.*;

public class Main {
    public static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        while(true) {
            String s = br.readLine();
            if(s.equals("end")) break;

            boolean hasVowel = false;
            boolean rule2 = true;
            boolean rule3 = true;

            int vowelCnt = 0;
            int consonantCnt = 0;

            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                boolean isVowel = isVowel(c);

                if(isVowel) {
                    hasVowel = true;
                    vowelCnt++;
                    consonantCnt = 0;
                } else {
                    consonantCnt++;
                    vowelCnt = 0;
                }

                if(vowelCnt == 3 || consonantCnt == 3) rule2 = false;

                if(i > 0) {
                    char prev = s.charAt(i - 1);
                    if(prev == c) {
                        if(!(c == 'e' || c == 'o')) rule3 = false;
                    }
                }
            }

            if(hasVowel && rule2 && rule3) sb.append("<").append(s).append("> is acceptable.\n");
            else sb.append("<").append(s).append("> is not acceptable.\n");
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
