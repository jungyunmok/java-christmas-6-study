package christmas.constant;

public enum Menu {
    AP1("에피타이저","양송이수프", 6000),
    AP2("에피타이저","타파스", 5500),
    AP3("에피타이저","시저샐러드", 8000),
    MN1("메인","티본스테이크", 55000),
    MN2("메인","바비큐립", 54000),
    MN3("메인","해산물파스타", 35000),
    MN4("메인","크리스마스파스타", 25000),
    DS1("디저트","초코케이크", 15000),
    DS2("디저트","아이스크림", 5000),
    DR1("음료","제로콜라", 3000),
    DR2("음료","레드와인", 60000),
    DR3("음료","샴페인", 25000);

    private final String TYPE;
    private final String NAME;
    private final int MONEY;

    Menu(String TYPE, String NAME, int MONEY) {
        this.TYPE = TYPE;
        this.NAME = NAME;
        this.MONEY = MONEY;
    }

    public String getTYPE() {
        return TYPE;
    }

    public String getNAME() {
        return NAME;
    }

    public int getMONEY() {
        return MONEY;
    }
}