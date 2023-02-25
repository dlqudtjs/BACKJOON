import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());

        int s = 0; // 비트마스킹에 사용될 변수

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");

            switch (input[0]) { // x 값을 받지 않는 all, empty만 앞으로 빼주었다.
                case "all":
                    s = Integer.MIN_VALUE - 1;
                    break;
                case "empty":
                    s = 0;
                    break;
                default:
                    int x = Integer.parseInt(input[1]);

                    switch (input[0]) { // x값 받는 switch 문
                        case "add": // 1을 x만큼 << 로 쉬프트 시켜 or로 더해준다. (해당 위치에 비트마스킹)
                            s |= (1 << x);
                            break;

                        // 1을 x 만큼 쉬프트하여 반전시킨 값을 and 연산하여 지운다.(~ 반전으로 0을 쉬프트 한 것과 같음)
                        case "remove":
                            s &= ~(1 << x);
                            break;
                        case "check": // 1 << x 의 위치와 마스킹된 s의 위치를 and시켜 1이면 1 아니면 0을 출력
                            sb.append((s & (1 << x)) != 0 ? 1 : 0).append('\n');
                            break;
                        case "toggle": // xor 연산으로 1 << x 의 위치를 반전시킴
                            s ^= (1 << x);
                            break;
                    }
            }
        }

        System.out.println(sb);
    }
}
