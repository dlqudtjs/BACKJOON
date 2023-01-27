import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K, cnt;
    static int[] dx = new int[] { -1, 1, 0, 0 };
    static int[] dy = new int[] { 0, 0, -1, 1 };
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            cnt = 0;
            map = new int[N][M];
            visited = new boolean[N][M];

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken()); // 좌표를 반대로 받음 (이게 편함)
                int x = Integer.parseInt(st.nextToken());

                map[x][y] = 1;
            }

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    if (!visited[r][c] && map[r][c] == 1) {
                        cnt++;
                        dfs(r, c);
                    }
                }
            }

            sb.append(cnt).append('\n');
        }

        System.out.println(sb);
    }

    public static void dfs(int startX, int startY) {
        visited[startX][startY] = true;

        for (int i = 0; i < 4; i++) {
            int x = startX + dx[i];
            int y = startY + dy[i];

            if (x >= 0 && x < N && y >= 0 && y < M && !visited[x][y] && map[x][y] == 1) {
                dfs(x, y);
            }
        }
    }
}

// x, y 좌표를 사용하기 때문에 주의해야한다.