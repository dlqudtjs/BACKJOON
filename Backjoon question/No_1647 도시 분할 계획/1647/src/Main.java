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

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            pq.add(new Node(from, to, weight));
        }

        int weigth = 0;
        int last = 0;
        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (union(node.from, node.to)) {
                weigth += node.weight;
                last = node.weight;
            }
        }

        System.out.println(weigth - last);
    }

    static private boolean union(int from, int to) {
        int fromParent = find(from);
        int toParent = find(to);

        if (fromParent == toParent) {
            return false;
        }

        parent[toParent] = fromParent;
        return true;
    }

    static private int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return find(parent[x]);
    }

    static class Node implements Comparable<Node> {
        int from;
        int to;
        int weight;

        public Node(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o1) {
            return weight - o1.weight;
        }
    }
}

/*
 * 크루스칼로 최소 스패닝 트리를 만든 후 가장 가중치가 높은 간선을 끊으면
 * 두 개의 마을로 분리가 되며, 가장 높은 간선을 끊었기 때문에 최솟값으로 마을을 분리하게 된다.
 */