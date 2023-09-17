import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };
    static int[][] map;
    static int n, m;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

            }
        }

        // 벽 세우기 + 바이러스 터트리기
        dfs(0);

        System.out.println(max);
    }

    private static void dfs(int wall) {
        if (wall == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    // 빈 공간이라면 벽을 친다.
                    map[i][j] = 1;
                    // 벽을 친 후 다음 벽을 치기위해 dfs 탐색
                    dfs(wall + 1);
                    // 해당 벽을 친 경우가 끝났다면 원상복구
                    map[i][j] = 0;
                }
            }
        }
    }

    private static void bfs() {
        int[][] copyMap = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();

        // 배열 복사 과정
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                copyMap[i][j] = map[i][j];

                // 복사 과정에서 발견한 바이러스는 queue에 삽입
                if (map[i][j] == 2) {
                    queue.add(new int[] { i, j });
                }
            }
        }

        while (!queue.isEmpty()) {
            int now[] = queue.poll();

            for (int i = 0; i < 4; i++) {
                int y = now[0] + dy[i];
                int x = now[1] + dx[i];

                // 맵 범위 밖이라면
                if (y < 0 || y >= n || x < 0 || x >= m) {
                    continue;
                }
                // 감염시킬 수 있는 곳이 아니라면
                if (copyMap[y][x] != 0) {
                    continue;
                }

                copyMap[y][x] = 2;
                queue.add(new int[] { y, x });
            }
        }

        countingSafeArea(copyMap);
    }

    private static void countingSafeArea(int[][] copyMap) {
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copyMap[i][j] == 0) {
                    count++;
                }
            }
        }

        max = Math.max(max, count);
    }
}
