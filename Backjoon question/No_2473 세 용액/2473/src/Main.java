import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[] arr = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        long compareValue = Long.MAX_VALUE;
        String answer = "";

        for (int i = 0; i < n - 2; i++) {
            /*
             * 시작 위치는 가만히 위치를 고정한 후, mid와 end만 움직여서 최소값을 찾아낸다.
             * 값이 양수라면 end--, 음수라면 mid++를 하여 start와 end를 양 끝에 두고 mid를 가운데에서 움직인다.
             */
            int start = i;
            int mid = i + 1;
            int end = n - 1;

            while (mid < end) {
                long sum = arr[start] + arr[mid] + arr[end];

                if (compareValue > Math.abs(sum)) {
                    compareValue = Math.abs(sum);
                    answer = arr[start] + " " + arr[mid] + " " + arr[end];
                }

                if (sum == 0) {
                    break;
                }

                if (sum > 0) {
                    end--;
                } else {
                    mid++;
                }
            }
        }

        System.out.println(answer);
    }
}