import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] dx = new int[] { 0, 0, -1, 1 };
    static int[] dy = new int[] { -1, 1, 0, 0 };
    static char[][] map;
    static boolean[][] visited;
    static boolean flag;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j]) {
                    continue;
                }

                dfs(0, 0, j, i, map[i][j]);
            }
        }

        // 도착했다면
        if (flag) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    public static void dfs(int preX, int preY, int x, int y, char color) {
        if (flag) {
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 범위 밖이거나, 바로 전 좌표거나, 좌표가 설정한 색과 다르거나
            if (nx >= M || nx < 0 || ny >= N || ny < 0 || (preX == nx && preY == ny) || (map[ny][nx] != color)) {
                continue;
            }

            // 갔던 곳을 갔다면 사이클이 형성되었다는 것이다.
            if (visited[ny][nx]) {
                flag = true;
                return;
            }

            visited[ny][nx] = true;
            dfs(x, y, nx, ny, color);
        }
    }
}