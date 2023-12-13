package christmas.view;

import java.text.DecimalFormat;
import java.util.Map;

public class OutputView {
    // 주문 메뉴 출력
    public void printMenu(Map<String, Integer> orders) {
        System.out.println("12월 3일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
        System.out.println("(이벤트는 10,000원 이상 주문부터 적용됩니다.)");
        System.out.println("\n<주문 메뉴>");
        for (String key : orders.keySet()) {
            System.out.println(key + " " + orders.get(key) + "개");
        }
    }

    // 할인 전 총 주문 금액 출력
    public void printTotalAmount(int totalAmount) {
        DecimalFormat df = new DecimalFormat("###,###");
        System.out.println("\n<할인 전 총주문 금액>");
        System.out.println(df.format(totalAmount) + "원");
    }
}
