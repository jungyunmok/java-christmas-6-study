# 메뉴
<애피타이저>
양송이수프(6,000), 타파스(5,500), 시저샐러드(8,000)

<메인>
티본스테이크(55,000), 바비큐립(54,000), 해산물파스타(35,000), 크리스마스파스타(25,000)

<디저트>
초코케이크(15,000), 아이스크림(5,000)

<음료>
제로콜라(3,000), 레드와인(60,000), 샴페인(25,000)

---

# 기능 구현 목록
## 기능
- [x] 크리스마스 디데이 할인 - Event#xMas()
  - [x] 12월 1일 ~ 25일까지 진행
  - [x] 할인 금액 1,000원부터 시작
  - [x] 매일 100원씩 증가하여 25일엔 총 3,400원 할인
  - [x] 총주문 금액에서 할인
- [x] 12월 할인
  - [x] 평일 할인 - Event#weekdaySale()
    - [x] 일~목요일엔 디저트 메뉴를 1개당 2,023원 할인 - Event#sortMenu
  - [x] 주말 할인 - Event#weekendSale()
    - [x] 금, 토요일엔 메인 메뉴를 1개당 2,023원 할인 - Event#sortMenu
  - [x] 특별 할인 - Event#specialSale()
    - [x] 이벤트 달력에 별이 있는 날(3,10,17,24,25,31) 총주문 금액에서 1,000원 할인
  - [x] 증정 이벤트 - Event#gift()
    - [x] 할인 전 총주문 금액에 12만원 이상일 때 샴페인 1개(25,000원) 증정
- [x] 12월 이벤트 배지 - Event#badge()
  - [x] 총 혜택 금액에 따라 이벤트 배지 부여
  - [x] 5천 원 이상: 별 
  - [x] 1만 원 이상: 트리 
  - [x] 2만 원 이상: 산타
- [x] 날짜 요일 변환 - DayNDate#returnDay()
- [x] 예외처리
  - [x] 모든 에러 메시지는 "[ERROR]"로 시작
  - [x] 문자열을 인트로 변환하며 exception 잡기 - Judgement#checkInt()
  - [x] 숫자 입력 범위 확인 - Judgement#checkRange()
  - [x] 메뉴-개수를 map에 담으며 중복 확인 - Judgement#checkDuplication()
  - [x] 존재하는 메뉴인지 확인 - Judgement#checkMenu()
  - [x] 메뉴는 최대 20개까지만 주문 가능 - Judgement#checkCount()
    - [x] 안내 메시지
  - [x] 음료만 주문 시 주문 불가 - Judgement#checkDrink()
    - [x] 안내 메시지
  - [x] 총주문 금액 10,000원 이상부터 이벤트 적용됨
    - [x] 안내 메시지
  - [x] 잘못된 값을 입력시
    - [x] IllegalArgumentException를 발생, 에러 메시지를 출력, 해당 부분부터 다시 입력받기
  - [x] 유효하지 않은 날짜 입력시
    - [x] "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."라는 에러 메시지 출력
  - [x] 유효하지 않은 메뉴 입력시
    - [x] "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."라는 에러 메시지
  - [x] 유효하지 않은 값 입력시
    - [x] "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."라는 에러 메시지
  - [x] 메뉴 형식이 다른 경우
    - [x] "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."라는 에러 메시지
  - [x] 중복 메뉴를 입력한 경우
    - [x] "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."라는 에러 메시지

## 입력
- [x] 고객이 식당에 방문할 날짜 입력받기 - InputView#readDate()
  - [x] 1 이상 31 이하의 숫자 입력
- [x] 주문할 메뉴와 개수 입력받기 - InputView#readMenu()
  - [x] 메뉴-개수 형식으로 받을 것
  - [x] 메뉴 개수는 1 이상의 숫자만 입력

## 출력
- [x] 주문 메뉴 출력 - OutputView#printMenu()
- [x] 할인 전 총주문 금액 출력 - OutputView#printTotalAmount()
- [x] 증정 메뉴 출력 - OutputView#printGift()
  - [x] 해당하지 않는 경우, "없음" 출력
- [x] 혜택 내역 출력 - OutputView#printEvent()
  - [x] 해당하지 않는 경우, "없음" 출력
- [x] 총혜택 금액 출력 (총혜택 금액 = 할인 금액의 합계 + 증정 메뉴의 가격) - OutputView#printTotalSale()
- [x] 할인 후 예상 결제 금액 (할인 후 예상 결제 금액 = 할인 전 총주문 금액 - 할인 금액) - OutputView#printFinalAmount()
- [x] 12월 이벤트 배지 출력 - OutputView#printBadge
  - [x] 해당하지 않는 경우, "없음" 출력