import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int buy = 0; // 물병 구매 수

        while (true) {
            int count = 0; // 2진수의 1의 개수

            int copyN = N++; // N에서 1의 개수를 찾기위해 계산을 하게 되는 과정이 있기에 카피
            while (copyN != 0) {
                // 10진수를 2진수로 변환하는 과정에서 나머지 1이 나올 때 count에 더해준다.(1의 개수를 알 수 있게됨)
                count += copyN % 2;
                copyN /= 2;
            }

            if (count <= K) { // count, 즉 1의 개수가 K(들고갈 수 있는 수)보다 적거나 같으면 break
                break;
            }

            // N++;
            buy++; // 1의 개수가 K보다 적을 시 물병을 1개 구매한다.
        }

        System.out.println(buy);
    }
}

/*
 * N = 10, K = 1일 경우
 * 10의 경우 2진수로 1010이다. 즉 물병이 두 개가 사용된다. [8, 2] (2진수의 자리값)
 * 가져가기 위해 물병을 1로 줄여야하는데 이 과정에서 10에 1을 더하게 되어(물병을 하나 구매)
 * 2진수로 변환후 1의 개수를 세어(물병의 수) K보다 적거나 같을 시 가져갈 수 있게된다.
 * 즉 16까지 더해야 한다.(10000을 만들기 위해) 필요한 물병의 수는 6개가 된다.
 */
