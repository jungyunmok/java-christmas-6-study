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

    // 숫자 입력 범위 확인
    public void checkRange(int max, int number) {
        if(number < 1 || number > max) {
            throw new IllegalArgumentException();
        }
    }
}
