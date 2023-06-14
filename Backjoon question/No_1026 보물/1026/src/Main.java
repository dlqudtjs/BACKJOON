import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> rq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    pq.add(Integer.parseInt(st.nextToken()));
                    continue;
                }

                rq.add(Integer.parseInt(st.nextToken()));
            }
        }

        int answer = 0;
        while (!pq.isEmpty()) {
            answer += pq.poll() * rq.poll();
        }

        System.out.println(answer);
    }
}
