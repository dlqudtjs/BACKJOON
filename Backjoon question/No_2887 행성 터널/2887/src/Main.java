import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static Point[] points;
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        points = new Point[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            points[i] = new Point(i, x, y, z);
        }

        // x 기준 정렬
        Arrays.sort(points, (o1, o2) -> o1.x - o2.x);
        for (int i = 0; i < n - 1; i++) {
            int weight = Math.abs(points[i].x - points[i + 1].x);

            // i와 i + 1간의 간선의 가중치를 구한 후 pq에 삽입
            pq.add(new Node(points[i].index, points[i + 1].index, weight));
        }

        // y 기준 정렬
        Arrays.sort(points, (o1, o2) -> o1.y - o2.y);
        for (int i = 0; i < n - 1; i++) {
            int weight = Math.abs(points[i].y - points[i + 1].y);

            // i와 i + 1간의 간선의 가중치를 구한 후 pq에 삽입
            pq.add(new Node(points[i].index, points[i + 1].index, weight));
        }

        // z 기준 정렬
        Arrays.sort(points, (o1, o2) -> o1.z - o2.z);
        for (int i = 0; i < n - 1; i++) {
            int weight = Math.abs(points[i].z - points[i + 1].z);

            // i와 i + 1간의 간선의 가중치를 구한 후 pq에 삽입
            pq.add(new Node(points[i].index, points[i + 1].index, weight));
        }

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        int answer = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (union(node.from, node.to)) {
                answer += node.weigth;
            }
        }

        System.out.println(answer);
    }

    private static boolean union(int from, int to) {
        int fromParent = find(from);
        int toParent = find(to);

        if (fromParent == toParent) {
            return false;
        }

        parent[toParent] = fromParent;

        return true;
    }

    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    static class Point {
        int index;
        int x;
        int y;
        int z;

        public Point(int index, int x, int y, int z) {
            this.index = index;
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    static class Node implements Comparable<Node> {
        int from;
        int to;
        int weigth;

        public Node(int from, int to, int weigth) {
            this.from = from;
            this.to = to;
            this.weigth = weigth;
        }

        @Override
        public int compareTo(Node o1) {
            return weigth - o1.weigth;
        }
    }
}

/*
 * x, y, z 의 각각 최소 가중치를 구하는 게 핵심 문제이다.
 * ex) x 기준으로 정렬하면 A, B, C, D가 순서대로 0, 3, 5, 11이 나온다고 가정했을 때, 이 행성간의 최소 가중치를 구하면
 * {0, 3}, {3, 5}, {5, 11} 이 된다. A -> B, B -> C, C -> D의 순서대로 최소 가중치 간선이 나온다.
 * (보기 편하게 ABCD 정렬하게 예시함)
 * 이와 똑같이 y를 했더니 C -> D, D -> B, B -> A순으로 최소 가중치 간선이 나온다고 가정하고, 이를 pq에 넣자.
 * y까지 넣었다면 pq에는 x, y, z각각 간선이 최소값을 저장 돼있을 것이다. 조건에는 행성간 x, y, z 중 하나만 연결이 되었다면
 * 연결이 됐다고 하기 때문에 pq에서 뽑아 간선을 다 연결해주면, 중복된 간선은(사이클 간선) union 과정에서 걸러지며, 최솟값은
 * pq에 저장된 순으로 뽑기 때문에 알아서 걸러진다.
 */