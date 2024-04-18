import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if (n == 1) {
            br.readLine();
            System.out.println(0);
            return;
        }

        int[] arr = new int[n - 1];
        int dasom = Integer.parseInt(br.readLine());
        int answer = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        while (true) {
            Arrays.sort(arr);
            int max = arr[arr.length - 1];

            if (max < dasom) {
                break;
            }

            for (int i = arr.length - 1; i >= 0; i--) {
                if (arr[i] != max || max < dasom) {
                    break;
                }

                arr[i]--;
                dasom++;
                answer++;
            }
        }

        System.out.println(answer);
    }
}
