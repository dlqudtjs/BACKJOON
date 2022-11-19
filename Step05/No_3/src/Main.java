import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(arithmetic(n));
    }

    // 연속하는 두 항의 차이가 모두 일정한 수열
    static int arithmetic(int n) {
        if (n < 100) {
            return n;
        }

        int cnt = 99;

        for (int i = 100; i <= n; i++) {
            int hun = i / 100;
            int ten = (i / 10) % 10;
            int one = i % 10;

            if ((hun - ten) == (ten - one)) {
                cnt++;
            }
        }

        return cnt;
    }
}
