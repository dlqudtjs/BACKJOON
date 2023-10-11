import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N, apartNum;
    static int[] dx = new int[] { -1, 1, 0, 0 };
    static int[] dy = new int[] { 0, 0, -1, 1 };
    static int[] aparts;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];
        aparts = new int[N * N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - 48;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    apartNum++;
                    dfs(i, j);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(apartNum).append('\n'); // 단지 수 출력

        Arrays.sort(aparts); // 단지 오름차순

        for (int i = 0; i < aparts.length; i++) {
            if (aparts[i] != 0) { // 비는 단지는 0이 되기에 빼준다.
                sb.append(aparts[i]).append('\n');
            }
        }

        System.out.println(sb);
    }

    public static void dfs(int startX, int startY) {
        visited[startX][startY] = true;
        aparts[apartNum]++;

        for (int i = 0; i < 4; i++) {
            int x = startX + dx[i];
            int y = startY + dy[i];

            if (x >= 0 && x < N && y >= 0 && y < N && !visited[x][y] && map[x][y] == 1) {
                dfs(x, y);
            }
        }
    }
}

/*
 * ArrayList를 사용하는 것보다 Array를 사용하는 것이 더욱 빠름
 */

// import java.io.BufferedReader;
// import java.io.InputStreamReader;
// import java.util.ArrayList;
// import java.util.Collections;

// public class Main {
// static int N, apartCount;
// static int[] dx = new int[] { -1, 1, 0, 0 };
// static int[] dy = new int[] { 0, 0, -1, 1 };
// static ArrayList<Integer> list = new ArrayList<>();
// static int[][] map;
// static boolean[][] visited;

// public static void main(String[] args) throws Exception {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

// N = Integer.parseInt(br.readLine());

// map = new int[N][N];
// visited = new boolean[N][N];

// for (int i = 0; i < N; i++) {
// String line = br.readLine();
// for (int j = 0; j < N; j++) {
// map[i][j] = line.charAt(j) - 48;
// }
// }

// for (int i = 0; i < N; i++) {
// for (int j = 0; j < N; j++) {
// if (!visited[i][j] && map[i][j] == 1) {
// apartCount = 0;
// dfs(i, j);
// list.add(apartCount);
// }
// }
// }

// StringBuilder sb = new StringBuilder();
// sb.append(list.size()).append('\n'); // 단지 수 출력

// Collections.sort(list);

// for (int i = 0; i < list.size(); i++) {
// sb.append(list.get(i)).append('\n');
// }

// System.out.println(sb);
// }

// public static void dfs(int startX, int startY) {
// visited[startX][startY] = true;
// apartCount++;

// for (int i = 0; i < 4; i++) {
// int x = startX + dx[i];
// int y = startY + dy[i];

// if (x >= 0 && x < N && y >= 0 && y < N && !visited[x][y] && map[x][y] == 1) {
// dfs(x, y);
// }
// }
// }
// }
