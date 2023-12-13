package christmas.model;

import christmas.constant.Menu;
import christmas.constant.XMasInfo;

import java.util.Map;

public class Event {
    DayNDate dayNDate;

    public Event(DayNDate dayNDate) {
        this.dayNDate = dayNDate;
    }

    // 크리스마스 디데이 할인
    public int xMas(int date) {
        int sale = 0;
        if (date <= 25) {
            sale = 1000 + (100 * (date - 1));
        }
        return sale;
    }

    // 평일 할인
    public int weekdaySale(int date, Map<String, Integer> order) {
        int count = 0;
        String day = dayNDate.returnDay(date);
        for (String weekday : XMasInfo.WEEKDAY) {
            if (day.equals(weekday)) {
                count = sortMenu(order, XMasInfo.WEEKDAY_MENU);
            }
        }
        return count * XMasInfo.WEEK_SALE;
    }

    // 주말 할인
    public int weekendSale(int date, Map<String, Integer> order) {
        int count = 0;
        String day = dayNDate.returnDay(date);
        for (String weekend : XMasInfo.WEEKEND) {
            if (day.equals(weekend)) {
                count = sortMenu(order, XMasInfo.WEEKEND_MENU);
            }
        }
        return count * XMasInfo.WEEK_SALE;
    }

    // 해당 타입 메뉴 개수 세기
    private int sortMenu(Map<String, Integer> order, String type) {
        int count = 0;
        for (Menu menu : Menu.values()) {
            if (menu.getTYPE().equals(type) && order.containsKey(menu.getNAME())) {
                count += order.get(menu.getNAME());
            }
        }
        return count;
    }

    // 별이 있는 날짜 특별 할인
    public int specialSale(int date) {
        for (int starDate : XMasInfo.STAR_DATE) {
            if (date == starDate) {
                return XMasInfo.STAR_SALE;
            }
        }
        return 0;
    }

    // 증정 이벤트 - 총 주문 금액 12만원 이상
    public String gift(int totalAmount) {
        if (totalAmount >= XMasInfo.GIFT_SALE) {
            return XMasInfo.GIFT + " 1개";
        }
        return "없음";
    }

    // 이벤트 배지
    public String badge(int saleAmount) {
        if (saleAmount >= 20000) {
            return "산타";
        } else if (saleAmount >= 10000) {
            return "트리";
        } else if (saleAmount >= 5000) {
            return "별";
        }
        return "없음";
    }
}
