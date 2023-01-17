import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, whiteScore, blueScore;
    static int[] dx = new int[] { -1, 1, 0, 0 };
    static int[] dy = new int[] { 0, 0, -1, 1 };
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        // map 생성
        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j); // 문자에 해당하는 아스키 값을 넣는다. (비교할 때 아스키 코드로 비교하기 위해)
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(whiteScore + " " + blueScore);
    }

    public static void bfs(int startX, int startY) {
        Queue<int[]> myQueue = new LinkedList<>();
        int cnt = 0;
        int team = map[startX][startY];
        myQueue.add(new int[] { startX, startY });
        visited[startX][startY] = true;

        while (!myQueue.isEmpty()) {
            int now[] = myQueue.poll();
            cnt++;

            for (int i = 0; i < 4; i++) {
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];

                if (x < 0 || x >= M || y < 0 || y >= N) { // 범위 밖이거나
                    continue;
                }
                if (visited[x][y] || map[x][y] != team) { // 방문 했거나, 같은 팀이 아니거나
                    continue;
                }

                myQueue.add(new int[] { x, y });
                visited[x][y] = true;
            }
        }

        // 팀 점수
        if (team == 'W') {
            whiteScore += cnt * cnt;
        } else {
            blueScore += cnt * cnt;
        }
    }
}
