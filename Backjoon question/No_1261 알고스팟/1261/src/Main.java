import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[][] maze;
    static int m, n;
    static int[] dx = new int[] { 0, 0, -1, 1 };
    static int[] dy = new int[] { -1, 1, 0, 0 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        maze = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                maze[i][j] = str.charAt(j) - '0';
            }
        }

        int answer = dijkstra();

        System.out.println(answer);
    }

    private static int dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[][] visit = new boolean[n][m];

        visit[0][0] = true;
        pq.add(new Node(0, 0, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (node.y == n - 1 && node.x == m - 1) {
                return node.count;
            }

            for (int i = 0; i < 4; i++) {
                int x = dx[i] + node.x;
                int y = dy[i] + node.y;

                if (x < 0 || y < 0 || x >= m || y >= n) {
                    continue;
                }

                if (visit[y][x]) {
                    continue;
                }

                if (maze[y][x] == 0) {
                    pq.add(new Node(x, y, node.count));
                } else {
                    pq.add(new Node(x, y, node.count + 1));
                }

                visit[y][x] = true;
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
