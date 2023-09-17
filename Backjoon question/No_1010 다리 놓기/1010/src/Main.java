import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        int result;
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            result = 1;

            for (int j = 0; j < n; j++) {
                result = result * (m - j) / (j + 1);
            }

            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }
}

/*
 * 이 문제는 단순히 조합 공식의 답을 도출하면 되는 문제이기 때문에
 * 재귀를 통해 일일이 구하는 것이 아닌 공식을 통해 답을 구해야 시간초과가 걸리지 않는다.
 */