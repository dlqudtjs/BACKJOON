import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;
    static int r, c, cnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = (int) Math.pow(2, Double.parseDouble(st.nextToken()));
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        dfs(0, 0, N);
    }

    private static void dfs(int y, int x, int size) {
        if (size == 1) {
            System.out.println(cnt);
            return;
        }

        int dividedSize = size / 2;
        /*
         * cnt 를 세는 방법은 다음과 같이 생각하면 간단한다.
         * 1. 만약 N이 4이라면 배열은 4 * 4 이기 때문에 배열의 총 크기인 size * size를 해준다.
         * 2. 그 후, 1사분면은 4, 5, 6, 7을 썼을테니까 총 사이즈(size * size)의 / 4을 한다.
         * 3. 3사분면은 총 크기(size * size) / 4 후 * 2가 시작 크기, 4사분면은 총크기 / 4후 * 3이 시작 크기가 된다.
         * 4. 2사분면은 0으로 시작하기 때문에 아무것도 cnt하지 않는다.
         */
        // 1사분면
        if (r < y + dividedSize && c >= x + dividedSize) {
            cnt += (size * size) / 4;
            dfs(y, x + dividedSize, dividedSize);
        }

        // 2사분면
        if (r < y + dividedSize && c < x + dividedSize) {
            dfs(y, x, dividedSize);
        }

        // 3사분면
        if (r >= y + dividedSize && c < x + dividedSize) {
            cnt += ((size * size) / 4) * 2;
            dfs(y + dividedSize, x, dividedSize);
        }

        // 4사분면
        if (r >= y + dividedSize && c >= x + dividedSize) {
            cnt += ((size * size) / 4) * 3;
            dfs(y + dividedSize, x + dividedSize, dividedSize);
        }
    }
}