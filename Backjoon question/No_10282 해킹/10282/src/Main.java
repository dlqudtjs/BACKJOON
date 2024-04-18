import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static List<Computer>[] computers;
    static int[] dp;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            computers = new ArrayList[n + 1];
            dp = new int[n + 1];
            visited = new boolean[n + 1];

            for (int j = 0; j < n + 1; j++) {
                computers[j] = new ArrayList<>();
                dp[j] = Integer.MAX_VALUE;
            }

            for (int j = 0; j < d; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                computers[b].add(new Computer(a, s));
            }

            sb.append(bfs(n, c)).append("\n");
        }

        System.out.println(sb);
    }

    private static String bfs(int n, int start) {
        PriorityQueue<Computer> pq = new PriorityQueue<>();
        pq.add(new Computer(start, 0));
        dp[start] = 0;

        while (!pq.isEmpty()) {
            int from = pq.poll().to;

            if (visited[from]) {
                continue;
            }
            visited[from] = true;

            for (Computer computer : computers[from]) {
                if (dp[computer.to] < dp[from] + computer.time) {
                    continue;
                }

                dp[computer.to] = dp[from] + computer.time;
                pq.add(new Computer(computer.to, dp[computer.to]));
            }
        }

        int max = 0;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (dp[i] != Integer.MAX_VALUE) {
                count++;
                max = Math.max(max, dp[i]);
            }
        }

        return count + " " + max;
    }
}

class Computer implements Comparable<Computer> {
    int to;
    int time;

    public Computer(int to, int time) {
        this.to = to;
        this.time = time;
    }

    @Override
    public int compareTo(Computer computer) {
        return this.time - computer.time;
    }
}
