import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Node>[][] nodes;
    static boolean visited[][];
    static int dp[][];
    static int V, E;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        nodes = new ArrayList[V + 1][2];
        dp = new int[V + 1][2];
        visited = new boolean[V + 1][2];

        for (int i = 1; i <= V; i++) {
            nodes[i][0] = new ArrayList<>();
            nodes[i][1] = new ArrayList<>();
            dp[i][0] = Integer.MAX_VALUE;
            dp[i][1] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            // 0번 열에는 주어진 좌표 값을 그대로 받는다.
            // 1번 열에는 주어진 좌표 값의 반대 값을 저장하여 돌아갈 때 최소값을 구한다.
            nodes[from][0].add(new Node(to, weight));
            nodes[to][1].add(new Node(from, weight));
        }

        dijkstra(X);

        int maxValue = 0;
        for (int i = 1; i <= V; i++) {
            maxValue = Math.max(maxValue, dp[i][0] + dp[i][1]);
        }

        System.out.println(maxValue);
    }

    private static void dijkstra(int x) {
        // 두번 돌며 i = 0일 땐, x로 가는 최단경로, 1일땐 x에서 가는 최단경로를 찾는다.
        for (int i = 0; i < 2; i++) {
            PriorityQueue<Node> queue = new PriorityQueue<>();
            queue.add(new Node(x, 0));
            dp[x][i] = 0;

            while (!queue.isEmpty()) {
                Node currentNode = queue.poll();

                if (visited[currentNode.end][i]) {
                    continue;
                }

                visited[currentNode.end][i] = true;

                for (Node nextNode : nodes[currentNode.end][i]) {
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
