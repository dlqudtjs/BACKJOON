import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = new int[] { 0, 0, -1, 1 };
    static int[] dy = new int[] { 1, -1, 0, 0 };
    static char[][] map;
    static int endX, endY;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        int rx = 0;
        int ry = 0;
        int bx = 0;
        int by = 0;

        for (int i = 0; i < n; i++) {
            String row = br.readLine();

            for (int j = 0; j < m; j++) {
                map[i][j] = row.charAt(j);

                if (map[i][j] == 'R') {
                    rx = j;
                    ry = i;
                    map[i][j] = '.';
                } else if (map[i][j] == 'B') {
                    bx = j;
                    by = i;
                    map[i][j] = '.';
                } else if (map[i][j] == 'O') {
                    endX = j;
                    endY = i;
                }
            }
        }
        Point point = new Point(rx, ry, bx, by, 0);

        bfs(point);
    }

    public static void bfs(Point point) {
        Queue<Point> queue = new LinkedList<>();

    }
}

class Point {
    int rx;
    int ry;
    int bx;
    int by;
    int cnt;

    public Point(int rx, int ry, int bx, int by, int cnt) {
        this.rx = rx;
        this.ry = ry;
        this.bx = bx;
        this.by = by;
        this.cnt = cnt;
    }
}