import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int[] arr = new int[3];

        while (true) {
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < 3; i++) {
                arr[i] = Integer.parseInt(st.nextToken());

                if (arr[i] == 0) {
                    System.out.println(sb);
                    return;
                }
            }

            Arrays.sort(arr);

            if (arr[2] >= (arr[0] + arr[1])) {
                sb.append("Invalid").append("\n");
                continue;
            }

            if (arr[0] == arr[1] && arr[1] == arr[2]) {
                sb.append("Equilateral").append("\n");
                continue;
            }

            if ((arr[0] == arr[1]) || (arr[1] == arr[2]) || (arr[0] == arr[2])) {
                sb.append("Isosceles").append("\n");
                continue;
            }

            sb.append("Scalene").append("\n");
            continue;
        }
    }
}
