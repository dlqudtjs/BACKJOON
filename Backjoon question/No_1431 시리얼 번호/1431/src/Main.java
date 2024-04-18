import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Word> pq = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            pq.add(new Word(br.readLine()));
        }

        for (int i = 0; i < n; i++) {
            sb.append(pq.poll().str).append("\n");
        }

        System.out.println(sb);
    }
}

class Word implements Comparable<Word> {
    String str;
    int score;

    public Word(String str) {
        this.str = str;
        this.score = 0;

        calculateScore();
    }

    private void calculateScore() {
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                score += c - '0';
            }
        }
    }

    @Override
    public int compareTo(Word o1) {
        if (this.str.length() == o1.str.length()) {
            if (this.score == o1.score) {
                return this.str.compareTo(o1.str);
            }

            return this.score - o1.score;
        }

        return this.str.length() - o1.str.length();
    }
}
