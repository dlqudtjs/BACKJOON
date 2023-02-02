import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[1001]; // 수의 범위
        int N = Integer.parseInt(br.readLine()); // 들어올 수의 개수

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 들어올 수를 인덱스로 사용하여 해당 인덱스의 값을 1 증가시킨다.
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            arr[num]++;
        }

        int prev = 0;
        int sum = 0;

        // 들어온 수의 개수를 저장한 arr를 한 번 순회하며 해당 인덱스의 개수만큼 출력한다
        // ex) 0번 인덱스 1, 1번 인덱스 3, 2번 인덱스 2의 배열이라면
        // 배열을 순회하며 0번 인덱스 1번 출력, 1번 인덱스 3번 출력 2번 인덱스 2번 출력한다.
        for (int i = 1; i < arr.length; i++) { // 조건 걸리는 시간이 1 <= 이기때문에 1부터 시작

            // 해당 인덱스의 개수가 없다면 출력하지 않는다.
            while (arr[i]-- > 0) {
                // 이전 시간과 현재 걸린 시간을 더해준다.
                sum += prev + i;

                // 지금까지 걸린 누적시간을 더해준다.
                prev += i;
            }
        }

        System.out.println(sum);
    }
}
