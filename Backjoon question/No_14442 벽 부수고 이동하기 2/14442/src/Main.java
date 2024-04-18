import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m, k;
    static boolean[][] map;
    static boolean[][][] visited;
    static int[] dy = new int[] { -1, 1, 0, 0 };
    static int[] dx = new int[] { 0, 0, -1, 1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new boolean[n][m];
        visited = new boolean[n][m][k + 1];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();

            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j) - '0' != 0;
            }
        }

        System.out.println(bfs(0, 0));
    }

    private static int bfs(int startY, int startX) {
        Queue<int[]> queue = new LinkedList<>();
        // y, x, 벽을 부순 횟수, 이동 수
        queue.add(new int[] { startY, startX, 0, 1 });
        visited[startY][startX][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            if (current[0] == n - 1 && current[1] == m - 1) {
                return current[3];
            }

            for (int i = 0; i < 4; i++) {
                int nowY = dy[i] + current[0];
                int nowX = dx[i] + current[1];

                if (nowY < 0 || nowY >= n || nowX < 0 || nowX >= m) {
                    continue;
                }

                // 벽을 만났을 때 벽을 부순 횟수가 k보다 크거나 같을 때 continue
                // 벽 일 때, 아닐 때 visited 확인을 다르게 해야한다.
                if (map[nowY][nowX]) {
                    if (current[2] >= k || visited[nowY][nowX][current[2] + 1]) {
                        continue;
                    }

                    queue.add(new int[] { nowY, nowX, current[2] + 1, current[3] + 1 });
                    visited[nowY][nowX][current[2] + 1] = true;
                } else {
                    if (visited[nowY][nowX][current[2]]) {
                        continue;
                    }

                    queue.add(new int[] { nowY, nowX, current[2], current[3] + 1 });
                    visited[nowY][nowX][current[2]] = true;
                }
            }
        }

        return -1;
    }
}
