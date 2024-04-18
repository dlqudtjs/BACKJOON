import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static List<List<Integer>> persons = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] dp = new int[n + 1];
        int min = Integer.MAX_VALUE;

        for (int i = 0; i <= n; i++) {
            persons.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            persons.get(from).add(to);
            persons.get(to).add(from);
        }

        for (int i = 1; i <= n; i++) {
            dp[i] = bfs(i, n);
            min = Math.min(min, dp[i]);
        }

        for (int i = 1; i <= n; i++) {
            if (dp[i] == min) {
                System.out.println(i);
                return;
            }
        }
    }

    private static int bfs(int from, int n) {
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[n + 1];
        visited[from] = 0;
        queue.add(from);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int i : persons.get(current)) {
                if (visited[i] != 0 || i == from) {
                    continue;
                }

                visited[i] = visited[current] + 1;
                queue.add(i);
            }
        }

        int total = 0;
        for (int i = 1; i <= n; i++) {
            total += visited[i];
        }

        return total;
    }
}
