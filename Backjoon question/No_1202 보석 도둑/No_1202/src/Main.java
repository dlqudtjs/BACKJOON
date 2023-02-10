import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Jewelry {
    int m; // 무게
    int v; // 가격

    Jewelry(int m, int v) {
        this.m = m;
        this.v = v;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 보석의 수
        int K = Integer.parseInt(st.nextToken()); // 가방의 수

        Jewelry[] jewelrys = new Jewelry[N]; // N개의 보석 수와 보석의 무게, 가격
        int[] bags = new int[K]; // 가방의 수

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken()); // 무게
            int V = Integer.parseInt(st.nextToken()); // 가격

            jewelrys[i] = new Jewelry(M, V);
        }

        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(jewelrys, (e1, e2) -> { // 보석무게 오름차순 (작은 가방부터 채워야하기 때문)
            return e1.m - e2.m;
        });

        Arrays.sort(bags); // 가방무게 오름차순

        int index = 0;
        long answer = 0;
        PriorityQueue<Jewelry> pq = new PriorityQueue<>((e1, e2) -> {
            return e2.v - e1.v; // 보석가격 내림차순
        });

        for (int i = 0; i < K; i++) {

            while (index < N) {
                if (jewelrys[index].m <= bags[i]) {
                    pq.add(jewelrys[index]); // jewels 주소를 pq에 삽입
                    index++;
                } else {
                    break;
                }
            }

            /*
             * 담을 수 있는 보석을 한 가방에 모두 담는다면 다음 가방이 담을 수 없다고 생각이 들어 오래걸렸다.
             * 하지만 가방개념은 현재 가방이(bags[i])가 담을 수 있는 보석이며, 그 보석을 pq에 담게된다.
             * (pq는 공동가방이라고 생각하였음) 그렇게 while이 끝나고 가장 비싼 보석을 pq에 넣게된다.
             * 그 후 가방 또한 오름차순이기 때문에 앞선 가방이 담을 수 있는 건 현재 가방도 담을 수 있다는 의미이기에
             * while문에서 담지 못하더라도 앞에서 미리 담아뒀기 때문에 aswer += pq.poll을 하게되면 상관이 없게된다.
             * (pq의 정렬 기준을 보석의 가격 내림차순으로 해놨기 때문에 가능하다)
             */

            if (!pq.isEmpty()) {
                answer += pq.poll().v; // pq는 jewels의 주소를 갖고 있기에 해당 배열의 [1]인덱스를 가져온다.
            }
        }

        System.out.println(answer);
    }

}
