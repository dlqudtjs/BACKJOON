import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n == 1) {
            System.out.println(1);
        } else {
            int count = 1; // 겹 수 (전의 겹수 * 6 => 다음 벌집의 최소 수)
            int range = 2; // 벌집 최소 수

            while (range <= n) { // range 범위 안에 n이 든다면 count++해야 된다.
                // (count 겹수를 1부터 시작했기 때문, 전의 겹수 * 6 => 다음 벌집의 최소 수이기 때문이다.)
                range += (6 * count);
                count++;
            }

            System.out.println(count);
        }
    }
}

/*
 * 벌집 늘어나는 개수 n
 * 1 1 1
 * 2~7 6 2
 * 8~19 12 3
 * 20~37 18 4
 * 38~61 24 5
 * 62~91 30 6
 */