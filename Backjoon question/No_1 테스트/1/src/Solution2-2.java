import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 0; test_case < T; test_case++) {
			int Answer = 0;
			PriorityQueue<Integer> left = new PriorityQueue<Integer>((o1, o2) -> o2 - o1);
			PriorityQueue<Integer> right = new PriorityQueue<Integer>();

			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				int x = Integer.parseInt(st.nextToken());
				(x < 0 ? left : right).add(x);
			}

			Answer = getAnswer(left, right, distance, 0);

			sb.append("Case #").append(test_case + 1).append("\n").append(Answer).append("\n");
		}

		System.out.println(sb);
	}

	public static int getAnswer(PriorityQueue<Integer> left, PriorityQueue<Integer> rigth, int distance, int current) {
		if (current == Integer.MAX_VALUE) {
			return 0;
		}

		PriorityQueue<Integer> tempLeft = new PriorityQueue<Integer>(left);
		PriorityQueue<Integer> tempRight = new PriorityQueue<Integer>(rigth);
		int Answer = 0;

		// 현재 위치의 딸기 수확
		if (current < 0) {
			while (!tempLeft.isEmpty()) {
				if (tempLeft.peek() == current) {
					tempLeft.poll();
					Answer++;
					continue;
				}

				break;
			}
		} else {
			while (!tempRight.isEmpty()) {
				if (tempRight.peek() == current) {
					tempRight.poll();
					Answer++;
					continue;
				}

				break;
			}
		}

		// left 와 right 거리 게산
		int leftDistnace = tempLeft.isEmpty() ? Integer.MAX_VALUE : Math.abs(tempLeft.peek() - current);
		int rightDistance = tempRight.isEmpty() ? Integer.MAX_VALUE : Math.abs(tempRight.peek() - current);

		// 거리가 distance 보다 크면 Integer.Max_VALUE로 설정
		leftDistnace = leftDistnace > distance ? Integer.MAX_VALUE : leftDistnace;
		rightDistance = rightDistance > distance ? Integer.MAX_VALUE : rightDistance;

		// 다음 딸기 수확 위치 계산
		int nextLeft = leftDistnace == Integer.MAX_VALUE ? Integer.MAX_VALUE : tempLeft.peek();
		int nextRight = rightDistance == Integer.MAX_VALUE ? Integer.MAX_VALUE : tempRight.peek();

		// 가까운 쪽과 먼 쪽을 모두 방문하여 더 많은 딸기 수확을 선택
		Answer += Math.max(getAnswer(tempLeft, tempRight, distance - leftDistnace, nextLeft),
				getAnswer(tempLeft, tempRight, distance - rightDistance, nextRight));

		return Answer;
	}
}