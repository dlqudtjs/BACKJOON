import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] entryCount;
    static List<List<Integer>> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        entryCount = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int count = Integer.parseInt(st.nextToken());
            int prev = Integer.parseInt(st.nextToken());

            for (int j = 0; j < count - 1; j++) {
                int num = Integer.parseInt(st.nextToken());

                list.get(prev).add(num);
                entryCount[num]++;

                prev = num;
            }
        }

        String result = topologySort();

        for (int i = 1; i <= n; i++) {
            if (entryCount[i] != 0) {
                result = "0";
            }
        }

        System.out.println(result);
    }

    private static String topologySort() {
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (entryCount[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();
            sb.append(current).append("\n");

            for (Integer i : list.get(current)) {
                entryCount[i]--;

                if (entryCount[i] == 0) {
                    queue.add(i);
                }
            }
        }

        return sb.toString();
    }
}
