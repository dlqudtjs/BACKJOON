import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // time[][0]은 시작시점, time[][1]은 종료시점을 의미한다.
        int[][] time = new int[N][2];
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }

        // 끝나는 시간을 기준으로 정렬하기 위해 compare() 메소드를 재정의한다.
        Arrays.sort(time, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {

                // 끝나는 시간이 같다면 시작 시간이 빠른 순으로 정렬한다.
                // (1,4 4,8, 8,8 같은 경우 1,4 4,8, 8,8이 선택되어야 하지만 1,4 8,8 4,8이 선택되는 경우가 생긴다.)
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });

        int count = 0;
        int prev_end_time = 0;

        for (int i = 0; i < N; i++) {
            // 이전 회의가 끝난 시간이 다음 회의의 시작 시간보다 작거나 같다면
            // 다음 회의를 선택할 수 있다.
            if (prev_end_time <= time[i][0]) {
                count++;
                prev_end_time = time[i][1];
            }
        }

        System.out.println(count);
    }
}
