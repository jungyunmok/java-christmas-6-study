package christmas.model;

import christmas.constant.XMasInfo;

public class DayNDate {

    public String returnDay(int date) {
        int count = 0;
        String day;
        for (int i = 0; i < XMasInfo.DAYS.length; i++) {
            if (XMasInfo.DAYS[i].equals(XMasInfo.START_DAY)) {
                count = i + 1;
            }
        }
        day = XMasInfo.DAYS[(count % 7) - 1];
        return day;
    }
}
