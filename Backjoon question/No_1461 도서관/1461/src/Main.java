import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int last = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken()); // 들 수 있는 책의 개수

        PriorityQueue<Integer> left = new PriorityQueue<>();
        PriorityQueue<Integer> right = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        int leftMax = 0;
        int rightMax = 0;
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(st.nextToken());

            (input < 0 ? left : right).add(Math.abs(input));

            if (input < 0) {
                leftMax = Math.max(leftMax, Math.abs(input));
            } else {
                rightMax = Math.max(rightMax, input);
            }
        }

        // 왼쪽, 오른쪽 중 가장 긴 거리가 더 작은 쪽 먼저 탐색한다.
        // 가장 거리가 먼 쪽은 마지막에 탐색하여 돌아오지 않기 위해서
        int distance = 0;
        if (leftMax > rightMax) {
            distance = getDistance(right, m);
            distance += getDistance(left, m);
        } else {
            distance = getDistance(left, m);
            distance += getDistance(right, m);
        }

        // 가장 마지막에 탐색한 거리는 빼준다.(*2 처리가 되어있음)
        System.out.println(distance - last);
    }

    private static int getDistance(PriorityQueue<Integer> direct, int m) {
        int distance = 0;

        // 그 방향에 들 수 있는 책의 수를 나눴을 때 맞아 떨어지지 않으면 한 번 더 가야하기 미리 갔다온다.
        int max = 0;
        if (direct.size() % m != 0) {
            int cnt = direct.size() % m;

            for (int i = 0; i < cnt; i++) {
                max = direct.poll();
                last = max;
            }

            distance += max * 2;
        }

        // 맞아 떨이지지 않은 거리를 갔다 왔을 때, 더 이상 갈 곳이 없다면 return
        int cnt = direct.size() / m;
        if (cnt == 0) {
            return distance;
        }

        // 위에서 나머지 만큼 갔다 왔기 때문에 몫만큼 딱 떨어지게 갔다올 수 있다.
        // 몫만큼 반복하며 들 수 있는 만큼 poll을 해주며 가장 마지막에 뺀 값을 last에 계속 갱신해준다.
        // 따라서 for문이 끝난 마지막 값(가장 먼 값)을 *2 해준다.
        for (int i = 0; i < cnt; i++) {
            for (int j = 0; j < m; j++) {
                max = direct.poll();
                last = max;
            }

            distance += max * 2;
        }

        return distance;
    }
}
