package christmas.model;

public class Judgement {
    // 문자열 인트 변환
    public int checkInt(String strNumber) {
        int number = 0;
        try {
            number = Integer.parseInt(strNumber);
        }catch (NumberFormatException e) {
            System.out.println("[ERROR] 올바른 숫자를 입력해주세요.");
            throw new IllegalArgumentException(e);
        }
        return number;
    }
}
