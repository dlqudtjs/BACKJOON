import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = new int[] { 0, 0, -1, 1 };
    static int[] dy = new int[] { -1, 1, 0, 0 };
    static int[][] map;
    static int[][] meltCnt;
    static boolean[][] visited;
    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        int year = 0; // 지난 년도

        // 배열에 입력 삽입
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            // 덩어리 확인 및 맞닿은 얼음 확인
            meltCnt = new int[N][M];
            visited = new boolean[N][M];
            boolean flag = false;
            for (int i = 1; i < N - 1; i++) {
                for (int j = 1; j < M - 1; j++) {
                    if (!visited[i][j] && map[i][j] != 0) {
                        // 두 덩어리가 분류되면 종료된다.
                        if (flag) {
                            System.out.println(year);
                            return;
                        }

                        checkMap(i, j);
                        flag = true;
                    }
                }
            }

            // 얼음을 녹일 때 다 녹았다면 0을 출력한다.
            if (!flag) {
                System.out.println(0);
                return;
            }
            // 얼음 녹이기
            flag = false;
            for (int i = 1; i < N - 1; i++) {
                for (int j = 1; j < M - 1; j++) {
                    if (meltCnt[i][j] == 0) {
                        continue;
                    }

                    map[i][j] = meltCnt[i][j] >= map[i][j] ? 0 : map[i][j] - meltCnt[i][j];
                    flag = true;
                }
            }

            // 얼음을 다 녹인 후 1년을 더한다.
            year++;
        }
    }

    public static void checkMap(int startY, int startX) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { startX, startY });
        visited[startY][startX] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];

                // i, j 맨 테두리, 즉 벽은 탐색하지 않기 때문에 범위 처리는 안 해줘도 된다.
                if (visited[y][x]) {
                    continue;
                }

                // 만약 맞닿은 좌표M 물이라y < 0 || y >= N || 면 meltCnt++를 해준다.
                if (map[y][x] == 0) {
                    meltCnt[now[1]][now[0]]++;
                } else {
                    visited[y][x] = true;
                    queue.add(new int[] { x, y });
                }
            }
        }
    }
}

/*
 * 1. 배열을 탐색하면서 얼음이 있으면 bfs로 탐색하며 두 덩어리로 분류 돼있는지 확인하며,
 * 배열을 탐색하면서 물과 맞닿는 얼음의 좌표를 meltCnt 배열에 ++한다.
 * 3. 물과 맞닿은 얼음을 맞닿은 수 만큼 빼준다. (이때 녹은 meltCnt 크기 >= map 얼음 이라면 0으로 설정한다, 음수는 없기
 * 때문)
 */