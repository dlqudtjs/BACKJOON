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
        entryCount = new int[n + 1];
        list = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            entryCount[b]++;
        }

        int[] result = topologySort();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(result[i]).append(" ");
        }

        System.out.println(sb);
    }

    private static int[] topologySort() {
        Queue<Integer> queue = new LinkedList<>();
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            if (entryCount[i] == 0) {
                queue.add(i);
                dp[i] = 1;
            }
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (Integer i : list.get(current)) {
                entryCount[i]--;

                if (entryCount[i] == 0) {
                    queue.add(i);
                    dp[i] = Math.max(dp[i], dp[current] + 1);
                }
            }
        }

        return dp;
    }
}
