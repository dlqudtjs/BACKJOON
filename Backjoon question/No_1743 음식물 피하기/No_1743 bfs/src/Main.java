import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = new int[] { -1, 1, 0, 0 };
    static int[] dy = new int[] { 0, 0, -1, 1 };
    static int N, M, cnt;
    static int maxSize = 0;
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

        // 주의해야 할 점! 좌표가 주어지고 해당 좌표까지 순회해햐 할 때 조건식에 <=을 붙여 끝까지 순회하도록 하자!(30분 삽질)
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (!visited[i][j] && map[i][j]) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(maxSize);
    }

    public static void bfs(int startX, int startY) {
        Queue<int[]> myQueue = new LinkedList<>();
        int currSize = 1;
        myQueue.add(new int[] { startX, startY });
        visited[startX][startY] = true;

        while (!myQueue.isEmpty()) {
            int[] now = myQueue.poll();

            for (int i = 0; i < 4; i++) {
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];

                if (x < 0 || x > N || y < 0 || y > M) { // 맵 범위를 벗어나거나
                    continue;
                }
                if (visited[x][y] || !map[x][y]) { // 방문한 곳이거나 맵에 음식이 없는 곳일 때
                    continue;
                }

                myQueue.add(new int[] { x, y });
                visited[x][y] = true;
                currSize++;
            }
        }

        maxSize = (maxSize > currSize) ? maxSize : currSize;
    }
}
