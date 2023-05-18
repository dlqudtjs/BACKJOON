import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long C;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // A, B, C 모두 2,147,483,647 이하이므로, long 선언을 해준다.
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());

        System.out.println(pow(A, B));
    }

    private static long pow(long A, long exponent) {
        // 지수가 1일 땐, A를 반환한다.
        if (exponent == 1) {
            return A % C;
        }

        // 지수를 반으로 분할한 후 나온 값을 저장한다.
        // ex) A = 10 exponent = 10 일 때, exponent 5 -> 2 -> 1까지 구한다.
        long temp = pow(A, exponent / 2);

        // 지수가 홀수 일 때(ex 9일 때), (A)^4, (A)^4, (A)^1 나머지 1을 처리해주기 위해
        // 지수 1 즉, A를 한 번더 곱해준다.
        if (exponent % 2 == 1) {

            // 모듈러 합동 공식 => (A * B) % C => (A % C * B % C) % C
            // 따라서 temp * temp * A % C 에서 temp * temp = A로 바꾸고
            // A를 B로 바꾸면 ((temp * temp % C) * (A % C)) % C로 변환할 수 있다.
            // 사용 이유 : 바로 (A * B) % C를 해도 같은 값이 나오지만 A, B, C의 범위는 각각 2^32 이기 때문에
            // A * B까지는(2^64) 커버가 가능하지만 A * B * C 는 2^96이 되기 때문에 long 범위를 벗어난다.
            // 따라서, 합동 모듈러를 사용하여 구간마다 나눗셈을 하여 범위를 넘지 않게 할 수 있다.
            // 즉, exponent가 홀 수 일 땐 범위가 초과할 수 있기 때문에 합동 모듈러를 사용하고 짝수일 땐 그냥 나눠준다.
            return ((temp * temp % C) * (A % C)) % C;
        }

        // 홀수가 아닐 땐 지수를 2로 나눈 temp를 곱하고 C로 나누면 된다.
        return temp * temp % C;
    }
}
