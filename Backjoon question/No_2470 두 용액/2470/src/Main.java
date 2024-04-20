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

        int left = 0;
        int right = n - 1;
        int min = Integer.MAX_VALUE;
        int[] answer = new int[2];

        while (left != right) {
            int leftValue = arr[left];
            int rightValue = arr[right];
            if (Math.abs(leftValue + rightValue) < min) {
                answer[0] = leftValue;
                answer[1] = rightValue;
                min = Math.abs(leftValue + rightValue);
            }

            if (Math.abs(leftValue) > Math.abs(rightValue)) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(answer[0] + " " + answer[1]);
    }
}
