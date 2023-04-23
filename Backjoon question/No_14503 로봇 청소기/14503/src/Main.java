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
                return;
            }
        }

        // 후진
        int nd = (d + 2) % 4;
        int nr = r + dy[nd];
        int nc = c + dx[nd];

        if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] != 1) {
            dfs(nr, nc, d);
        }
    }
}
