import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[][] video;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        video = new int[N][N];

        for (int i = 0; i < N; i++) {
            int cnt = 0;

            for (char c : br.readLine().toCharArray()) {
                video[i][cnt++] = c - '0';
            }
        }

        dfs(0, 0, N);

        System.out.println(sb);
    }

    private static void dfs(int y, int x, int size) {
        if (check(y, x, size)) {
            return;
        }

        sb.append("(");

        int length = size / 2;

        dfs(y, x, length);
        dfs(y, x + length, length);
        dfs(y + length, x, length);
        dfs(y + length, x + length, length);

        sb.append(")");
    }

    private static boolean check(int y, int x, int size) {
        int color = video[y][x];

        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (color != video[i][j]) {
                    return false;
                }
            }
        }

        sb.append(color);

        return true;
    }
}
