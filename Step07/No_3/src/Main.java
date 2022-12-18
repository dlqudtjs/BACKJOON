import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int x = Integer.parseInt(br.readLine());
    br.close();

    int cross_count = 1;
    int prev_cross_count_sum = 0;
    int t = 0; // 분자 값

    while (true) {
      // 이전 값과 해당 대각선의 개수를 이용하여 x의 범위를 추측
      if (x <= prev_cross_count_sum + cross_count) {

        // (분모 + 분자) - (x - 이전 대각선의 개수의 합) = 분자
        t = (cross_count + 1) - (x - prev_cross_count_sum);

        if (cross_count % 2 == 1) { // 홀수 부터 계산

          // (cross_count + 1) <- 분모 + 분자 값이기에 t인 분자를 빼주면 분모가 나온다.
          System.out.println(t + "/" + ((cross_count + 1) - t));
        } else {

          // 짝수 부터는 분모와 분자의 위치가 바뀌어야 한다.
          System.out.println(((cross_count + 1) - t) + "/" + t);
        }

        break;
      } else {
        prev_cross_count_sum += cross_count;
        cross_count++;
      }
    }
  }
}
