package christmas.controller;

import christmas.constant.XMasInfo;
import christmas.model.Judgement;
import christmas.view.InputView;

public class MainController {
    InputView inputView;
    Judgement judgement;

    // 날짜 받기
    public void getDate() {
        try{
            String strDate = inputView.readDate();
            int date = judgement.checkInt(strDate);
            judgement.checkRange(XMasInfo.END_DATE, date);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
            getDate();
        }
    }
}
