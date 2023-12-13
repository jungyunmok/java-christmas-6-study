package christmas.controller;

import christmas.constant.XMasInfo;
import christmas.model.DayNDate;
import christmas.model.Event;
import christmas.model.Judgement;
import christmas.model.Result;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.Map;

public class MainController {
    InputView inputView;
    Judgement judgement;
    Result result;
    DayNDate dayNDate;
    Event event;
    OutputView outputView;

    public MainController() {
        inputView = new InputView();
        judgement = new Judgement();
        dayNDate = new DayNDate();
        event = new Event(dayNDate);
        outputView = new OutputView();
    }

    // 날짜 받기
    public void getDate() {
        try {
            String strDate = inputView.readDate();
            int date = judgement.checkInt(strDate);
            judgement.checkRange(XMasInfo.END_DATE, date);
            getOrder(date);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
            getDate();
        }
    }

    // 주문 받기
    public void getOrder(int date) {
        try {
            String order = inputView.readMenu();
            Map<String, Integer> orders = judgement.checkDuplication(order);
            judgement.checkMenu(orders);
            judgement.checkDrink(orders);
            result = new Result(orders);
            int totalAmount = result.totalAmount();
            outputView.printMenu(orders);
            outputView.printTotalAmount(totalAmount);
            applySale(date, orders, totalAmount);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            getOrder(date);
        }
    }

    // 이벤트 내역 적용하기
    public void applySale(int date, Map<String, Integer> orders, int totalAmount) {
        int totalSale = 0;
        int gift = outputView.printGift(event.gift(totalAmount));
        outputView.printEvent();
        totalSale += judgeSale("크리스마스 디데이 할인", event.xMas(date));
        totalSale += judgeSale("평일 할인", event.weekdaySale(date, orders));
        totalSale += judgeSale("주말 할인", event.weekendSale(date, orders));
        totalSale += judgeSale("특별 할인", event.specialSale(date));
        totalSale += judgeSale("증정 이벤트", gift);
        result.totalSale(totalSale);
        if (totalSale == 0) {
            System.out.println("없음");
        }
        outputView.printTotalSale(totalSale);
        outputView.printFinalAmount(totalAmount, totalSale - gift);
        outputView.printBadge(event.badge(totalSale));
    }

    // 할인 내역이 있으면 출력하기
    public int judgeSale(String message, int saleAmount) {
        if (saleAmount > 0) {
            outputView.eventDetail(message, saleAmount);
        }
        return saleAmount;
    }
}
