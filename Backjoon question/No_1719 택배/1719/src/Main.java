import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static List<Node>[] nodes;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        nodes = new List[n + 1];

        for (int i = 0; i <= n; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            nodes[from].add(new Node(to, distance, 0));
            nodes[to].add(new Node(from, distance, 0));
        }

        for (int i = 1; i <= n; i++) {
            sb.append(bfs(i, n)).append("\n");
        }

        System.out.println(sb);
    }

    private static String bfs(int start, int n) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        int[] dp = new int[n + 1];
        int[] result = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        pq.add(new Node(start, 0, 0));
        dp[start] = 0;

        while (!pq.isEmpty()) {
            Node from = pq.poll();

            if (visited[from.to]) {
                continue;
            }

            visited[from.to] = true;
            result[from.to] = from.first;

            for (Node node : nodes[from.to]) {
                if (dp[node.to] < dp[from.to] + node.distance) {
                    continue;
                }

                dp[node.to] = dp[from.to] + node.distance;

                if (from.first == 0) {
                    pq.add(new Node(node.to, dp[node.to], node.to));
                } else {
                    pq.add(new Node(node.to, dp[node.to], from.first));
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (i == start) {
                sb.append("- ");
                continue;
            }

            sb.append(result[i] == start ? i : result[i]).append(" ");
        }

        return sb.toString();
    }
}

class Node implements Comparable<Node> {
    int to;
    int distance;
    int first;

    public Node(int to, int distance, int first) {
        this.to = to;
        this.distance = distance;
        this.first = first;
    }

    @Override
    public int compareTo(Node o1) {
        return distance - o1.distance;
    }
}
