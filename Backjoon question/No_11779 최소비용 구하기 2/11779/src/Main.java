import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class App {
    static ArrayList<ArrayList<Node>> nodes;
    static int[] dp;
    static int[] preCity;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int v = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());

        nodes = new ArrayList<>();
        dp = new int[v + 1];
        preCity = new int[v + 1];
        visited = new boolean[v + 1];

        for (int i = 0; i <= v; i++) {
            nodes.add(new ArrayList<>());
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            nodes.get(from).add(new Node(to, weight));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start);

        StringBuilder sb = new StringBuilder();
        sb.append(dp[end]).append("\n"); // 최소 비용 출력

        // 경로 추적
        Stack<Integer> stack = new Stack<>();
        stack.add(end);

        while (preCity[end] != 0) {
            stack.add(preCity[end]);
            end = stack.peek();
        }

        sb.append(stack.size()).append("\n"); // 경로 도시의 수 출력

        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" "); // 경로 출력
        }

        System.out.println(sb);
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        dp[start] = 0;

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            if (visited[currentNode.end]) {
                continue;
            }

            visited[currentNode.end] = true;

            for (Node nextNode : nodes.get(currentNode.end)) {
                if (dp[currentNode.end] + nextNode.weight < dp[nextNode.end]) {
                    dp[nextNode.end] = dp[currentNode.end] + nextNode.weight;

                    queue.add(new Node(nextNode.end, dp[nextNode.end]));
                    // 해당 경로에 대해 출발 정점을 저장한다. (if문에 들어왔기 때문에 최소 비용은 보장됨)
                    preCity[nextNode.end] = currentNode.end;
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
