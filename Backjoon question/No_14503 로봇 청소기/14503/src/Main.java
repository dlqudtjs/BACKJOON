import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = new int[] { 0, 1, 0, -1 }; // 북 동 남 서
    static int[] dy = new int[] { -1, 0, 1, 0 };
    static int[][] map;
    static int N, M;
    static int cnt = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken()); // 로봇 위치 r
        int c = Integer.parseInt(st.nextToken()); // 로봇 위치 c
        int d = Integer.parseInt(st.nextToken()); // 로봇이 바라보고 있는 방향 d

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(r, c, d);

        System.out.println(cnt);
    }

    public static void dfs(int r, int c, int d) {
        if (map[r][c] == 0) { // 청소가 되있지 않다면 청소한다.
            map[r][c] = 2;
            cnt++;
        }

        for (int i = 0; i < 4; i++) {
            d = (d - 1) == -1 ? 3 : d - 1; // 반시계 방향으로 회전 (바라보는 왼쪽)
            int nr = r + dy[d];
            int nc = c + dx[d];

            if (map[nr][nc] == 0) {
                dfs(nr, nc, d);

                // 기존의 dfs 기존 dfs가 끝나면 또 다른 길을 탐색하지만
                // 해당 문제는 길이 막히면 return하여 끝을낸다.
                return;
            }
        }

        // 후진
        int nd = (d + 2) % 4;
        int nr = r + dy[nd];
        int nc = c + dx[nd];

        // 후진한 곳이 벽이 아니라면 바라보는 방향 그대로 후진 (엉덩이 쪽으로 들어감)
        if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] != 1) {
            dfs(nr, nc, d);
        }
    }
}

/*
 * (문제의 정답.)
 * 0 0 0 0 0 0 0 0 0 0
 * 0 56 57 46 45 44 43 42 41 0
 * 0 55 48 47 0 0 0 0 40 0
 * 0 50 49 0 0 36 37 38 39 0
 * 0 51 0 0 35 34 31 30 0 0
 * 0 52 53 12 11 33 32 29 28 0
 * 0 54 14 13 10 9 0 0 27 0
 * 0 16 15 2 1 8 0 0 26 0
 * 0 17 18 3 4 7 0 0 25 0
 * 0 21 19 20 5 6 22 23 24 0
 * 0 0 0 0 0 0 0 0 0 0
 */