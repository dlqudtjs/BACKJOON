import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        boolean flag = true;

        for (int i = l; i <= 100 && flag; i++) {
            // ex) 5라면 0, 1, 2, 3, 4을 더한 후 슬라이딩 윈도우를 해야함 (공식)
            int sum = i * (i - 1) / 2;
            int last = i;
            int index = 0;

            while (true) {
                if (sum == n) {
                    for (int j = index; j < index + i; j++) {
                        sb.append(j).append(" ");
                    }

                    flag = false;
                    break;
                }

                sum += last - (last - i);
                index += 1;
                last++;

                if (sum > n) {
                    break;
                }
            }
        }

        System.out.println(flag ? -1 : sb);
    }
}
