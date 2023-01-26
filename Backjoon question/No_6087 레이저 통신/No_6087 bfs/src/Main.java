import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int W, H;
    static int[] dx = new int[] { -1, 1, 0, 0 };
    static int[] dy = new int[] { 0, 0, -1, 1 };
    static char[][] map;
    static int[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new char[H][W];
        visited = new int[H][W];

        int startX = Integer.MAX_VALUE; // 첫 시작 지점을 찾기위해 max_value로 초기화
        int startY = Integer.MAX_VALUE;
        int endX = 0;
        int endY = 0;

        for (int i = 0; i < H; i++) {
            String line = br.readLine();
            Arrays.fill(visited[i], Integer.MAX_VALUE);

            for (int j = 0; j < W; j++) {
                // 시작 지점 찾기
                if (startX == Integer.MAX_VALUE && line.charAt(j) == 'C') {
                    startX = i;
                    startY = j;
                }

                map[i][j] = line.charAt(j);

                // 종료 지점 찾기
                if (startX != Integer.MAX_VALUE && line.charAt(j) == 'C') {
                    endX = i;
                    endY = j;
                }
            }
        }

        bfs(startX, startY);

        System.out.println(visited[endX][endY] - 1); // 거울의 수는 -1
    }

    public static void bfs(int startX, int startY) {
        Queue<int[]> myQueue = new LinkedList<>();
        myQueue.add(new int[] { startX, startY });
        visited[startX][startY] = 0;

        while (!myQueue.isEmpty()) {
            int now[] = myQueue.poll();

            for (int i = 0; i < 4; i++) {
                int x = now[0];
                int y = now[1];

                while (true) {
                    x += dx[i];
                    y += dy[i];

                    if (x < 0 || x >= H || y < 0 || y >= W) { // 범위를 벗어날 때
                        break;
                    }
                    if (map[x][y] == '*') { // 벽일 때
                        break;
                    }

                    // 현재 위치가 갈 곳보다 크거나 같을 경우, 이미 방문 한 곳일 경우
                    // &&로 묶었기 때문에 하나의 조건이라도 만족하지 않다면 방문하게 된다.
                    if (visited[x][y] <= visited[now[0]][now[1]] && visited[x][y] != Integer.MAX_VALUE) {
                        break;
                    }

                    visited[x][y] = visited[now[0]][now[1]] + 1;
                    myQueue.add(new int[] { x, y });
                }
            }
        }
    }
}
