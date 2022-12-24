import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int[][] APT = new int[15][15]; // 0호는 0으로 채워서 버린다. 1호수부터 세기때문에, 배열 초기화를 간단히 하기 위해

        for (int i = 0; i < 15; i++) {
            APT[i][1] = 1; // 층의 1호는(APT[0]) 모두 1로 시작
            APT[0][i] = i; // 0층의 호수는 1 ~ 14까지 채워야함
        }

        for (int i = 1; i < 15; i++) { // 2층부터 14층까지
            for (int j = 2; j < 15; j++) { // 호수 1 ~ 14까지, 0번 인덱스는 0으로 버려지고 1인덱스는 1로 채워졌기에 2부터 시작
                APT[i][j] = APT[i][j - 1] + APT[i - 1][j];

            }

        }

        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine()); // 층
            int n = Integer.parseInt(br.readLine()); // 호수

            System.out.println(APT[k][n]);
        }
    }
}

/*
 * 헷갈린 이유 : 처음 배열을 1호수는 1로 0층의 i호수는 i명으로 초기화 할때
 * 0호를 0으로 채우는 것을 이해하지 못해 버벅임.
 */
