import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Node>[] nodes;
    static int[] dp;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken()); // 루트 번호
        int q = Integer.parseInt(st.nextToken()); // 쿼리 수

        nodes = new ArrayList[n + 1];
        dp = new int[n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            nodes[u].add(new Node(u, v));
            nodes[v].add(new Node(v, u));
        }

        dfs(r);

        for (int i = 0; i < q; i++) {
            int query = Integer.parseInt(br.readLine());
            sb.append(dp[query]).append("\n");
        }

        System.out.println(sb);
    }

    private static int dfs(int n) {
        visited[n] = true;
        int sum = 0;

        for (Node node : nodes[n]) {
            if (!visited[node.v]) {
                sum += dfs(node.v);
            }
        }

        // 단말노드일 경우 탐색을 못했으므로 자연스레 sum + 1인 1이 된다. 따라서, 단말노드를 따로
        // 예외처리할 필요가 없다.
        dp[n] = sum + 1;
        return dp[n];
    }

    static class Node {
        int u;
        int v;

        public Node(int u, int v) {
            this.u = u;
            this.v = v;
        }
    }
}
