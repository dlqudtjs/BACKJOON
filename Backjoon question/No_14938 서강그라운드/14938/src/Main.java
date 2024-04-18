import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] items;
    static List<List<Node>> road = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        items = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            road.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            road.get(a).add(new Node(b, l));
            road.get(b).add(new Node(a, l));
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            answer = Math.max(answer, dijkstra(i));
        }

        System.out.println(answer);
    }

    private static int dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visit = new boolean[n + 1];
        int result = 0;

        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (visit[node.number]) {
                continue;
            }

            visit[node.number] = true;
            result += items[node.number];

            for (Node next : road.get(node.number)) {
                if (visit[next.number]) {
                    continue;
                }

                // 다음 노드까지의 거리 + 현재 온 거리가 이동 반경보다 크다면 continue
                if (m < next.distance + node.distance) {
                    continue;
                }

                pq.add(new Node(next.number, next.distance + node.distance));
            }
        }

        return result;
    }
}

class Node implements Comparable<Node> {
    int number;
    int distance;

    public Node(int number, int distance) {
        this.number = number;
        this.distance = distance;
    }

    @Override
    public int compareTo(Node o1) {
        return distance - o1.distance;
    }
}
