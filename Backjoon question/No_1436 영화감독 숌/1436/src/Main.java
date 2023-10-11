import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int num = 666;
        int count = 1;

        while (count != n) {
            num++;

            String str = Integer.toString(num);
            if (str.contains("666")) {
                count++;
            }
        }

        System.out.println(num);
    }
}

/*
 * n: 1 일 때, 단순히 1을 붙여 1666이 아니라
 * 666, 667, 668 ... 1666이 되면 즉, 666의 다음 666이 연속으로 나오면
 * 몇 번만의 나온 지 출력하는 문제임.
 */