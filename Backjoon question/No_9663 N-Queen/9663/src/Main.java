import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[] arr;
    static int n, cnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[0] = i;

            dfs(0);
        }

        System.out.println(cnt);
    }

    public static void dfs(int depth) {
        depth++;

        if (depth == n) {
            cnt++;
            return;
        }

        for (int i = 0; i < n; i++) {
            arr[depth] = i;

            if (!checkQueen(depth)) { // 해당 위치에 두면 퀸에게 공격 받는지 확인
                continue;
            }

            dfs(depth);
        }
    }

    public static boolean checkQueen(int depth) {
        for (int i = 0; i < depth; i++) {

            if (arr[i] == arr[depth]) { // 열 확인(두는 곳이 행이기 때문에 행은 검사하지 않음)
                return false;
            }

            if (Math.abs(depth - i) == Math.abs(arr[depth] - arr[i])) { // 대각 확인
                return false;
            }
        }

        return true;
    }
}

/*
 * 해당 코드는 2차원 배열을 사용하지 않고 1차원 배열로 풀었다.
 * 
 * 가장 이해가 안 됐던 부분은 1차원 배열에서 대각선 찾는 부분이었다.
 * 기존 코드는 착수한 퀸의 위치를 알고 있기 때문에 착수한 퀸의 위치를 꺼내서
 * 착수할 퀸과 대각선 검사를 하였지만, 1차원 배열은 기존 코드에서 변경되니 이해가 되지 않았다.
 * 
 * (3, 1) (2, 2)가 대각선 상에 있음에도 |3 - 1| == |2 - 2| 가 성립되지 않아 답답했다.
 * 열과 행의 차가 같은 경우는 자신의 좌표에서의 차가 아닌 비교할 좌표의 행과 열을 비교하는 것이었다.
 * ex) 위와 같은 좌표가 주어졌을 때, |3 - 2| == |1 - 2|가 성립되기 때문에 서로 대각선 상에 위치한다고
 * 볼 수 있는 것이다.
 * 
 * 대각 이해 안 됐을 떄 보기
 * https://ahnyezi.github.io/backtracking/b9663/
 * 
 */