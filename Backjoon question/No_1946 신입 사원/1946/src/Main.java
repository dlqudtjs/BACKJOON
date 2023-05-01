import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int testCase = 0; testCase < T; testCase++) {
            int N = Integer.parseInt(br.readLine());
            Score[] scores = new Score[N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int paperScore = Integer.parseInt(st.nextToken());
                int interViewScore = Integer.parseInt(st.nextToken());

                // 주어진 paperScore를 활용해 정렬한다.
                scores[paperScore - 1] = new Score(paperScore, interViewScore);
            }

            int memberCnt = getMaximumMemberCnt(scores);

            sb.append(memberCnt).append('\n');
        }

        System.out.println(sb);
    }

    public static int getMaximumMemberCnt(Score[] scores) {
        int memberCnt = 1;
        // 가장 InterViewScore를 저장한다.
        int minScore = scores[0].getInterViewScore();

        // 앞에 수를 정렬해놨기에 뒤에 있는 수만 검사하면 된다.
        // 처음엔 다 확인했지만 minScore를 따로 저장해놨기 때문에 2중 for문을 사용하지 않아도 된다.
        for (int i = 1; i < scores.length; i++) {
            if (scores[i].getInterViewScore() < minScore) {
                minScore = scores[i].getInterViewScore();
                memberCnt++;
            }
        }

        return memberCnt;
    }
}

class Score {
    private int paperScore;
    private int interViewScore;

    public Score(int paperScore, int interViewScore) {
        this.paperScore = paperScore;
        this.interViewScore = interViewScore;
    }

    public void setInterViewScore(int interViewScore) {
        this.interViewScore = interViewScore;
    }

    public void setPaperScore(int paperScore) {
        this.paperScore = paperScore;
    }

    public int getInterViewScore() {
        return interViewScore;
    }

    public int getPaperScore() {
        return paperScore;
    }
}
