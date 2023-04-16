import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dz = new int[] { 1, -1, 0, 0, 0, 0 }; // 윗층, 아랫층, 상 하 좌 우
    static int[] dy = new int[] { 0, 0, -1, 1, 0, 0 }; // 윗층, 아랫층, 상 하 좌 우
    static int[] dx = new int[] { 0, 0, 0, 0, -1, 1 }; // 윗층, 아랫층, 상 하 좌 우

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken()); // 가로
        int N = Integer.parseInt(st.nextToken()); // 세로
        int H = Integer.parseInt(st.nextToken()); // 높이

        int[][][] map = new int[H][N][M];

        Queue<int[]> queue = new LinkedList<int[]>();

        int max = -1;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());

                for (int k = 0; k < M; k++) {
                    map[i][j][k] = Integer.parseInt(st.nextToken());

                    if (map[i][j][k] == 1) {
                        queue.add(new int[] { i, j, k });
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] tomato = queue.poll();
            int nowZ = tomato[0];
            int nowY = tomato[1];
            int nowX = tomato[2];

            // 가장 오래 걸린 시간 체크 (= 다 익는데 걸린 시간)
            max = max > map[nowZ][nowY][nowX] ? max : map[nowZ][nowY][nowX];

            for (int i = 0; i < 6; i++) {
                // 현재 위치에 윗층, 아랫층, 상, 하, 좌, 우 좌표 이동
                int z = nowZ + dz[i];
                int y = nowY + dy[i];
                int x = nowX + dx[i];

                // 높이 제한, 세로 제한, 가로 제한
                if (z >= H || z < 0 || y >= N || y < 0 || x >= M || x < 0) {
                    continue;
                }

                // 토마토가 없거나, 이미 익었을 때
                if (map[z][y][x] != 0) {
                    continue;
                }

                // 위 조건들에 걸리지 않은 토마토를 queue에 삽입
                queue.add(new int[] { z, y, x });

                // 토마토가 익는데 걸린 시간 = 나를 탐색한 토마토의 걸린 시간 + 1
                map[z][y][x] = map[nowZ][nowY][nowX] + 1;
            }
        }

        // 익지 않은 토마토 검사
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {

                    if (map[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        // 처음 하루를 빼야 돼서 -1
        int answer = max <= 0 ? -1 : max - 1;

        System.out.println(answer);
    }
}
