import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken()); // 기준

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int start = 0;
        int end = 0;
        int min = Integer.MAX_VALUE;

        while (start <= end && end < n) {
            int value = arr[end] - arr[start];

            /*
             * 두 포인터는 처음 인덱스에서 시작한다.
             * 그 후, 만약 두 포인터의 차가 m보다 크거나 같다면 start 포인터를 올려 그 차이를 좁히고
             * 차가 m 보다 작다면 end 포인터를 올려 두 포인터의 차를 올린다.
             */
            if (value >= m) {
                min = Math.min(min, value);
                start++;
                continue;
            }

            end++;
        }

        System.out.println(min);
    }
}