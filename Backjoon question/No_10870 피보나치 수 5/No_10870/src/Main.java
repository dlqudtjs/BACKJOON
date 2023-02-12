import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static long[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr = new long[n + 1]; // n번 째까지 포함하기 위해 (0부터 시작)

        for (int i = 0; i < n + 1; i++) {
            arr[i] = -1; // -1로 초기화
        }

        System.out.println(fib(n));
    }

    public static long fib(int n) {
        // 0과 1을 초기화 하지 않으면 아래 fib(n-1) fib(n-2)에서 -1 값이 들어가게 돼서
        // indexout 오류가 나온다. (최소 2부터 돌릴 수 있게)
        if (n == 0 || n == 1) {
            arr[n] = n;
        }

        if (arr[n] == -1) {
            arr[n] = fib(n - 1) + fib(n - 2);
        }

        return arr[n];
    }
}
