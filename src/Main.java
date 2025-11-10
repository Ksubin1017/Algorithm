import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String status = st.nextToken();

            if(status.equals("leave")) {
                map.put(name, map.getOrDefault(name, 0) - 1);
            } else {
                map.put(name, map.getOrDefault(name, 0) + 1);
            }
        }

        ArrayList<String> list = new ArrayList<>();
        for(String name : map.keySet()) {
            if(map.get(name) == 1) list.add(name);
        }

        Collections.sort(list, Collections.reverseOrder());

        for(String s : list) bw.write(s+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
