import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 멀티탭 구멍의 수
        int K = Integer.parseInt(st.nextToken()); // 전기 용품의 사용횟수

        int[] sequence = new int[K + 1];

        // sequenceList는 sequence을 카피한 후 가장 나중에 출현한 장치를 찾기위해 사용된다.
        ArrayList<Integer> sequenceList = new ArrayList<>();
        sequenceList.add(0); // sequence배열이 1부터 시작하기 때문에 처음에 0을 넣는다.

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= K; i++) {
            sequence[i] = Integer.parseInt(st.nextToken()); // 사용 순서 입력
            sequenceList.add(sequence[i]);
        }

        ArrayList<Integer> used = new ArrayList<>(); // 현재 사용되는 멀티탭
        int removeCnt = 0; // sequenceList를 자를 때 사용
        int answer = 0;

        for (int i = 1; i <= K; i++) {
            if (used.contains(sequence[i])) { // 현재 사용 순서가 이미 꽂혀있을 경우
                continue;
            }

            if (used.size() < N) {
                used.add(sequence[i]); // 멀티탭이 구멍이 남아있을 경우
                continue;

            } else {
                int lastIndex = 0;
                boolean check = false; // 앞으로 사용되지 않을 장치를 뽑았다면 check를 true로 바꿔준다.

                for (int j = 0; j < N; j++) {
                    int temp = used.get(j); // 현재 꽂혀있는 전기용품

                    // 나중에 출현한 장치를 찾기위해 sequenceList.indexOf()를 사용해야 한다. (가장 먼저 나오는 인덱스 반환)
                    // 그러기 위해서는 현재 순서까지 sequenceList의 앞부분을 잘라낸 후 indexOf 메서드를 이용해야 한다.
                    // (그렇지 않으면 맨 순서의 장치가 계속 반환됨)
                    // removeCnt는 현재까지 얼마나 잘랐는 지 나타낸다. 그 후 현재 순서인 i와 빼줌으로써 현재 순서까지 앞부분을 자를 수 있다.
                    for (int k = (i - removeCnt) - 1; k > 0; k--) {
                        sequenceList.remove(1); // index 0은 사용하지 않는다.
                        removeCnt++;
                    }

                    if (!sequenceList.contains(temp)) {
                        used.set(j, sequence[i]);
                        check = true; // 장치를 뽑고 교체했기 때문에 check를 true로 하여 아래에서 한 번더 바꾸는 것을 방지
                        break;

                    } else {
                        // 앞서 앞부분을 도려낸 sequenceList에서 indexOf(temp)를 함으로써 가장 늦게 출현하는 장치(temp)를 찾을 수 있다.
                        lastIndex = lastIndex > sequenceList.indexOf(temp) ? lastIndex : sequenceList.indexOf(temp);
                    }
                }

                if (!check) {
                    // used.set(인덱스, 바꿀 값), indexOf() (값의 맨 앞부분 인덱스 반환)
                    // 현재 순서의 앞부분 까지 잘라낸 sequenceList에서 get(lastIndex)를 함으로써 가장 늦게 출현한 장치를 뽑는다.
                    // 뽑을 장치를 for문의 증감값을 이용하지 못해 다소 복잡해졌다.
                    used.set(used.indexOf(sequenceList.get(lastIndex)), sequence[i]);
                }

                answer++;
            }
        }

        System.out.println(answer);
    }
}

/*
 * 알고리즘 로직은 다음과 같다
 * 1 멀티탭에 현재 사용 순서의 장치가 꽂혀있다면 continue
 * (구멍이 비어있는 경우의 if문을 먼저 실행할 경우 멀티탭에 중복된 장치가 들어간다)
 * 
 * 2 멀티탭에 구멍이 비어있는 경우 continue
 * 
 * 3 만약 멀티탭의 자리가 없으며, 꽂혀있는 장치가 아니라면
 * 3.1 앞으로 사용되지 않을 장치를 뽑는다.
 * 3.2 멀티탭에 꼽혀있는 장치들로부터 가장 늦게 출현하는 장치를 뽑는다.
 * 3 8
 * 1 2 3 4 3 2 1 3 <- 의 조건일 경우 가장 마지막에 사용되는 3을 뽑는게 아니라
 * 1 2 3 중 가장 나중에 출현하는 1을 뽑는 것이다. (이부분에서 시간을 많이 잡아먹음)
 */