import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[63]; // k^62 까지 존재함

        int length = 0;
        for (int i = 0; i < n; i++) {
            String query = br.readLine();

            long temp = Long.parseLong(query.substring(1));

            if (temp != 0) {
                // 입력 값이 2의 몇 승인지 구함
                // 이 부분에서 temp가 0일 때, AArrayIndexOutOfBounds오류가 발생함.
                int value = (int) (Math.log(temp) / Math.log(2));

                if (query.charAt(0) == '+') {
                    arr[value]++;

                    length++;
                } else {
                    arr[value]--;

                    length--;
                }
            }

            if (length == 0) {
                sb.append("0").append("\n");
                continue;
            }

            int[] answer = Arrays.copyOf(arr, arr.length);
            int max = 0;

            // 새로운 카피 배열에서 연산을 진행한다.
            for (int j = 0; j <= 61; j++) {
                answer[j + 1] += answer[j] / 2;

                max = answer[j + 1] != 0 ? j + 1 : max;
            }

            sb.append((long) Math.pow(2, max)).append("\n");
        }

        System.out.println(sb);
    }
}