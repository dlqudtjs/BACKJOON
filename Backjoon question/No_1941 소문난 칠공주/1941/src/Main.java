import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[] dx = new int[] { 0, 0, -1, 1 };
    static int[] dy = new int[] { -1, 1, 0, 0 };
    static int[] combX = new int[25];
    static int[] combY = new int[25];
    static char[][] board = new char[5][5];
    static int answer = 0;
    static int[] combinationArray = new int[7];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            board[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < 25; i++) {
            combY[i] = i / 5;
            combX[i] = i % 5;
        }

        combination(0, 0);

        System.out.println(answer);
    }

    private static void combination(int num, int depth) {
        if (depth == 7) {
            bfs(combinationArray);
            return;
        }

        if (num == 25) {
            return;
        }

        combinationArray[depth] = num;
        combination(num + 1, depth + 1);
        combination(num + 1, depth);
    }

    private static void bfs(int[] combinationArray) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[7];
        int sCnt = 0;
        int cnt = 1;

        queue.add(combinationArray[0]);

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (board[combY[now]][combX[now]] == 'S') {
                sCnt++;
            }

            for (int i = 0; i < 4; i++) {
                int y = combY[now] + dy[i];
                int x = combX[now] + dx[i];

                if (y < 0 || y >= 5 || x < 0 || x >= 5) {
                    continue;
                }

                // getCoordinate 메서드는 y, x를 값으로 변경 (4, 3 -> 23으로 변경)
                int coordinate = getCoordinate(y, x);

                for (int j = 1; j < 7; j++) {
                    if (visited[j]) {
                        continue;
                    }

                    // 상하좌우로 이동한 값이 combinationArray에 들어있다면 visit후, queue에 삽입
                    if (coordinate == combinationArray[j]) {
                        queue.add(combinationArray[j]);
                        visited[j] = true;
                        cnt++;
                    }
                }
            }
        }

        if (cnt == 7 && sCnt >= 4) {
            answer++;
        }
    }

    private static int getCoordinate(int y, int x) {
        return (y * 5) + x;
    }
}

/*
 * 연결 돼있는 좌표를 dfs, bfs로 풀기에는 난이도가 너무 높고 4방향을 조사하기 때문에 시간초과가 발생할 수 있다.
 * 따라서, 5 * 5즉, 25개의 중 7개를 조합으로 뽑아 25C7 뽑은 조합을 bfs 하여, 연결 돼있는 지 확인하는 동시에 S의 개수를
 * 세서 '칠공주' 조건이 성립하는 지 확인해야 한다.
 * 
 * 1. board 배열에 입력을 모두 저장한다.
 * 2. combY, combX 배열에 board배열 수인 0 ~ 24(배열을 숫자로 바꿨을 때) 의 좌표값을 저장한다.
 * 3. combination(조합 메서드)를 통해 7개의 조합을 뽑았다면 bfs를 통해 7개의 좌표가 연결 돼있는지, 다솜이 4명이 포함
 * 돼있는 지 확인한 후 answer를 ++한다.
 */