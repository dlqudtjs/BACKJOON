import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = new int[] { 0, 0, -1, 1 };
    static int[] dy = new int[] { -1, 1, 0, 0 };
    static int[][] map;
    static boolean[][] visited;
    static int N, M, max;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int startY = Integer.parseInt(st.nextToken());
        int startX = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        // 재료가 없을 땐 return 한다.
        if (p == 0) {
            System.out.println(map[startY][startX]);
            return;
        }

        visited[startY][startX] = true; // 시작지점에는 파이프를 설치하면 안 됨
        for (int i = 0; i < 4; i++) {
            int x = startX + dx[i];
            int y = startY + dy[i];

            // 범위 내에만
            if (y >= 0 && y < N & x >= 0 && x < M) {
                dfs(x, y, p - 1, i, 0);
            }
        }

        // 시작 위치의 값도 더해줘야한다.
        System.out.println(max + map[startY][startX]);
    }

    private static void dfs(int nowX, int nowY, int p, int direct, int sum) {
        sum += map[nowY][nowX];
        visited[nowY][nowX] = true;

        for (int i = 0; i < 4; i++) {
            int x = nowX + dx[i];
            int y = nowY + dy[i];

            // 범위 밖이거나, 탐색한 곳이거나
            if (y < 0 || y >= N || x < 0 || x >= M || visited[y][x]) {
                continue;
            }

            // 일직선 파이프의 경우
            if (i == direct && p >= 1) {
                dfs(x, y, p - 1, i, sum);
            }
            if (p >= 2) {
                dfs(x, y, p - 2, i, sum);
            }
        }

        visited[nowY][nowX] = false;
        max = Math.max(max, sum);
    }
}