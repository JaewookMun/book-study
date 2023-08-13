## 객체지향의 사실과 오해 (조영호)

<br>

해당 프로젝트는 책의 마지막 챕터인 '07장 함께 모으기'에서 샘플로 보여준 설계방식을 따라 간단한 시스템을 설계하면서 정리한 인터페이스를 저장.<br>
(book.margin.oop.coffeesample 패키지의 인터페이스는 책에서 예시로 제공된 도메인에서 '원두를 주문해라'라는 메시지가 추가될 경우 필요한 협력관계를 정리)

<br><br>

1. 도메인 분석
- 메인 도메인 : 도서관 책 대여 시스템
- 구성요소 :
    이용자, 사서, 정보 저장소, 책
- 도메인 구성 개념들간의 관계 (하위 도메인 모델)

    ![image](https://github.com/JaewookMun/book-study/assets/84655268/e401ccea-8b96-4ec6-ac5b-029ffbb13bf5)
    - InformationStorage - BookInfo : 포함관계 (BookInfo의 생명주기는 종속적)
    - Librarian - Book : 연관관계 (Book의 생명주기는 독립적)


<br><br>

2. 설계 - 메시지와 협력 (기능 요구사항)
- 객체 협력 구성
    - 협력에 필요한 메인 기능사항 : “책을 대여하라”
    - 객체 협력
    ![image](https://github.com/JaewookMun/book-study/assets/84655268/42d5b2f8-e684-4f71-8308-2e3f73b5e459)

<br>

- 인터페이스 정리
    ``` java
    public class User {
        public void borrowBook(String title) { ... }
    }

    public class InformationStorage {
        private List<BookInfo> infoStorage = new ArrayList<>();

        public BookInfo searchInfoBy(String title) { ... }
    }

    public class Librarian {
        public Book lend(BookInfo bookInfo) { ... }
    }

    public class Book {
        public Book() { ... }
    }
    
    ```

    <br><br>

3. 구현
- 인터페이스 오퍼레이션 구현
- spring-exercise 레포지토리의 [/jpa/booklending 참고](https://github.com/JaewookMun/spring-exercise/tree/main/jpa/booklending)