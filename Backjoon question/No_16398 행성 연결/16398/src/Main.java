import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            parent[i] = i;

            for (int j = 0; j <= i; j++) {
                if (i == j) {
                    continue;
                }

                long cost = Integer.parseInt(st.nextToken());

                pq.add(new Node(i, j, cost));
            }
        }

        long answer = 0;
        int size = pq.size();
        for (int i = 0; i < size; i++) {
            Node node = pq.poll();

            if (union(node.getFrom(), node.getTo())) {
                answer += node.getCost();
            }
        }

        System.out.println(answer);
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
    private int from;
    private int to;
    private long cost;

    public Node(int from, int to, long cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    public long getCost() {
        return cost;
    }

    @Override
    public int compareTo(Node o1) {
        return (int) cost - (int) o1.getCost();
    }
}
