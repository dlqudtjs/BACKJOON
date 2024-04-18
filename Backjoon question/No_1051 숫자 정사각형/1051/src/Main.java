import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();

            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        int answer = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                answer = Math.max(answer, getSize(i, j, map));
            }
        }

        System.out.println(answer);
    }

    private static int getSize(int y, int x, int[][] map) {
        int length = 1;
        int result = 1;

        while (true) {
            // 범위 검사
            if (y + length == map.length || x + length == map[0].length) {
                break;
            }

            if (map[y][x] == map[y][x + length] &&
                    map[y][x] == map[y + length][x] &&
                    map[y][x] == map[y + length][x + length]) {
                result = (length + 1) * (length + 1);
            }

            length++;
        }

        return result;
    }
}
