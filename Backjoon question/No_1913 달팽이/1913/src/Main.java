import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int findNum = Integer.parseInt(br.readLine());

        int[][] map = drawMap(N);

        Point findPoint = findPoint(map, findNum);

        System.out.print(sb);
        System.out.println((findPoint.y + 1) + " " + (findPoint.x + 1));
    }

    public static int[][] drawMap(int N) {
        int[][] map = new int[N][N]; // map 크기 설정
        int x = N / 2; // x 시작 위치
        int y = N / 2; // x 시작 위치

        int squareNum = (int) Math.pow(N, 2);
        int value = 1; // 1부터 ~ squareNum까지 증가
        int limit = 1; // 시계 방향으로 값을 채우기 위한 값

        while (true) {
            // 현재 위치에 위로 limit 만큼 이동하며 value를 삽입한다.
            for (int i = 0; i < limit; i++) {
                map[y--][x] = value++;
            }

            // 위로 올라가며 값을 채우는 과정이 마지막 과정이다.
            if (value > squareNum) {
                break;
            }

            // 현재 위치에 오른쪽으로 limit 만큼 이동하며 value를 삽입한다.
            for (int i = 0; i < limit; i++) {
                map[y][x++] = value++;
            }

            // 위로, 오른쪽으로 이동했으면 limit을 1 증가시켜준다.
            limit++;

            // 현재 위치에서 아래로 limit 만큼 이동하며 value을 삽입한다.
            for (int i = 0; i < limit; i++) {
                map[y++][x] = value++;
            }

            // 현재 위치에서 왼쪽으로 limit 만큼 이동하며 value을 삽입한다.
            for (int i = 0; i < limit; i++) {
                map[y][x--] = value++;
            }

            // 아래로, 왼쪽으로 이동했으면 limit을 1 증가시켜준다.
            limit++;
        }

        return map;
    }

    public static Point findPoint(int[][] map, int findNum) {
        Point findPoint = null;
        sb = new StringBuilder();

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == findNum) {
                    findPoint = new Point(i, j);
                }

                sb.append(map[i][j]).append(' ');
            }

            sb.append('\n');
        }

        return findPoint;
    }
}

class Point {
    int y;
    int x;

    public Point(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

/*
 * dfs, 좌표 방향등을 이용해 풀 수 있었으나, depth 2이상 (스코프 2단) 사용하지 않으려고 노력하느라
 * 시간을 좀 잡아먹었다. findPoint에서 불가피하게 2중 for문 안에 if문을 사용하여 위반하였지만 다른 방법은 메서드를
 * 불필요하게 생성하게 될 것 같아 그냥 두었지만 더 좋은 대안을 찾으면 다음 문제에 적용하도록 하자.
 * 참고 블로그 = https://loosie.tistory.com/538
 */