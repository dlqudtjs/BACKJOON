import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> dualNum = new PriorityQueue<>(Collections.reverseOrder()); // 양수 queue
        PriorityQueue<Integer> negativeQntty = new PriorityQueue<>(); // 음수 queue

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num > 0) {
                dualNum.add(num); // 양수 추가 (0은 음수로 분류)
            } else {
                negativeQntty.add(num); // 음수 추가
            }
        }

        int sum = 0;

        while (!dualNum.isEmpty()) {
            int temp = dualNum.poll();

            if (!dualNum.isEmpty()) {
                int next = dualNum.peek();

                // 1은 예외로 더하는 게 더 크기 때문에 삼항연산자로 계산하였다. (if문 대신)
                temp = (temp * next) > (temp + next) ? temp * dualNum.poll() : temp + dualNum.poll();
            }

            sum += temp;
        }

        while (!negativeQntty.isEmpty()) {
            int temp = negativeQntty.poll();

            if (!negativeQntty.isEmpty()) {
                int next = negativeQntty.peek();
                temp = (temp * next) > (temp + next) ? temp * negativeQntty.poll() : temp + negativeQntty.poll();
            }

            sum += temp;
        }

        System.out.println(sum);
    }
}

/*
 * 양수, 음수를 나누기 위해 각각 pq를 만들었다.
 * 양수의 범위는 n > 0 으로 잡았다. 0은 곱하면 0이 되며, 음수를 0으로 상쇄할 수 있기때문에 0은 음수에 넣었다.
 * 양수는 내림차순으로 큰 수끼리 곱했으며, 2 * 1 < 2 + 1이 더 크므로 1이 나오면 그냥 더했다. (32번줄)
 * 음수는 오름차순으로 작은 수 끼리 곱하여 가장 큰 수로 만들었다.
 */