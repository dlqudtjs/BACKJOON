import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static List<List<Integer>> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            list.get(from).add(to);
        }

        System.out.println(bfs(n, k, x));
    }

    private static String bfs(int n, int k, int x) {
        List<Integer> answer = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        queue.add(x);
        dp[x] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (dp[current] == k) {
                answer.add(current);
            }

            for (int i : list.get(current)) {
                if (dp[i] != -1) {
                    continue;
                }

                dp[i] = dp[current] + 1;
                queue.add(i);
            }
        }

        Collections.sort(answer);

        for (int i : answer) {
            sb.append(i).append("\n");
        }

        return sb.toString().isBlank() ? "-1" : sb.toString();
    }
}
