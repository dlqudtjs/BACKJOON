import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if (n == 0 && m == 0) {
                break;
            }

            int total = 0;
            int use = 0;
            parent = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());

                pq.add(new Node(x, y, z));
                total += z;
            }

            for (int i = 0; i < m; i++) {
                Node node = pq.poll();

                if (union(node.from, node.to)) {
                    use += node.distance;
                }
            }

            sb.append(total - use).append("\n");
        }

        System.out.println(sb);
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
        return this.distance - o1.distance;
    }
}
