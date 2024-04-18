import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static List<List<Node>> nodes = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            nodes.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            nodes.get(a).add(new Node(b, c));
            nodes.get(b).add(new Node(a, c));
        }

        int answer = dijkstra(1);

        System.out.println(answer);
    }

    private static int dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[n + 1];

        pq.add(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            visited[current.to] = true;

            if (current.to == n) {
                return current.cost;
            }

            for (Node next : nodes.get(current.to)) {
                if (visited[next.to]) {
                    continue;
                }

                pq.add(new Node(next.to, current.cost + next.cost));
            }
        }

        return -1;
    }
}

class Node implements Comparable<Node> {
    int to;
    int cost;

    public Node(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o1) {
        return cost - o1.cost;
    }
}
