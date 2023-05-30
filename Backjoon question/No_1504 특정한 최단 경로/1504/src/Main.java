import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static final int INF = 2000000;
    static ArrayList<ArrayList<Node>> nodes;
    static int[][] dp;
    static boolean[][] visited;
    static int V, E, v1, v2;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        nodes = new ArrayList<>();
        V = Integer.parseInt(st.nextToken()); // 정점의 개수이자, 도착 정점
        E = Integer.parseInt(st.nextToken()); // 간선의 수

        dp = new int[V + 1][2];
        visited = new boolean[V + 1][2];

        for (int i = 0; i <= V; i++) {
            nodes.add(new ArrayList<>());

            dp[i][0] = INF;
            dp[i][1] = INF;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            // 무방향 그래프이기 때문에 양쪽을 저장한다.
            nodes.get(from).add(new Node(to, weight));
            nodes.get(to).add(new Node(from, weight));
        }

        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        dijkstra();

        // 1 -> v1 -> v2 -> V
        // 1 -> v2 -> v1 -> V
        // 두 가지 경우 모두 구하여 더 짧은 거리를 출력한다.
        int direct1 = dp[1][0] + dp[v2][0] + dp[V][1];
        int direct2 = dp[1][1] + dp[v1][1] + dp[V][0];

        int result = direct1 < direct2 ? direct1 : direct2;

        System.out.println(result < INF ? result : -1);
    }

    private static void dijkstra() {
        for (int i = 0; i < 2; i++) {
            int start = i == 0 ? v1 : v2;

            PriorityQueue<Node> queue = new PriorityQueue<>();
            queue.add(new Node(start, 0));
            dp[start][i] = 0;

            while (!queue.isEmpty()) {
                Node currentNode = queue.poll();

                if (visited[currentNode.end][i]) {
                    continue;
                }

                visited[currentNode.end][i] = true;

                for (Node nextNode : nodes.get(currentNode.end)) {
                    if (dp[currentNode.end][i] + nextNode.weight < dp[nextNode.end][i]) {
                        dp[nextNode.end][i] = dp[currentNode.end][i] + nextNode.weight;

                        queue.add(new Node(nextNode.end, dp[nextNode.end][i]));
                    }
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int end;
        int weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o1) {
            return weight - o1.weight;
        }
    }
}
