import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Long> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            pq.add(Long.parseLong(br.readLine()));
        }

        long sum = 0;

        while (pq.size() > 1) { // queue에 2개 이상 값이 들어있어야 비교가 가능하다.
            long a = pq.poll();
            long b = pq.poll();

            sum += a + b; // 합칠 때 N번의 비교의 누적합이다.
            pq.add(a + b); // 합친 후 queue에 넣어준다.
        }

        System.out.println(sum);
    }
}
