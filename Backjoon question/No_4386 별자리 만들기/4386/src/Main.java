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
        double answer = 0;
        Point[] points = new Point[n];
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());

            parent[i] = i;
            points[i] = new Point(i, x, y);
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                double distance = calculateDistance(points[i], points[j]);
                pq.add(new Node(i, j, distance));
            }
        }

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (union(node.from, node.to)) {
                answer += node.distance;
            }
        }

        System.out.println(Math.round(answer * 100) / 100.0);
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

    private static double calculateDistance(Point o1, Point o2) {
        return Math.sqrt(Math.pow(o1.x - o2.x, 2) + Math.pow(o1.y - o2.y, 2));
    }
}

class Point {
    int number;
    double x;
    double y;

    public Point(int number, double x, double y) {
        this.number = number;
        this.x = x;
        this.y = y;
    }
}

class Node implements Comparable<Node> {
    int from;
    int to;
    double distance;

    public Node(int from, int to, double distance) {
        this.from = from;
        this.to = to;
        this.distance = distance;
    }

    @Override
    public int compareTo(Node o1) {
        return Double.compare(distance, o1.distance);
    }
}
