import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] confetti;
    static int white = 0;
    static int blue = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        confetti = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                confetti[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, N);

        System.out.println(white);
        System.out.println(blue);
    }

    private static void dfs(int row, int col, int size) {

        if (check(row, col, size)) {
            // size 칸에 모든 색종이가 색이 같다면 무슨색인지 확인 후 색 ++
            if (confetti[row][col] == 0) {
                white++;
            } else {
                blue++;
            }

            return;
        }

        int dividedSize = size / 2;

        dfs(row, col, dividedSize); // 왼쪽 위 2사분면
        dfs(row, col + dividedSize, dividedSize); // 오른쪽 위 1사분면
        dfs(row + dividedSize, col, dividedSize); // 왼쪽 아래 3사분면
        dfs(row + dividedSize, col + dividedSize, dividedSize); // 오른쪽 아래 4사분면
    }

    private static boolean check(int startY, int startX, int size) {
        int color = confetti[startY][startX];

        // 시작한 곳에서 size 만큼 가야한다.
        // 즉, 4, 4에서 4칸 가야하는 경우에는 7까지 가야하기 때문에 size를 더한 값까지 간다.
        for (int i = startY; i < startY + size; i++) {

            for (int j = startX; j < startX + size; j++) {
                if (confetti[i][j] != color) {
                    return false;
                }
            }
        }

        return true;
    }
}
