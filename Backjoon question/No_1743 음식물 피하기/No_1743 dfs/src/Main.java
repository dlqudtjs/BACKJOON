import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = new int[] { -1, 1, 0, 0 };
    static int[] dy = new int[] { 0, 0, -1, 1 };
    static int N, M, cnt, currSize, maxSize;
    static boolean[][] map, visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cnt = Integer.parseInt(st.nextToken());

        map = new boolean[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];

        for (int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x][y] = true;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (!visited[i][j] && map[i][j]) { // 방문하지 않고 음식이 있다면
                    currSize = 0;
                    dfs(i, j);
                    maxSize = maxSize > currSize ? maxSize : currSize;
                }
            }
        }

        System.out.println(maxSize);
    }

    public static void dfs(int startX, int startY) {
        visited[startX][startY] = true;
        currSize++;
        int[] now = new int[] { startX, startY };

        for (int i = 0; i < 4; i++) {
            int x = now[0] + dx[i];
            int y = now[1] + dy[i];

            if (x < 0 || x > N || y < 0 || y > M) { // 맵 범위를 벗어났을 때
                continue;
            }
            if (visited[x][y] || !map[x][y]) { // 방문 했거나 음식이 없거나
                continue;
            }

            dfs(x, y);
        }
    }
}
