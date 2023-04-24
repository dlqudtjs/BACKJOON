import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = new int[] { 0, 0, -1, 1 };
    static int[] dy = new int[] { -1, 1, 0, 0 };
    static int map[][];
    static int n, m, maxCnt;

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

        int drawCnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    drawCnt++;
                    bfs(i, j);
                }
            }
        }

        System.out.println(drawCnt);
        System.out.print(maxCnt);
    }

    public static void bfs(int startY, int startX) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { startX, startY });
        int cnt = 1;

        map[startY][startX] = 2;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];

                if (x < 0 || x >= m || y < 0 || y >= n || map[y][x] != 1) {
                    continue;
                }

                map[y][x] = 2;
                queue.add(new int[] { x, y });
                cnt++;
            }
        }

        maxCnt = maxCnt < cnt ? cnt : maxCnt;
    }
}
