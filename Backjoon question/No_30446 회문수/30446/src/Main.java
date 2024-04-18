import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Long n = Long.parseLong(br.readLine());

        for (int j = 1; j <= 10; j++) {
            int count = 0;

            for (long i = 1; i <= j; i++) {
                StringBuilder revers = new StringBuilder();
                String str = String.valueOf(i);

                // 길이가 짝수 일 때
                if (str.length() % 2 == 0) {
                    revers.append(str.substring(str.length() / 2));
                    if (str.subSequence(0, str.length() / 2).equals(revers.reverse())) {
                        count++;
                    }

                    continue;
                }

                revers.append(str.substring((str.length() / 2) + 1));
                // 홀수 일 때
                if (str.subSequence(0, str.length() / 2).equals(revers.reverse())) {
                    count++;
                }
            }

            sb.append(j).append(" : ").append(count).append("\n");
        }

        System.out.println(sb);
    }
}
