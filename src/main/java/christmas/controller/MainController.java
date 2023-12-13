package christmas.controller;

import christmas.constant.XMasInfo;
import christmas.model.Judgement;
import christmas.model.Result;
import christmas.view.InputView;

import java.util.Map;

public class MainController {
    InputView inputView;
    Judgement judgement;
    Result result;

    // 날짜 받기
    public void getDate() {
        try {
            String strDate = inputView.readDate();
            int date = judgement.checkInt(strDate);
            judgement.checkRange(XMasInfo.END_DATE, date);
            getOrder();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
            getDate();
        }
    }

    // 주문 받기
    public void getOrder() {
        try {
            String order = inputView.readMenu();
            Map<String, Integer> orders = judgement.checkDuplication(order);
            judgement.checkMenu(orders);
            judgement.checkDrink(orders);
            result = new Result(orders);
            // 그 다음 로직 추가할것!
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            getOrder();
        }
    }
}
