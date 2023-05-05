import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = new int[] { 1, 0, -1, 0 }; // 우 하 좌 상
    static int[] dy = new int[] { 0, 1, 0, -1 };
    static int[][] map;
    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 세로
        M = Integer.parseInt(st.nextToken()); // 가로
        int R = Integer.parseInt(st.nextToken()); // 회전수

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int rotateLineCnt = Math.min(N, M) / 2;

        for (int i = 0; i < R; i++) {
            rotate(rotateLineCnt);
        }

        System.out.println(print());
    }

    public static void rotate(int rotateLineCnt) {
        for (int i = 0; i < rotateLineCnt; i++) {
            // 1,1 2,2 3,3 같은 요소들은 시작 지점의 요소이다.
            int x = i;
            int y = i;

            int startValue = map[x][y]; // 마지막에 시작지점에 도달하면 시작지점에 저장된 값을 넣는다.
            int idx = 0;

            while (idx < 4) {
                int nx = x + dx[idx];
                int ny = y + dy[idx];

                // 범위 밖이라면 다음 방향을 바꾼다.
                // 겹겹이 들어갈 수록 도는 범위가 좁아진다. 0 + i 는 i로 치환가능
                if (ny >= N - i || ny < 0 + i || nx >= M - i || nx < 0 + i) {
                    idx++;
                    continue;
                }

                map[y][x] = map[ny][nx];
                x = nx;
                y = ny;
            }

            map[y + 1][x] = startValue;
        }
    }

    public static String print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(map[i][j]).append(" ");
            }

            sb.append("\n");
        }

        return sb.toString();
    }
}
