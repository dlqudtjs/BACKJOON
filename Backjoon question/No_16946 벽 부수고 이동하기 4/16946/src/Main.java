import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] map;
    static int[] dy = new int[] { -1, 1, 0, 0 };
    static int[] dx = new int[] { 0, 0, -1, 1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();

            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        Map<Integer, Integer> hashMap = new HashMap<>();
        int num = 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    hashMap.put(num, bfs(i, j, num));
                    num++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int count = 1;
                // 벽일 때
                if (map[i][j] == 1) {
                    Set<Integer> set = new HashSet<>();
                    for (int k = 0; k < 4; k++) {
                        int y = i + dy[k];
                        int x = j + dx[k];

                        if (y < 0 || y >= n || x < 0 || x >= m || map[y][x] == 1 || set.contains(map[y][x])) {
                            continue;
                        }

                        count += hashMap.get(map[y][x]);
                        set.add(map[y][x]);
                    }

                    sb.append(count % 10);
                } else {
                    sb.append("0");
                }
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static int bfs(int y, int x, int num) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { y, x });
        map[y][x] = num;
        int count = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            count++;

            for (int i = 0; i < 4; i++) {
                int nowY = dy[i] + current[0];
                int nowX = dx[i] + current[1];

                if (nowY < 0 || nowY >= n || nowX < 0 || nowX >= m) {
                    continue;
                }

                if (map[nowY][nowX] != 0) {
                    continue;
                }

                queue.add(new int[] { nowY, nowX });
                map[nowY][nowX] = num;
            }
        }

        return count;
    }
}

/*
 * map 하나로 map, visited 기능을 수행함.
 * 그룹은 2부터 시작하여 map에 그룹을 짓고, 1은 벽으로 지정하여
 * 0이 아닌 곳은 벽이거나, 이미 그룹을 지정한 곳이기 때문에 map 하나로 visit처리도 가능하게 함
 */