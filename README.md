# coffeeManager

## 프로젝트 개요

커피 매니저는 다양한 커피를 판매하고 관리할 수 있는 시스템입니다.<br/>
사용자 인터페이스를 통해 주문, 결제, 매입 및 통계를 관리할 수 있습니다.<br/>
이 시스템은 3계층 아키텍처로 구성되어 있어 유지보수와 확장이 용이합니다.

### 기능

-   커피 주문 및 판매
-   주문 상태 관리 (주문 성공, 재고 부족, 비시즌 등)
-   매입 및 판매 통계 보기
-   사용자 잔고 및 매출 관리

![대체 텍스트](/src/images/image1.jpg)

### 도메인

-   **커피**

    -   정의 : 판매하는 상품 / 커피의 누적판매량 기록
    -   정책 : 안전재고 기준 미달 시 기준의 2배수만큼 매입
    -   속성 : 이름, 판매가, 매입가, 재고, 안전재고, 누적판매량

    ```java
    public class Coffee {
        private String name;
        private int price;
        private int purchasePrice;
        private int stock;
        private int safetyStock;
        private int salesCount;
    }
    ```

-   **판매**

    -   정의 : 주문에 따른 상품 제공 및 결제 진행 과정

-   **주문**

    -   정의 : 주문 상품, 주문 수량, 주문 일시, 주문금액 정보
    -   정책 : 커피 재고 부족 시 주문 취소
    -   속성 : 주문 상품, 주문 수량, 주문 일시, 주문 금액

    ```java
    public class Order {
        private Coffee coffee;
        private int orderCnt;
        private LocalDateTime orderTime;
        private int orderPrice;
    }
    ```

-   **결제**

    -   정의 : 주문에 따른 결제 금액을 계산, 계좌에 등록하는 과정
    -   속성 : 주문, 결제금액

    ```java
    public class Payment {
        private Order order;
        private int paymentPrice;
    }
    ```

-   **계좌**

    -   정의 : 매출, 지출, 잔고 내역을 기록한 정보
    -   속성 : 매출, 지출, 잔고

    ```java
    public class Account {
        private int balance;
        private int sales;
        private int expenses;
    }
    ```

-   **매입**

    -   정의 : 커피 재고를 추가하고 매입 금액을 계좌에 등록하는 과정
    -   정책 : 잔고 부족 시 매입 취소
    -   속성 : 커피, 매입 수량

    ```java
    public class Purchase {
        private Coffee coffee;
        private int purchaseCnt;
    }
    ```

-   **할인**
    -   정의 : 주문 금액에 따른 할인율 적용

### 확장 기능

-   주문 금액이 10,000원 이상일 때 10% 할인 추가
-   특정 시즌에만 판매하는 커피 메뉴 추가

##

![대체 텍스트](/src/images/image2.jpg)

## 객체지향 프로그래밍의 장점

-   객체 간 메시지 파악으로 프로그램 전체 구조 파악
-   객체 간 주고받는 메서드를 수정하지 않는 이상, 한 클래스 변경이 다른 클래스에 영향을 미치지 않는다.(낮은 결합도)
-   기능 추가 개념이 명시적
-   새로운 기능 추가를 위해 기존 코드를 수정하지 않아도 된다.
-   유지보수 및 기능 확장이 유연한 프로그램 설계 가능
