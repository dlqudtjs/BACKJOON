import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = new int[] { 0, 0, -1, 1 };
    static int[] dy = new int[] { -1, 1, 0, 0 };
    static int[][] map;
    static int[][] isDestroyed;
    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        isDestroyed = new int[N][M];

        for (int i = 0; i < N; i++) {
            int index = 0;

            for (char c : br.readLine().toCharArray()) {
                map[i][index] = c - '0';
                isDestroyed[i][index] = Integer.MAX_VALUE;

                index++;
            }
        }

        bfs(0, 0);
    }

    private static void bfs(int startY, int startX) {
        Queue<Loc> queue = new LinkedList<>();
        queue.add(new Loc(startY, startX, 1, 0));

        while (!queue.isEmpty()) {
            Loc now = queue.poll();

            if (now.y == N - 1 && now.x == M - 1) {
                System.out.println(now.distance);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int y = now.y + dy[i];
                int x = now.x + dx[i];

                if (y < 0 || y >= N || x < 0 || x >= M) {
                    continue;
                }
                /*
                 * idDestoryed배열은 벽을 부수고 온 길인지 아닌 지 체크하는 역할을 한다.
                 * 아래 조건문을 보면 모든 길을 지날 때 now.destoryed를 isDestroyed에 저장한다.
                 * 
                 * 1. 이미 앞서 벽을 부수고 지나간 길을 또 다른 벽을 부순 상태의 노드가 지나갈 때 (continue)
                 * isDestroyed = 1, now.destroyed = 1 이기 때문에 if문이 성립한다.
                 * 
                 * 2. 벽을 부수지 않은 노드가 지나간 곳을 벽을 부수지 않은 노드가 지나갈 때 (continue)
                 * isDestroyed = 0, now.destoryed = 0 이기 때문에 if문이 성립한다.
                 * 
                 * 3. 벽을 부수지 않은 노드가 지나간 곳을 벽을 부순 상태의 노드가 지나갈 때 (continue)
                 * isDestroyed = 0, now.destoryed = 1 이기 때문에 if문이 성립한다.
                 * 
                 * 4. 이미 앞서 벽을 부수고 지나간 길을 벽을 부수지 않은 노드가 지나갈 때 (pass)
                 * isDestroyed = 1, now.destroyed = 0 이기 때문에 if문이 성립하지 못한다.
                 * 
                 * 5. 아무도 지나가지 않은 길을 벽을 부수거나, 부수지 않은 노드가 지나갈 때 (pass)
                 * isDistoryed = Integer.MaxValue(초기값), now.destroyed = 1, 2 이기 때문에
                 * if문이 성립하지 못한다.
                 * 
                 * 따라서, isDestroyed 배열을 boolean으로 설정하지 않은 이유는 초기값을 설정하기 위해서이다.
                 */
                if (isDestroyed[y][x] <= now.destroyed) {
                    continue;
                }

                if (map[y][x] == 0) { // 벽이 아닐 때
                    isDestroyed[y][x] = now.destroyed;
                    queue.add(new Loc(y, x, now.distance + 1, now.destroyed));
                } else { // 벽일 때
                    if (now.destroyed == 0) {
                        isDestroyed[y][x] = now.destroyed + 1;
                        queue.add(new Loc(y, x, now.distance + 1, now.destroyed + 1));
                    }
                }
            }
        }

        System.out.println(-1);
    }

    static class Loc {
        int y;
        int x;
        int distance;
        int destroyed;

        public Loc(int y, int x, int distance, int destroyed) {
            this.y = y;
            this.x = x;
            this.distance = distance;
            this.destroyed = destroyed;
        }
    }
}

// import java.io.BufferedReader;
// import java.io.InputStreamReader;
// import java.util.LinkedList;
// import java.util.Queue;
// import java.util.StringTokenizer;

// public class Main {
// static int[] dx = new int[] { 0, 0, -1, 1 };
// static int[] dy = new int[] { -1, 1, 0, 0 };
// static int[][] map; // 0 = 길, 1 = 벽, 2 = 벽을 뚫고 오지 않은 길의 방문 체크
// static int[][] mapInfo; // 벽 뚫는 유무 상관없이 방문 순서 저장
// static int N, M;

// public static void main(String[] args) throws Exception {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// StringTokenizer st = new StringTokenizer(br.readLine());

// N = Integer.parseInt(st.nextToken());
// M = Integer.parseInt(st.nextToken());
// map = new int[N][M];
// mapInfo = new int[N][M];

// for (int i = 0; i < N; i++) {
// int index = 0;

// for (char c : br.readLine().toCharArray()) {
// map[i][index++] = c - '0';
// }
// }

// bfs(0, 0);
// }

// private static void bfs(int startY, int startX) {
// Queue<int[]> queue = new LinkedList<>();
// queue.add(new int[] { startY, startX, 0 });
// map[startY][startX] = 2; // 방문 체크 (visit처리)
// mapInfo[startY][startX] = 1; // 방문 순서 저장

// while (!queue.isEmpty()) {
// int[] now = queue.poll();

// for (int i = 0; i < 4; i++) {
// int y = now[0] + dy[i];
// int x = now[1] + dx[i];
// int isBreak = now[2];

// // 범위 밖이거나, 방문했거나
// if (y < 0 || y >= N || x < 0 || x >= M || map[y][x] == 2) {
// continue;
// }

// // 벽이면서 현재 뚫고 온 벽이 없을 경우
// if (map[y][x] == 1 && isBreak == 0) {
// queue.add(new int[] { y, x, 1 });
// mapInfo[y][x] = mapInfo[now[0]][now[1]] + 1;
// continue;
// }

// // 벽이면서 뚫고 온 벽이 있을 경우 더이상 진행하지 않음
// if (map[y][x] == 1 && isBreak == 1) {
// continue;
// }

// queue.add(new int[] { y, x, isBreak });
// mapInfo[y][x] = mapInfo[now[0]][now[1]] + 1;
// // 벽을 뚫고 오지 않은 경우에만 방문 체크를 해준다.(visit처리)
// if (isBreak == 0) {
// map[y][x] = 2;
// }

// // 도착했다면
// if (mapInfo[N - 1][M - 1] > 0) {
// System.out.println(mapInfo[N - 1][M - 1]);
// return;
// }
// }
// }

// // 1, 1
// // 0 같은 예외처리를 해주기 위해
// System.out.println(mapInfo[N - 1][M - 1] > 0 ? mapInfo[N - 1][M - 1] : -1);
// }
// }

/*
 * 로직의 전체적인 흐름은 다음과 같다.
 * 벽을 뚫고 이동하는 순서는 기록하지만, 방문 처리 (visit)를 하지 않았다.
 * 그 이유는 벽을 뚫고 갈 때 방문처리를 하게 된다면, 뒤늦게 오는 벽을 뚫지 않고 오는
 * 경우가 방문처리 때문에 더이상 나아가지 못한다.
 * 이는 벽을 뚫고 오는 경우가 벽을 뚫고 오지 않는 경우보다 앞서기 때문에 가능한 설계였다.
 * (그래서 도착 여부를 방문 여부가 아닌 "방문 순서가 0보다 크면" 이라고 설정했다.)
 */