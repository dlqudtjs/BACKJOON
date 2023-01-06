import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        // 문제 : 주어진 N이 1인 경우 아무것도 출력하지 않기에 if문으로 1차적으로 걸렀다.
        if (N != 1) {
            // N이 두 개 이상 곱셈으로 나타낼 수 있을 때 인수 중 한 개 이상은 반드시 루트N 보다 작거나 같다.
            // 만약 그냥 소수 일 경우 for문 인수 분해에 걸리지 않고 N != 1에 걸리게 되어 소수가 출력된다.
            for (int i = 2; i <= Math.sqrt(N); i++) {
                while (N % i == 0) {
                    sb.append(i).append("\n");
                    N /= i;
                }
            }

            // 위에서 소인수분해 후 N이 1일 경우 딱 맞아 떨어져 for문 범위 안에서 끝나게 되지만
            // 그렇지 않고 for문의 범위를 벗어날 때까지 맞아 떨어지지 않는다면 남은 인수는 소수이므로 출력한다.
            if (N != 1) {
                sb.append(N);
            }
        }

        System.out.println(sb);
    }
}
