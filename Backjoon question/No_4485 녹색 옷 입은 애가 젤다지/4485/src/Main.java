import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] map;
    static int[] dx = new int[] { 0, 0, -1, 1 };
    static int[] dy = new int[] { -1, 1, 0, 0 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int testCase = 1;

        while (true) {
            n = Integer.parseInt(br.readLine());

            if (n == 0) {
                break;
            }

            map = new int[n][n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int cost = bfs();

            sb.append("Problem ").append(testCase++).append(": ").append(cost).append("\n");
        }

        System.out.println(sb);
    }

    private static int bfs() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        dp[0][0] = map[0][0];
        pq.add(new Node(0, 0, dp[0][0]));

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (current.x == n - 1 && current.y == n - 1) {
                return current.cost;
            }

            for (int i = 0; i < 4; i++) {
                int x = dx[i] + current.x;
                int y = dy[i] + current.y;
                // int cost = dp[current.x][current.y] + map[x][y];

                if (x < 0 || y < 0 || x >= n || y >= n) {
                    continue;
                }

                // current와 다음 도착지의 합이 더 크다면 굳이 갱신하지 않음
                if (current.cost + map[y][x] >= dp[y][x]) {
                    continue;
                }

                dp[y][x] = current.cost + map[y][x];
                pq.add(new Node(x, y, dp[y][x]));

            }
        }

        return -1;
    }
}

class Node implements Comparable<Node> {
    int x;
    int y;
    int cost;

    public Node(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o1) {
        return this.cost - o1.cost;
    }
}
