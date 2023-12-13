package christmas.model;

import christmas.constant.Menu;

import java.util.Map;

public class Result {
    private final Map<String, Integer> orders;
    private int totalSale;

    public Result(Map<String, Integer> orders) {
        this.orders = orders;
    }

    public int getTotalSale() {
        return totalSale;
    }

    // 총 주문 금액 산출
    public int totalAmount() {
        int totalAmount = 0;
        for (String key : orders.keySet()) {
            totalAmount += orders.get(key) * Menu.valueOf(key).getMONEY();
        }
        return totalAmount;
    }

    // 총 혜택 금액
    public void totalSale(int sale) {
        totalSale = sale;
    }
}
