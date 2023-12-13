package christmas.model;

public class Event {
    // 크리스마스 디데이 할인
    public int xMas(int date) {
        int sale = 0;
        if (date <= 25) {
            sale = 1000 + (100 * (date - 1));
        }
        return sale;
    }

}
