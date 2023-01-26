import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, maxMove, moveCnt;
    static int[] dx = new int[] { -1, 1, 0, 0 }; // 상하좌우
    static int[] dy = new int[] { 0, 0, -1, 1 };
    static char[][] map;
    static int[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maxMove = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            Arrays.fill(visited[i], Integer.MAX_VALUE);

            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        st = new StringTokenizer(br.readLine());
        int startX = Integer.parseInt(st.nextToken()) - 1;
        int startY = Integer.parseInt(st.nextToken()) - 1;
        int endX = Integer.parseInt(st.nextToken()) - 1;
        int endY = Integer.parseInt(st.nextToken()) - 1;

        bfs(startX, startY, endX, endY);

        // 도착하지 못했다면 -1
        moveCnt = visited[endX][endY] != Integer.MAX_VALUE ? visited[endX][endY] : -1;

        System.out.println(moveCnt);
    }

    public static void bfs(int startX, int startY, int endX, int endY) {
        Queue<int[]> myQueue = new LinkedList<>();
        myQueue.add(new int[] { startX, startY });
        visited[startX][startY] = 0;

        while (!myQueue.isEmpty()) {
            int[] now = myQueue.poll();

            for (int i = 0; i < 4; i++) {
                for (int k = 1; k <= maxMove; k++) { // 그 방향으로 최대 maxMove만큼 움직일 수 있기 때문에 x, y를 고정시키며 이동한다.
                    int x = now[0] + dx[i] * k;
                    int y = now[1] + dy[i] * k;

                    if (x < 0 || x >= N || y < 0 || y >= M || map[x][y] == '#') { // 맵 범위 밖일 때, 벽일 때
                        break;
                    }

                    /*
                     * 기존에 작성했던 코드는 [1][2][3][4] 배열에서 [1] -> [2] 방향으로 움직일 때
                     * [2]의 가중치가 2이고, [1]의 가중치가 1이라면 [1]의 가중치가 더 적기 때문에 [2]에 방문하여 4면을 확인했다.
                     * 하지만 굳이 확인할 필요가 없기 때문에 else if 문을 넣어 [2]를 건너뛰어 그 [1] -> [3] 순으로 확인하게 된다.
                     * (만약 [3] 또한 방문할 필요가 없다면 [4]까지 넘어가게 된다.)
                     */
                    if (visited[x][y] == Integer.MAX_VALUE) {
                        visited[x][y] = visited[now[0]][now[1]] + 1;
                        if (x == endX && y == endY) {
                            return;
                        }
                        myQueue.add(new int[] { x, y });

                    } else if (visited[x][y] <= visited[now[0]][now[1]]) {
                        break;
                    }
                }
            }
        }
    }
}
