import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] num;
    static int[] operator = new int[4];
    static int maxValue = Integer.MIN_VALUE;
    static int minValue = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        num = new int[N];

        // 숫자 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        // 연산자 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        dfs(num[0], 1);

        System.out.println(maxValue);
        System.out.println(minValue);
    }

    private static void dfs(int n, int index) {
        // index 즉, 숫자들을 모두 사용했다면 수열 조합이 완료 됐다는 것이다.
        // 아래 for문에서 연산자의 조합은 재귀함수로 사용하며, 숫자는 index로 활용하기 때문에
        // index가 N과 같다면 결과를 비교한다.

        if (index == N) {
            maxValue = Math.max(maxValue, n);
            minValue = Math.min(minValue, n);

            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {
                // 해당 연산자를 사용
                operator[i]--;

                if (i == 0) { // 덧셈
                    dfs(n + num[index], index + 1);

                }
                if (i == 1) { // 뺄셈
                    dfs(n - num[index], index + 1);

                }
                if (i == 2) {// 곱셈
                    dfs(n * num[index], index + 1);

                }
                if (i == 3) {// 나눗셈
                    dfs(n / num[index], index + 1);
                }

                // 사용 완료 연산자
                operator[i]++;
            }
        }
    }
}
