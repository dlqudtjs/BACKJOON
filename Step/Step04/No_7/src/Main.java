import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] grades = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        double total = 0;
        int max = 0;

        // 배열에 점수 넣고 총 점수, 최대값 구하기
        for (int i = 0; i < n; i++) {
            grades[i] = Integer.parseInt(st.nextToken());
            total += grades[i];
            max = max < grades[i] ? grades[i] : max;
        }

        System.out.println((total / max * 100) / n);
        br.close();
    }
}
