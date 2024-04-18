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
        int k = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < k; i++) {
            parent[Integer.parseInt(st.nextToken())] = -1;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            pq.add(new Node(from, to, cost));
        }

        int answer = 0;
        for (int i = 0; i < m; i++) {
            Node node = pq.poll();

            if (union(node.from, node.to)) {
                answer += node.cost;
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
        if (parent[v] == -1) {
            return -1;
        }

        if (parent[v] == v) {
            return v;
        }

        return find(parent[v]);
    }
}

class Node implements Comparable<Node> {
    int from;
    int to;
    int cost;

    public Node(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o1) {
        return this.cost - o1.cost;
    }
}

/*
 * 발전기 parent 값을 -1로 초기화하고,
 * 최소 값부터 연결하게 된다면 자연스레 모든 노드의 최상위 부모 노드가 -1로 모두 설정이 된다.
 * 그럼 그 연결이 최소 스패닝 트리가 된다. (작은 parent 값을 따라가기 때문에)
 */