import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st= new StringTokenizer(br.readLine());
        int[] arr1 = new int[n];
        for(int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        st= new StringTokenizer(br.readLine());
        int[] arr2 = new int[m];
        for(int i = 0; i < m; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        int i = 0;
        int j = 0;

        List<Integer> answer = new ArrayList<>();

        while(i < n && j < m) {
            if(arr1[i] <= arr2[j]) answer.add(arr1[i++]);
            else answer.add(arr2[j++]);
        }

        while(i < n) answer.add(arr1[i++]);
        while(j < m) answer.add(arr2[j++]);

        for(int x : answer) {
            bw.write(x + " ");
        }
        bw.flush();
        bw.close();
    }
}
