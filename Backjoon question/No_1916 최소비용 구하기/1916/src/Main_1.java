import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1 {
    static ArrayList<Node>[] nodes;
    static int dp[];
    static boolean[] visited;
    static int V, E;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        V = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());

        nodes = new ArrayList[V + 1];
        dp = new int[V + 1];
        visited = new boolean[V + 1];

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

        st = new StringTokenizer(br.readLine());
        int startCity = Integer.parseInt(st.nextToken());
        int endCity = Integer.parseInt(st.nextToken());

        dijkstra(startCity, endCity);

        System.out.println(dp[endCity]);
    }

    private static void dijkstra(int start, int end) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        dp[start] = 0;

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();

            if (visited[currentNode.to]) {
                continue;
            }

            visited[currentNode.to] = true;

            // currentNode.to = 탐색을 시작한 정점의 도착 정점
            // nextNode.to = 탐색을 시작한 정점과 연결된 정점
            // nextNode.weight = 시작 정점과 연결 정점의 가중치
            // dp[currentNode.to] <- 때문에 도착 정점의 dp값이라고 생각할 수 있지만
            // 시작 부분을 보면 알겠지만 new Node(start, 0)로 queue에 넣고 시작하기 한다.
            // ex) 1을 시작할 때, 없는 노드에서 다음 노드(1)를 start로 잡고 시작하여 전전 노드에서 부터
            // 출발했음을 알 수 있다. 그렇기 떄문에 currentNode.to는 1(start)를 가리키게 되는 것이다.
            for (Node nextNode : nodes[currentNode.to]) {
                if (dp[currentNode.to] + nextNode.weight < dp[nextNode.to]) {
                    dp[nextNode.to] = dp[currentNode.to] + nextNode.weight;

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

        @Override
        public int compareTo(Node o1) {
            return weight - o1.weight;
        }
    }
}
