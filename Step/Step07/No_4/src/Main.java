import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int A = Integer.parseInt(st.nextToken());
    int B = Integer.parseInt(st.nextToken());
    int V = Integer.parseInt(st.nextToken());

    // 올라가는 거리 - 미끄러지는 거리 = 하루에 올라가는 거리
    /*
     * V / A - B로 몫을 구하게 된다면 하루 사이클로 계산되기 때문에 아침에 목적지 까지 가더라도 밤에 미끄러져
     * 내려오기 때문에 하루 더 올라가게 된다.
     * 이를 보완하기 위해 밤에 미끄러지는 것까지 계산에 포함하기 위해 V - B를 한다. (한 사이클로 계산하기 위해)
     */
    int day = (V - B) / (A - B);

    // 나머지가 0이 아니라면 하루 더 올라가야 하기 때문에 day에 1을 더해준다.
    if ((V - B) % (A - B) != 0) {
      day++;
    }

    System.out.println(day);
  }
}