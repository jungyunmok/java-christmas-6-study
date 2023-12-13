package christmas.constant;

public class XMasInfo {
    // 총 요일
    public static final String[] DAYS = {"일", "월", "화", "수", "목", "금", "토"};
    // 이번달 시작 요일
    public static final String START_DAY = "금";
    // 평일
    public static final String[] WEEKDAY = {"일", "월", "화", "수", "목"};
    // 주말
    public static final String[] WEEKEND = {"금", "토"};
    // 평일 할인 적용 메뉴
    public static final String WEEKDAY_MENU = "디저트";
    // 주말 할인 적용 메뉴
    public static final String WEEKEND_MENU = "메인";
    // 평일, 주말 할인 금액
    public static final int WEEK_SALE = 2023;
    // 특별 할인 날짜 - 별 있는 날짜
    public static final int[] STAR_DATE = {3, 10, 17, 24, 25, 31};
    // 특별 할인 금액
    public static final int STAR_SALE = 1000;
    // 증정 이벤트 충족 금액
    public static final int GIFT_SALE = 120000;
    // 증정 이벤트 물품
    public static final String GIFT = "샴페인";
}
