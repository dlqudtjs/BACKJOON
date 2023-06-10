import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken()); // 부분합 기준

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int sum = arr[0]; // 첫 번째 원소가 부분합 기준을 넘는 예외를 위해 설정
        int answer = Integer.MAX_VALUE;

        while (start <= end) {
            int length = (end - start) + 1;

            // 현재 부분합이 부분합의 기준(s) 보다 크거나 같고, 그 수열이 현재 구한 길이보다 더 짧다면
            if (sum >= s) {
                answer = answer > length ? length : answer;

                // sum이 부분합 기준을 만족하기 때문에 수열의 길이를 줄이기 위해 앞에 있는 start를 한 칸 민다.
                // 밀면서 기존에 있던 start 위치의 값을 빼줌(현재 start 인덱스를 빼준 수 start를 증가)
                sum -= arr[start++];
                continue;
            }

            // 현재 if문을 실행한다는 것은 위에 sum >= s 기준을 넘지 못했기 때문에
            // end를 늘려줘야 하는 상황에서 end가 배열 밖이라면 더 짧은 수열을 얻지 못함, 따라서 break
            if (end + 1 >= n) {
                break;
            }

            // end를 밀어줌과 동시에 sum 값을 채워줌
            sum += arr[++end];
        }

        System.out.println(answer == Integer.MAX_VALUE ? 0 : answer);
    }
}
