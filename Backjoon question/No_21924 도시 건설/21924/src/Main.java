import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        long totalCost = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            long cost = Long.parseLong(st.nextToken());
            totalCost += cost;

            pq.add(new Node(from, to, cost));
        }

        long use = 0;
        for (int i = 0; i < m; i++) {
            Node node = pq.poll();

            if (union(node.from, node.to)) {
                use += node.cost;
            }
        }

        boolean flag = false;
        for (int i = 1; i < n; i++) {
            if (find(i) != find(i + 1)) {
                flag = true;
                break;
            }
        }

        System.out.println(flag ? -1 : totalCost - use);
    }

    private static boolean union(int from, int to) {
        int parentFrom = find(from);
        int parentTo = find(to);

        if (parentFrom == parentTo) {
            return false;
        }

        if (parentFrom > parentTo) {
            parent[parentFrom] = parentTo;
        } else {
            parent[parentTo] = parentFrom;
        }

        return true;
    }

    private static int find(int v) {
        if (parent[v] == v) {
            return v;
        }

        return find(parent[v]);
    }
}

class Node implements Comparable<Node> {
    int from;
    int to;
    long cost;

    public Node(int from, int to, long cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o1) {
        return (int) (cost - o1.cost);
    }
}
