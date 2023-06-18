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

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        parent = new int[v + 1];

        for (int i = 1; i <= v; i++) {
            parent[i] = i; // 부모를 자기 노드로 초기화
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            pq.add(new Node(from, to, weight));
        }

        int answer = 0;
        for (int i = 0; i < e; i++) {
            Node node = pq.poll();

            // union을 했으면
            if (union(node.from, node.to, node.weight)) {
                answer += node.weight;
            }
        }

        System.out.println(answer);
    }

    private static boolean union(int from, int to, int weight) {
        int fromParent = find(from);
        int toParent = find(to);

        if (fromParent == toParent) {
            return false;
        }

        if (fromParent > toParent) {
            parent[fromParent] = toParent;
        } else {
            parent[toParent] = fromParent;
        }

        return true;
    }

    private static int find(int v) {
        if (parent[v] == v) {
            return v;
        }

        // 자기 자신에서 parant[v] == v를 찾지 못했다면 자기 부모의 부모를 찾는다.
        return find(parent[v]);
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
