import java.io.*;
import java.util.*;

class Main {
    static class Node {
        int value;
        int index;

        Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");

        List<Node> list = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            list.add(new Node(Integer.parseInt(arr[i]), i + 1));
        }

        list.sort((a, b) -> b.value - a.value);

        for(int i = 0; i < 3; i++) {
            System.out.print(list.get(i).index + " ");
        }
    }
}