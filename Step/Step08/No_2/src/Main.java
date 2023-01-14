import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        boolean[] prime = new boolean[N + 1]; // 인덱스를 번호로 사용하기 위해 + 1
        prime[0] = true;
        prime[1] = true; // 0과 1은 소수가 아님

        // M의 범위까지 소수구하기
        for (int i = 2; i <= Math.sqrt(N); i++) {

            if (prime[i]) {
                continue;
            }

            for (int j = i * i; j <= N; j += i) {
                prime[j] = true;
            }
        }

        int sum = 0;
        int min = 10001; // 최대 10000

        for (int i = M; i <= N; i++) {
            if (!prime[i]) { // false는 소수
                sum += i;
                if (min == 10001) { // 최소 값 구하기
                    min = i;
                }
            }
        }

        if (sum == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(min);
        }
    }
}