import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;
    static int[] colors = new int[3];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, N);

        System.out.println(colors[0]);
        System.out.println(colors[1]);
        System.out.println(colors[2]);
    }

    private static void dfs(int startX, int startY, int size) {
        if (check(startX, startY, size)) {
            return;
        }

        int length = size / 3;

        dfs(startX, startY, length); // 1행 1열
        dfs(startX + length, startY, length); // 1행 2열
        dfs(startX + (length * 2), startY, length);// 1행 3열

        dfs(startX, startY + length, length); // 2행 1열
        dfs(startX + length, startY + length, length); // 2행 2열
        dfs(startX + (length * 2), startY + length, length); // 2행 3열

        dfs(startX, startY + (length * 2), length); // 3행 1열
        dfs(startX + length, startY + (length * 2), length); // 3행 2열
        dfs(startX + (length * 2), startY + (length * 2), length); // 3행 3열
    }

    private static boolean check(int startX, int startY, int size) {
        int color = board[startY][startX];

        for (int i = startY; i < startY + size; i++) {
            for (int j = startX; j < startX + size; j++) {
                if (color != board[i][j]) {
                    return false;
                }
            }
        }

        // -1 ,0 ,1 이기 때문에 1을 더해준 후 인덱스로 활용한다.
        color++;

        colors[color]++;

        return true;
    }
}
