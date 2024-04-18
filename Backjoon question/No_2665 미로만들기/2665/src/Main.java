import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    static int n;
    static boolean[][] map;
    static int[] dx = new int[] { 0, 0, -1, 1 };
    static int[] dy = new int[] { -1, 1, 0, 0 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();

            for (int j = 0; j < n; j++) {
                if (str.charAt(j) == '0') {
                    map[i][j] = true;
                }
            }
        }

        int answer = dijkstra(0, 0);

        System.out.println(answer);
    }

    private static int dijkstra(int startX, int startY) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[][] visited = new boolean[n][n];

        pq.add(new Node(startX, startY, 0));
        visited[startX][startY] = true;

        while (!pq.isEmpty()) {
            Node cuurent = pq.poll();

            if (cuurent.x == n - 1 && cuurent.y == n - 1) {
                return cuurent.count;
            }

            for (int i = 0; i < 4; i++) {
                int x = dx[i] + cuurent.x;
                int y = dy[i] + cuurent.y;

                if (x < 0 || y < 0 || x >= n || y >= n) {
                    continue;
                }

                if (visited[x][y]) {
                    continue;
                }

                if (!map[x][y]) {
                    pq.add(new Node(x, y, cuurent.count));
                } else {
                    pq.add(new Node(x, y, cuurent.count + 1));
                }

                visited[x][y] = true;
            }
        }

        return -1;
    }
}

class Node implements Comparable<Node> {
    int x;
    int y;
    int count;

    public Node(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }

    @Override
    public int compareTo(Node o1) {
        return count - o1.count;
    }
}
