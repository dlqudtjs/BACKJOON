import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = new int[] { 0, 0, -1, 1 };
    static int[] dy = new int[] { -1, 1, -0, 0 };
    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 열
        N = Integer.parseInt(st.nextToken()); // 행

        int[][] box = new int[N][M];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());

                if (box[i][j] == 1) {
                    queue.add(new int[] { i, j });
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int y = now[0] + dy[i];
                int x = now[1] + dx[i];

                // 범위 밖이거나, 익지 않은 토마토가 아니면 가지 않음
                if (y < 0 || y >= N || x < 0 || x >= M || box[y][x] != 0) {
                    continue;
                }

                queue.add(new int[] { y, x });
                box[y][x] = box[now[0]][now[1]] + 1;
            }
        }

        boolean flag = false;
        int day = 1;

        for (int i = 0; i < N; i++) {

            for (int j = 0; j < M; j++) {
                day = Math.max(day, box[i][j]);

                if (box[i][j] == 0) {
                    flag = true;
                }
            }

            if (flag) {
                break;
            }
        }

        if (flag) { // 익지 않은 토마토가 아예 없을 경우도 생각해야 됨
            System.out.println(-1); // 첫 날은 빼야됨
        } else {
            System.out.println(day - 1); // 첫 날은 빼야됨
        }
    }
}
