import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = new int[] { 0, -1, 0, 1 }; // 북 서 남 동
    static int[] dy = new int[] { -1, 0, 1, 0 };
    static int[][] map;
    static int N, M;

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

        int cnt = bfs(r, c, d);

        System.out.println(cnt);
    }

    public static int bfs(int r, int c, int d) {
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.add(new int[] { r, c });
        map[r][c] = 1;
        int cnt = 1;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];

            for (int i = 0; i < 4; i++) {
                int x = nowX + dx[i];
                int y = nowY + dy[i];

                if (x < 0 || x >= M || y < 0 || y >= N || map[x][y] == 1) {
                    continue;
                }

                queue.add(new int[] { x, y });
                map[x][y] = 1;
                cnt++;
            }
        }

        return cnt;
    }
}