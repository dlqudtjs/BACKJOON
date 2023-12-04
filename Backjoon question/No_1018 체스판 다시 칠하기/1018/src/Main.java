import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[][] board = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();

            for (int j = 0; j < m; j++) {
                if (str.charAt(j) == 'W') {
                    board[i][j] = true;
                    continue;
                }
            }
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i <= n - 8; i++) {
            for (int j = 0; j <= m - 8; j++) {
                min = Math.min(min, calculateBoard(board, i, j));
            }
        }

        System.out.println(min);
    }

    private static int calculateBoard(boolean[][] board, int y, int x) {
        boolean color = board[y][x];
        int count = 0;

        for (int i = y; i < y + 8; i++) {
            for (int j = x; j < x + 8; j++) {
                if (board[i][j] != color) {
                    count++;
                }

                // 색을 계속 변경
                color = !color;
            }

            /*
             * 'B'로 끝났다면 다음 줄은 또 'B'로 시작한다.
             * 위에서 color를 바꾸기 때문에 한 번더 바꿔주어서 되돌린다.
             */
            color = !color;
        }

        /*
         * board를 전부 바꿔야하는 최악의 경우 count = 64이다. (8 * 8이므로)
         * 하지만 시작 위치(윈쪽 맨 위)를 반대로 시작하게 된다면 바꿀게 아무것도 없으므로 count = 0이다.
         * 즉, 시작 위치를 정하고 count를 구했다면, 그 반대 시작은 64 - count가 되는 것이다.
         * 만약 64 - count를 하지 않는다면 시작 위치를 반대로 설정한 후 count 값과 비교해야 한다.
         */
        return Math.min(64 - count, count);
    }
}
