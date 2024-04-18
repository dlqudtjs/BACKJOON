import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int l = Integer.parseInt(br.readLine());

        int[] arr = new int[l];
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < l; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            if (arr[i] == n) {
                System.out.println(0);
                return;
            }
        }

        Arrays.sort(arr);
        int min = 0;
        int max = n;

        for (int i = 0; i < l; i++) {
            if (arr[i] < n && min < arr[i]) {
                min = arr[i];
            }

            if (arr[i] > max && max == n) {
                max = arr[i];
            }
        }

        min = min == 0 ? 1 : min + 1;
        max = max == n ? n : max - 1;

        // n의 앞 뒤로 숫자가 있을 경우
        // ex) n = 5일 때 4, 5, 6 이면 구간을 만들 수 없음.
        if (min == n && max == n) {
            System.out.println(0);
            return;
        }

        int count = 0;
        for (int i = min; i <= n; i++) {
            for (int j = n; j <= max; j++) {
                if (i == j) {
                    continue;
                }
                
                count++;
            }
        }

        System.out.println(count);
    }
}
