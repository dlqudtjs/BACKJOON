import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int x = ((int) Math.pow(2, n)) + 1;
        System.out.println((int) Math.pow(x, 2));
    }

    /*
     * 초기 상태 : 변에 점이 2개
     * 1번 : 한 변에 점이 3개 있다.
     * 2번 : 한 변에 점이 5개 있다.
     * 3번 : 한 변에 점이 9개 있다.
     * 즉, 1 2 4으로 올라간다.
     * 따라서, 2^n 승 + 1 (한 변에 점의 개수)를 구한 후
     * 제곱해주면 값이 나온다. (정사각형이므로 2차원으로 비례하여 증가하기 때문)
     */
}
