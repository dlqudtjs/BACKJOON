import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int c = Integer.parseInt(br.readLine());

        for (int i = 0; i < c; i++) {
            int sum = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] score = new int[n];

            // n배열에 값 넣기
            for (int j = 0; j < n; j++) {
                score[j] = Integer.parseInt(st.nextToken());
                sum += score[j];
            }

            // 배열에 평균값 보다 높은 사람 수 찾기
            double avg = sum / n;
            double count = 0;
            for (int j = 0; j < n; j++) {
                if (score[j] > avg) {
                    count++;
                }
            }

            sb.append(String.format("%.3f", count / n * 100)).append("%").append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}