import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int length = 1000;
        int n = Integer.parseInt(br.readLine());

        boolean[] prime = new boolean[length + 1]; // 0부터 시작하므로 + 1
        prime[0] = true;
        prime[1] = true; // 0과 1은 소수가 아님

        for (int i = 2; i <= Math.sqrt(length); i++) {

            // 만약 첫 시작 배열이 true = 즉 이미 지워졌다면 그 수의 배수는 이미 지워졌기에 넘어간다.
            if (prime[i]) {
                continue;
            }

            /*
             * int j = i * 2부터 시작해도 되지만 이미 2의 배수에서 걸려졌기 때문에
             * 제곱수 부터 시작해도 상관없다. (차이 없음.)
             * for문의 범위는 배열의 길이만큼.
             * j의 증가는 j의 배수만큼 즉 j = j + i;
             */
            for (int j = i * i; j < length + 1; j += i) {
                prime[j] = true;
            }
        }

        int count = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < st.countTokens(); n++) {
            int index = Integer.parseInt(st.nextToken());
            if (!prime[index]) {
                count++;
            }
        }

        System.out.println(count);
    }
}

// for문에서 n만큼 돌리는 것과 st.countTokens로 돌리는 것과
// 차이를 모르겠음. n만큼은 안 되고 st.countTokens로 같은 횟수로 돌려도 오류가 발생
