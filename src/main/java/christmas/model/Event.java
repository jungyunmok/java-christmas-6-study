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
        int sale = 0;
        String day = dayNDate.returnDay(date);
        for (String weekday : XMasInfo.WEEKDAY) {
            if(day.equals(weekday)) {
                sale = sortMenu(order, XMasInfo.WEEKDAY_MENU);
            }
        }
        return sale * 2023;
    }

    // 주말 할인
    public int weekendSale(int date, Map<String, Integer> order) {
        int sale = 0;
        String day = dayNDate.returnDay(date);
        for (String weekend : XMasInfo.WEEKEND) {
            if(day.equals(weekend)) {
                sale = sortMenu(order, XMasInfo.WEEKEND_MENU);
            }
        }
        return sale * 2023;
    }

    // 해당 타입 메뉴 개수 세기
    private int sortMenu(Map<String, Integer> order, String type) {
        int count = 0;
        for(Menu menu : Menu.values()) {
            if(menu.getTYPE().equals(type) && order.containsKey(menu.getNAME())) {
                count += order.get(menu.getNAME());
            }
        }
        return count;
    }
}
