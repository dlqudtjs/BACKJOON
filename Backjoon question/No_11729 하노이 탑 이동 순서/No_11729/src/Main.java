import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int count;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        hanoi(N, 1, 2, 3); // 1 = A, 2 = B, 3 = C (A = 시작점, B는 sub, C는 도착지)

        System.out.println(count);
        System.out.print(sb);
    }

    static void hanoi(int N, int start, int sub, int to) {
        count++;

        /*
         * 원판이 하나 일 때 옮긴다. 진행 순서는 다음과 같다 (완성이 아니라 진행 방향)
         * ex) 2개의 원판을 옮길 땐 1 -> 2, 1 -> 3, 2 -> 3으로 원판을 2로 옮긴다.
         * 3개의 원판을 옮길 땐 1 -> 3, 1 -> 2, 3 -> 2 순으로 진행된다.
         * 이와 같이 처음 원판이 하나 일 때 옮기는 곳이 다른 이유는 함수를 호출한 곳 즉 40, 42번 함수의 sub, to 값을 다르게 줬기
         * 때문이다. 첫 시작이 홀수는 1 -> 3으로 짝수는 1 -> 2로 옮긴다고 보면 된다. 옮기는 위치가 다른 이유는 아래에서 설명한다.
         */
        if (N == 1) {
            sb.append(start).append(' ').append(to).append('\n');
            return;
        }

        /*
         * 1. start -> sub로 N - 1(예시에서 1,2,3,4,5중 n-1(1,2,3,4)를 sub로 옮긴다.) 40 번줄
         * 2. start에 남은 맨아래 원판인 5 하나를 to로 옮긴다 41 번줄
         * 3. sub -> to로 N - 1(위처럼 진행 됐다면 N - 1(1,2,3,4)을 5로 옮기면 된다.) 42 번줄
         * 간단하게 본다면 맨 아래 원판을 빼고 sub로 옮긴 후 맨 아래 원판을 to로 옮긴 다음 나머지 sub 원판을 to로 옮기면 끝난다.
         */
        hanoi(N - 1, start, to, sub);
        sb.append(start).append(' ').append(to).append('\n');
        hanoi(N - 1, sub, start, to);
    }
}

// https://hyunipad.tistory.com/89 참고 블로그
