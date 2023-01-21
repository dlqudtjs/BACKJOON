import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, maxMove, moveCnt;
    static int[] dx = new int[] { -1, 1, 0, 0 };
    static int[] dy = new int[] { 0, 0, -1, 1 };
    static char[][] map;
    static int[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maxMove = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String line = br.readLine();

            for (int j = 1; j <= M; j++) {
                if (line.charAt(j - 1) == '.') {
                    map[i][j] = 0; // 맵에 이동 횟수를 새기기 위해 길은 숫자로 표기
                } else {
                    map[i][j] = '#';
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int startX = Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());
        int endX = Integer.parseInt(st.nextToken());
        int endY = Integer.parseInt(st.nextToken());

        bfs(startX, startY, endX, endY);

        // 도착하지 못했다면 -1
        if (visited[endX][endY]) {
            moveCnt = map[endX][endY];
        } else {
            moveCnt = -1;
        }

        System.out.println(moveCnt);
    }

    public static void bfs(int startX, int startY, int endX, int endY) {
        Queue<int[]> myQueue = new LinkedList<>();
        myQueue.add(new int[] { startX, startY });
        visited[startX][startY] = true;

        while (!myQueue.isEmpty()) {
            int[] now = myQueue.poll();

            for (int i = 0; i < 4; i++) {
                int x = now[0];
                int y = now[1];

                for (int k = 0; k < maxMove; k++) { // 그 방향으로 최대 maxMove만큼 움직일 수 있기 때문에 x, y를 고정시키며 이동한다.
                    x += dx[i];
                    y += dy[i];

                    if (x <= 0 || x > N || y <= 0 || y > M) { // 맵 범위 밖일 때
                        break;
                    }
                    if (visited[x][y] || map[x][y] == '#' || map[x][y] < map[now[0]][now[1]] + 1) { // 방문 했거나 벽이거나
                        break;
                    }

                    myQueue.add(new int[] { x, y });
                    map[x][y] = map[now[0]][now[1]] + 1; // 전 노드의 움직임에 +1를 하여 움직임의 횟수를 표시
                    visited[x][y] = true;
                }
            }
        }
    }
}
