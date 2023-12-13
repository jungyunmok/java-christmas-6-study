package christmas.model;

import christmas.constant.Menu;

import java.util.HashMap;
import java.util.Map;

public class Judgement {
    // 문자열 인트 변환
    public int checkInt(String strNumber) {
        int number = 0;
        try {
            number = Integer.parseInt(strNumber);
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException(e);
        }
        return number;
    }

    // 숫자 입력 범위 확인
    public void checkRange(int max, int number) {
        if(number < 1 || number > max) {
            throw new IllegalArgumentException();
        }
    }

    // 메뉴-개수 중복 확인
    public Map<String, Integer> checkDuplication(String order) {
        Map<String, Integer> orders = new HashMap<>();
        String[] tempOrder = order.split(",");
        for(String str : tempOrder) {
            String key = str.split("-")[0];
            int value = checkInt(str.split("-")[1]);
            if(orders.containsKey(key)) {
                System.out.println("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
                throw new IllegalArgumentException();
            }
            orders.put(key, value);
        }
        return orders;
    }

    // 존재하는 메뉴인지 확인
    public void checkMenu(Map<String, Integer> orders) {
        int count = 0;
        for(Menu menu : Menu.values()) {
            if(orders.containsKey(menu.getNAME())) {
                count++;
            }
        }
        if(count != orders.size()) {
            System.out.println("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            throw new IllegalArgumentException();
        }
    }

    // 음료만 주문 시 주문 불가
    public void checkDrink(Map<String, Integer> orders) {
        for(String key : orders.keySet()) {
            if(Menu.valueOf(key).getTYPE().equals("음료")) {
                System.out.println("[ERROR] 음료만 주문할 수 없습니다.");
                throw new IllegalArgumentException();
            }
        }
    }
}
