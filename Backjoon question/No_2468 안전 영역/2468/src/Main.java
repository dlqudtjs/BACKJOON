import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = new int[] { 0, 0, -1, 1 };
    static int[] dy = new int[] { -1, 1, 0, 0 };
    static int[][] map;
    static int N;
    static int maxCnt = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        int min = 101;
        int max = 1;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                min = min > map[i][j] ? map[i][j] : min;
                max = max < map[i][j] ? map[i][j] : max;
            }
        }

        for (int i = min - 1; i <= max; i++) {
            check(i);
        }

        System.out.println(maxCnt);
    }

    public static void check(int height) {
        Queue<int[]> queue = new LinkedList<int[]>();
        boolean[][] visited = new boolean[N][N];
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                // 방문했거나, 물에 잠겼거나
                if (visited[i][j] || map[i][j] <= height) {
                    continue;
                }
                cnt++;

                queue.add(new int[] { i, j });
                visited[i][j] = true;

                while (!queue.isEmpty()) {
                    int[] now = queue.poll();

                    for (int k = 0; k < 4; k++) {
                        int x = now[0] + dx[k];
                        int y = now[1] + dy[k];

                        // 범위 밖으로 나갈 시
                        if (x < 0 || x >= N || y < 0 || y >= N) {
                            continue;
                        }

                        // 방문했거나 물에 잠겼거나
                        if (visited[x][y] || map[x][y] <= height) {
                            continue;
                        }

                        queue.add(new int[] { x, y });
                        visited[x][y] = true;
                    }
                }

            }
        }

        maxCnt = maxCnt < cnt ? cnt : maxCnt;
    }
}
