package christmas.model;

import christmas.constant.Menu;

import java.util.Map;

public class Result {
    private final Map<String, Integer> orders;
    private int totalSale = 0;

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
            totalAmount += judgeMenu(orders.get(key), key);
        }
        return totalAmount;
    }

    // 해당 메뉴의 금액 반환
    public int judgeMenu(int count, String key) {
        int money = 0;
        for (Menu menu : Menu.values()) {
            if (menu.getNAME().equals(key)) {
                money = menu.getMONEY() * count;
                return money;
            }
        }
        return money;
    }

    // 총 혜택 금액
    public void totalSale(int sale) {
        totalSale = sale;
    }
}
