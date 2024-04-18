import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[] dy = new int[] { -1, 1, 0, 0 };
    static int[] dx = new int[] { 0, 0, -1, 1 };
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();

            for (int j = 0; j < n; j++) {
                map[i][j] = str.charAt(j) == 'R' ? 0 : str.charAt(j) == 'G' ? 1 : 2;
            }
        }

        int count1 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    bfs(i, j, n);
                    count1++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // red, green을 0으로, blue를 2로 통일
                map[i][j] = map[i][j] == 1 ? 0 : map[i][j];
            }
        }

        int count2 = 0;
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    bfs(i, j, n);
                    count2++;
                }
            }
        }

        System.out.println((count1) + " " + (count2));
    }

    private static void bfs(int startY, int startX, int n) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { startY, startX });
        visited[startY][startX] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nowY = dy[i] + current[0];
                int nowX = dx[i] + current[1];

                if (nowY < 0 || nowY >= n || nowX < 0 || nowX >= n || visited[nowY][nowX]) {
                    continue;
                }

                if (map[startY][startX] != map[nowY][nowX]) {
                    continue;
                }

                visited[nowY][nowX] = true;
                queue.add(new int[] { nowY, nowX });
            }
        }
    }
}
