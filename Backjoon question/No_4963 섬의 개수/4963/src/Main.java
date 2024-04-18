import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    // 뒤에 붙은 4개는 왼쪽 위, 오른쪽 위, 왼쪽 아래, 오른쪽 아래 순서이다.
    static int[] dx = new int[] { 0, 0, -1, 1, -1, 1, -1, 1 };
    static int[] dy = new int[] { -1, 1, 0, 0, -1, -1, 1, 1 };
    static boolean[][] map;
    static boolean[][] visited;
    static int h, w;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) {
                break;
            }

            map = new boolean[h][w];
            visited = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken()) == 1 ? true : false;
                }
            }

            int count = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] && !visited[i][j]) {
                        bfs(i, j);
                        count++;
                    }
                }
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }

    private static void bfs(int startY, int startX) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { startY, startX });
        visited[startY][startX] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            // 상하좌우
            for (int i = 0; i < 8; i++) {
                int nowY = current[0] + dy[i];
                int nowX = current[1] + dx[i];

                if (nowY < 0 || nowX < 0 || nowY >= h || nowX >= w) {
                    continue;
                }

                if (!map[nowY][nowX]) {
                    continue;
                }

                if (visited[nowY][nowX]) {
                    continue;
                }

                queue.add(new int[] { nowY, nowX });
                visited[nowY][nowX] = true;
            }
        }
    }
}
