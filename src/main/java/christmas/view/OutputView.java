package christmas.view;

import christmas.constant.XMasInfo;

import java.text.DecimalFormat;
import java.util.Map;

public class OutputView {
    DecimalFormat df = new DecimalFormat("###,###");

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
        System.out.println("\n<할인 전 총주문 금액>");
        System.out.println(df.format(totalAmount) + "원");
    }

    // 증정 메뉴 출력
    public int printGift(int gift) {
        System.out.println("\n<증정 메뉴>");
        if(gift > 0) {
            System.out.println(XMasInfo.GIFT + " 1개");
            return gift;
        }
        System.out.println("없음");
        return 0;
    }

    // 혜택 내역 출력
    public void printEvent() {
        System.out.println("\n<혜택 내역>");
    }

    // 혜택 디테일
    public void eventDetail(String message, int money) {
        System.out.println(message + ": -" + money);
    }

    // 총 혜택 금액 출력
    public void printTotalSale(int totalSale) {
        System.out.println("\n<총혜택 금액>");
        System.out.println("-" + df.format(totalSale) + "원");
    }

    // 할인 후 예상 결제 금액 출력
    public void printFinalAmount(int totalAmount, int totalSale) {
        System.out.println("\n<할인 후 예상 결제 금액>");
        System.out.println(df.format(totalAmount - totalSale) + "원");
    }

    // 배지 출력
    public void printBadge(String badge) {
        System.out.println("\n<12월 이벤트 배지>");
        System.out.println(badge);
    }
}
