import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int maxValue = 0;
        for (int i = 0; i < N; i++) {
            int value = 1;

            for (int j = i + 1; j <= i + 4; j++) {
                if (j >= arr.length) {
                    break;
                }

                if (arr[i] >= arr[j] - 4) {
                    value++;
                } else {
                    break;
                }
            }

            maxValue = maxValue < value ? value : maxValue;
        }

        System.out.println(5 - maxValue);
    }
}
