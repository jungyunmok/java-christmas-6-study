package christmas.view;

import java.util.Map;

public class OutputView {
    // 주문 메뉴 출력
    public void printMenu(Map<String, Integer> orders) {
        System.out.println("12월 3일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
        System.out.println("(이벤트는 10,000원 이상 주문부터 적용됩니다.)\n");
        System.out.println("<주문 메뉴>");
        for (String key : orders.keySet()) {
            System.out.println(key + " " + orders.get(key) + "개");
        }
    }
}
