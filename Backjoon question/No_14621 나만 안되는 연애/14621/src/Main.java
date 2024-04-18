import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static int[] parent;
    static String[] gender;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        gender = new String[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            gender[i] = st.nextToken();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            pq.add(new Node(from, to, distance));
        }

        int answer = 0;
        for (int i = 0; i < m; i++) {
            Node node = pq.poll();

            // 같은 성비의 학교라면 pass
            if (gender[node.from].equals(gender[node.to])) {
                continue;
            }

            if (union(node.from, node.to)) {
                answer += node.distance;
            }
        }

        boolean flag = false;
        for (int i = 1; i < n; i++) {
            if (find(i) != find(i + 1)) {
                flag = true;
            }
        }

        System.out.println(flag ? "-1" : answer);
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
    int distance;

    public Node(int from, int to, int distance) {
        this.from = from;
        this.to = to;
        this.distance = distance;
    }

    @Override
    public int compareTo(Node o1) {
        return distance - o1.distance;
    }
}
