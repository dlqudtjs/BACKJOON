import java.io.BufferedReader;
import java.io.InputStreamReader;
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

        String answer = "";
        int max = Integer.MAX_VALUE;

        int start = 0;
        int end = n - 1;
        // start 와 end가 만나면 종료
        while (start != end) {
            int value = arr[start] + arr[end];

            // max 값에는 절대값으로 저장되어 있으며, 0에 가까운 값으로 변경해야 하기 때문에
            // 절대값으로 된 값보다 작다면 해당 값은 0에 가까운 것이다.
            if (max > Math.abs(value)) {
                max = Math.abs(value);
                answer = arr[start] + " " + arr[end];
            }

            // 음수라면 왼쪽 밀기, 양수라면 오른쪽 밀기
            if (value <= 0) {
                start++;
            } else {
                end--;
            }
        }

        System.out.println(answer);
    }
}
