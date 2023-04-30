import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int LAST_WEEK = 14;
    static final int INCREASE_STOCK_COUNT = 3;
    static final int DECREASE_STOCK_COUNT = 3;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int initMoney = Integer.parseInt(br.readLine());

        Person junhyun = new Person(new Money(initMoney));
        Person seongmin = new Person(new Money(initMoney));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] stocks = new int[LAST_WEEK + 1];

        // 주식값 입력
        for (int i = 1; i <= LAST_WEEK; i++) {
            stocks[i] = Integer.parseInt(st.nextToken());
        }

        int currentIncreaseCount = 0;
        int currentDecreaseCount = 0;

        // 1일부터 LAST_WEEK 까지
        for (int week = 1; week <= LAST_WEEK; week++) {
            // 첫 날이 아니며, 전날 대비 가격이 상승했다면 currentIncreaseCount를 올려준다. (Decrease 초기화)
            if (week != 1 && stocks[week] > stocks[week - 1]) {
                currentIncreaseCount++;
                currentDecreaseCount = 0;
            }

            // 첫 날이 아니며, 전날 대비 가격이 하락했다면 currentDecreasecount를 올려준다. (Increase 초기화)
            if (week != 1 && stocks[week] < stocks[week - 1]) {
                currentDecreaseCount++;
                currentIncreaseCount = 0;
            }

            // 준현이가 주식을 살 수 있다면 가능한 모두 구매한다.
            junhyun.addStockCount(junhyun.getMoney() / stocks[week]);
            junhyun.setMoney(junhyun.getMoney() % stocks[week]);

            // DECREASE_STOCK_COUNT 만큼 하락장이라면 상민이가 구매할 수 있는 주식의 수를 매수한다.
            if (currentDecreaseCount >= DECREASE_STOCK_COUNT) {
                // 성민이 돈 / 현재 주식 최대한 주식을 매수한다.
                seongmin.addStockCount(seongmin.getMoney() / stocks[week]);
                // 성민이의 돈을 차감한다.
                seongmin.setMoney(seongmin.getMoney() % stocks[week]);
            }

            // INCREASE_STOCK_COUNT 만큼 상승장이라면 가능한 상민이의 모든 주식을 매도한다.
            if (currentIncreaseCount >= INCREASE_STOCK_COUNT) {
                // 현준이의 주식 수를 차감한다.
                seongmin.saleOfStock(seongmin.getStockCount(), stocks[week]);
            }
        }

        junhyun.saleOfStock(junhyun.getStockCount(), stocks[LAST_WEEK]);
        seongmin.saleOfStock(seongmin.getStockCount(), stocks[LAST_WEEK]);

        winner(junhyun, seongmin);
    }

    public static void winner(Person person1, Person person2) {
        if (person1.getMoney() > person2.getMoney()) {
            System.out.println("BNP");
            return;
        }

        if (person1.getMoney() < person2.getMoney()) {
            System.out.println("TIMING");
            return;
        }

        if (person1.getMoney() == person2.getMoney()) {
            System.out.println("SAMESAME");
            return;
        }
    }
}

class Person {
    private Money money;
    private int stockCount = 0;

    public Person(Money money) {
        this.money = money;
    }

    public void setMoney(int value) {
        this.money.setValue(value);
    }

    public int getMoney() {
        return this.money.getValue();
    }

    public void addStockCount(int value) {
        this.stockCount += value;
    }

    public int getStockCount() {
        return this.stockCount;
    }

    public void saleOfStock(int count, int price) {
        if (count > this.stockCount) {
            System.out.println("보유중인 주식의 수보다 큰 값을 입력하셨습니다.");
            return;
        }

        this.stockCount -= count;
        this.money.setValue(money.getValue() + (count * price));
    }
}

class Money {
    private int value;

    public Money(int value) {
        this.value = value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}