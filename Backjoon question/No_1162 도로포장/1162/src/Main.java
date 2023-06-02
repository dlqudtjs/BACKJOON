import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<ArrayList<Node>> nodes;
    static long[][] dp;
    static int n, m, k;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 도시의 수
        m = Integer.parseInt(st.nextToken()); // 도로의 수
        k = Integer.parseInt(st.nextToken()); // 포장 도로의 수

        nodes = new ArrayList<>();
        dp = new long[n + 1][k + 1];

        for (int i = 0; i <= n; i++) {
            nodes.add(new ArrayList<>());

            Arrays.fill(dp[i], Long.MAX_VALUE);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            nodes.get(from).add(new Node(to, weight, 0));
            nodes.get(to).add(new Node(from, weight, 0));
        }

        dijkstra(1);

        long answer = Long.MAX_VALUE;
        for (long value : dp[n]) {
            answer = Math.min(answer, value);
        }

        System.out.println(answer);
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0, 0));
        dp[start][0] = 0;

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();

            /*
             * 탐색하려는 정점에 저장된 dp 값이 현재 정점의 가중치보다 크다면 탐색하지 않는다.
             * (큰 값을 가진 정점이 굳이 더 적은 정점을 탐색하는 이유가 없기 때문)
             */
            if (dp[currentNode.end][currentNode.coverCnt] < currentNode.weight) {
                continue;
            }

            for (Node nextNode : nodes.get(currentNode.end)) {
                long nextWeight = currentNode.weight + nextNode.weight;

                // 도로를 포장하지 않고 가는 경우
                // 현재 노드 거리 + 노드까지의 거리 < 다음 노드의 저장된 거리라면 갱신한다. (포장 수는 current.coverCnt로 고정한다)
                if (nextWeight < dp[nextNode.end][currentNode.coverCnt]) {
                    dp[nextNode.end][currentNode.coverCnt] = nextWeight;

                    queue.add(new Node(nextNode.end, nextWeight, currentNode.coverCnt));
                }

                // 도로를 포장하는 경우
                if (currentNode.coverCnt < k && currentNode.weight < dp[nextNode.end][currentNode.coverCnt + 1]) {
                    dp[nextNode.end][currentNode.coverCnt + 1] = currentNode.weight; // 도로를 한 번 포장해서 next.weight를 더하지 않음

                    queue.add(new Node(nextNode.end, currentNode.weight, currentNode.coverCnt + 1));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int end;
        long weight;
        int coverCnt;

        public Node(int end, long weight, int coverCnt) {
            this.end = end;
            this.weight = weight;
            this.coverCnt = coverCnt;
        }

        @Override
        public int compareTo(Node o1) {
            return (int) (weight - o1.weight);
        }
    }
}
