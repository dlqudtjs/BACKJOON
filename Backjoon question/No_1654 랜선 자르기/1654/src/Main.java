import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[k];
        long max = 0;

        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        Arrays.sort(arr);

        long low = 0;
        long mid = 0;
        // max가 최소값 1일 때 2로 시작하여 mid가 최소 1로 시작하는 것을 보장
        // (그렇기 때문에 long 선언 2^31 - 1까지 범위인데 ++하면 int 범위 밖임)
        max++;

        while (low < max) {
            mid = (low + max) / 2;

            long count = getCount(arr, mid);

            /*
             * mid 길이로 잘랐을 때 필요한 랜선의 개수보다 적다면
             * max를 mid로 변경하여 더 많이 자를 수 있도록 변경하고,
             * 필요한 랜선의 개수보다 더 많다면 low를 mid + 1로 설정해준다.
             * 
             * 이게 가능한 이유 : low가 mid + 1로 설정되었다는 것은 일단 n개를 만들 수 있는 조건을
             * 달성했다는 것을 보장한다는 것을 알아두자.
             * 
             * ex) 3 3, 1000 1000 1 일 땐 답이 500이다.
             * 돌다보면 low가 501이 되는데, 돌다보면 501(실제는 500)보다 더 좋은 값을 찾지 못해 결국 low < max 조건에 걸려
             * while을 나오게 된다.
             */
            if (count < n) {
                max = mid;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(low - 1);
    }

    private static long getCount(int[] arr, long mid) {
        long count = 0;

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] / mid == 0) {
                break;
            }

            count += arr[i] / mid;
        }

        return count;
    }
}
