import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static char[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        arr = new char[N][N];

        star(0, 0, N, false);

        for (int i = 0; i < N; i++) {
            bw.write(arr[i]);
            bw.write('\n');
        }

        bw.flush();
        bw.close();
    }

    static void star(int x, int y, int N, boolean blank) {

        /*
         * blank (호출한 함수가 공백칸을 요청했을 때), 즉 해당 칸을 공백으로 채우면 된다.
         * for문이 작동하는 범위는 현재 넘어온 x, y부터 자신의 사이즈 N만큼 채우면 된다.
         * 범위가 x + N, y + N 인 이유는 넘어온 x, y가 시작점이며 그 시작점으로 부터 size만큼의 사각향을 채우면 된다.
         */

        if (blank) {
            for (int i = x; i < x + N; i++) {
                for (int j = y; j < y + N; j++) {
                    arr[i][j] = ' ';
                }
            }

            return;
        }

        if (N == 1) { // 더 이상 쪼개지지 않을 때 (size가 1일 때)
            arr[x][y] = '*';
            return;
        }

        /*
         * N = 27 일 경우 한 블록의 사이즈는 9 이고,
         * N = 9 일 경우 한 블록의 사이즈는 3이듯
         * 현재 사이즈에서 블록 1칸을(N = 27의 블록 1칸은 9) 채워야하는 사이즈이다.
         * ex) 현재 N = 9 일 때 1칸을 채울 size는 3이 되고, 재귀함수를 호출할 때
         * N으로 3을 넘겨서 다음 함수에게 맡긴다. N이 3일 땐 size 1을 다음 함수에게 넘겨 별을 찍는다.
         */

        int size = N / 3;
        int count = 0;

        // 위와 같이 x + N 만큼의 for문 범위를 돌리며, size(N / 3)의 크기만큼 넘으며 블록을 채우게 된다.
        // 한 블록은 재귀함수가 채워주며, 그 다음 블록을 채우기 위해 i += size를 통해
        // 다음 블록의 사이즈 만큼 건너뛰어서, 채워야 할 블록의 시작지점 i ,j 를 넘겨줌으로써 다 채우게 된다.
        for (int i = x; i < x + N; i += size) {
            for (int j = y; j < y + N; j += size) {
                count++;

                if (count == 5) {
                    star(i, j, size, true);
                } else {
                    star(i, j, size, false);
                }
            }
        }
    }
}
