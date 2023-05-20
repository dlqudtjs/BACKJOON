import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int sum = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] num = new int[N];

        for (int i = 0; i < N; i++) {
            num[i] = i + 1;
        }

        dfs(num);

        System.out.println(sum);
    }

    private static void dfs(int[] num) {
        // 하나 남았을 땐 수를 버린다
        if (num.length / 2 == 0) {
            return;
        }

        // 두 개 남았을 땐 서로 곱해줌
        if (num.length / 2 == 1) {
            sum += num[0] * num[1];
            return;
        }

        // 1, 2, 3, 4일 땐 짝수 이기 때문에 length = 2가 된다.
        // 이때, 배열을 나누게 되면 [1, 2]로 잘 나누어 지지만 1, 2, 3일 땐
        // length = 1이 되며 [1]로 나누어진다. 하지만 [1, 2]로 나누어야 하기 때문에 홀수일 때는 +1를 해준다.
        int length = num.length / 2;
        if (num.length % 2 != 0) {
            length++;
        }

        dfs(Arrays.copyOfRange(num, 0, length));
        dfs(Arrays.copyOfRange(num, length, num.length));
    }
}
