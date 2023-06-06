import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int num = 0;
        for (int i = 0; i < K; i++) {
            num += arr[i];
        }

        int max = num;
        for (int i = K; i < N; i++) {
            num -= arr[i - K]; // 빠질 앞 부분을 빼주고
            num += arr[i]; // 들어갈 맨 뒤 부분을 더해줌

            max = Math.max(max, num);
        }

        System.out.println(max);
    }
}
