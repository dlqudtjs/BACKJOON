import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        boolean[] students = new boolean[30];
        int minNo = 31;
        int maxNo = 0;

        // 출석 부르기
        for (int i = 0; i < 28; i++) {
            students[Integer.parseInt(br.readLine()) - 1] = true;
        }

        for (int i = 0; i < 30; i++) {
            if (students[i] != true) {
                int index = i + 1;
                minNo = index < minNo ? index : minNo;
                maxNo = index > maxNo ? index : maxNo;
            }
        }

        sb.append(minNo).append("\n").append(maxNo);
        System.out.println(sb);

        br.close();
    }
}
