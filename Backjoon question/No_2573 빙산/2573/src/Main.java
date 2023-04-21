import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        char[][] map = new char[N][N];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int width = 0;
        int height = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i + 1 < N) {
                    if (map[i][j] == '.' && map[i + 1][j] == '.' && (i + 2 >= N || map[i + 2][j] == 'X')) {
                        height++;
                    }
                }
                if (j + 1 < N) {
                    if (map[i][j] == '.' && map[i][j + 1] == '.' && (j + 2 >= N || map[i][j + 2] == 'X')) {
                        width++;
                    }
                }
            }
        }
        System.out.println(width + " " + height);

    }
}
