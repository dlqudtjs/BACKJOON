import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = new int[] { -1, 1, 0, 0 }; // 상 하 좌 우
    static int[] dy = new int[] { 0, 0, -1, 1 };
    static int[][] map;
    static boolean[][] visited;
    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - 48;
            }
        }

        bfs(0, 0);

        System.out.println(map[N - 1][M - 1]); // 도착지가 미로 크기이다.
    }

    public static void bfs(int startX, int startY) {
        Queue<int[]> myQueue = new LinkedList<>();
        myQueue.add(new int[] { startX, startY });
        visited[startX][startY] = true;

        while (!myQueue.isEmpty()) {
            int now[] = myQueue.poll();

            for (int i = 0; i < 4; i++) {
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];

                if (x < 0 || x >= N || y < 0 || y >= M) { // 맵 범위 밖으로 간다면
                    continue;
                }
                if (map[x][y] == 0 || visited[x][y]) { // 벽이거나, 방문 한 노드라면
                    continue;
                }

                myQueue.add(new int[] { x, y });
                visited[x][y] = true;
                map[x][y] = map[now[0]][now[1]] + 1; // 찾은 노드에 현재 위치의 depth 값을 ++해서 저장
            }
        }
    }
}