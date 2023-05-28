import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Node>[] nodes;
    static int dp[];
    static int V, E, startNode;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken()); // 정점의 개수
        E = Integer.parseInt(st.nextToken()); // 간선의
        startNode = Integer.parseInt(br.readLine()); // 시작 노드

        nodes = new ArrayList[V + 1];
        dp = new int[V + 1];

        for (int i = 1; i <= V; i++) {
            nodes[i] = new ArrayList<>();
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            nodes[from].add(new Node(to, weight));
        }

        dp[startNode] = 0;
        dijkstra(startNode);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (dp[i] == Integer.MAX_VALUE) {
                sb.append("INF").append("\n");
                continue;
            }

            sb.append(dp[i]).append("\n");
        }

        System.out.println(sb);
    }

    private static void dijkstra(int startNode) {
        // PriorityQueue로 탐색한 노드들의 가중치가 작은 순으로 정렬을 해준다.
        // 따라서, 가중치가 낮은 순으로 탐색하기 때문에 더욱 효율적으로 탐색이 가능하다.
        PriorityQueue<Node> queue = new PriorityQueue<>();

        // 처음 삽입할 때, queue의 종료 노드를 startNode로 설정한다. (weight = 0으로)
        queue.add(new Node(startNode, 0));

        while (!queue.isEmpty()) {
            // currentNode는 현재 노드이며, 현재 노드에서 갈 수 있는 정점과 가중치가 담겨있다.
            Node currentNode = queue.poll();

            // next 노드에는 다음 정점의 정보가 담겨있다.
            for (Node nextNode : nodes[currentNode.to]) {

                // currentNode.to 즉, 출발한 정점의 번호이며, nextNode.weight = 도착 정점까지의 가중치이다.
                // 출발 정점의 dp값과 도착 정점까지의 가중치가 도착 정점의 dp값보다 작다면 갱신해준다.
                if (dp[currentNode.to] + nextNode.weight < dp[nextNode.to]) {
                    dp[nextNode.to] = dp[currentNode.to] + nextNode.weight;

                    // 최소 거리일 때만 queue에 삽입하여 탐색한다.
                    queue.add(new Node(nextNode.to, dp[nextNode.to]));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        // PriorityQueue의 정렬을 하기 위해 구현해야 하는 compareTo 메서드이다.
        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }
}
