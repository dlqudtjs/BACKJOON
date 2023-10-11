import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2 {
	static boolean[][] confetti;
	static int white, blue = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());

		confetti = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < n; j++) {
				// token 값이 1일 때 True
				confetti[i][j] = (st.nextToken().charAt(0) - 48) == 1;
			}
		}

		divied(0, 0, n);

		System.out.println(white + "\n" + blue);
	}

	static void divied(int startY, int startX, int size) {
		if (check(startY, startX, size)) {
			// true의 경우 파란색 종이를 더해줌
			if (confetti[startY][startX]) {
				blue++;
			} else {
				white++;
			}

			return;
		}

		int diviedSize = size / 2;

		// 1사분면
		divied(startY, startX + diviedSize, diviedSize);

		// 2사분면
		divied(startY, startX, diviedSize);

		// 3사분면
		divied(startY + diviedSize, startX, diviedSize);

		// 4사분면
		divied(startY + diviedSize, startX + diviedSize, diviedSize);
	}

	static boolean check(int startY, int startX, int size) {
		boolean color = confetti[startY][startX];

		for (int i = startY; i < startY + size; i++) {
			for (int j = startX; j < startX + size; j++) {
				// 시작 위치의 색종이와 탐색 중인 색종이가 같지 않을 경우
				if (color != confetti[i][j]) {
					return false;
				}
			}
		}

		return true;
	}
}
