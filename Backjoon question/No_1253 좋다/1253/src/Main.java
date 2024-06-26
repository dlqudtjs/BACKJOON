import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int answer = 0;

        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n - 1;

            while (left < right) {
                int sum = arr[left] + arr[right];

                if (sum == arr[i]) {
                    if (left != i && right != i) {
                        answer++;
                        break;
                    }

                    if (left == i) {
                        left++;
                    } else {
                        right--;
                    }

                    continue;
                }

                if (arr[i] > sum) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        System.out.println(answer);
    }
}
