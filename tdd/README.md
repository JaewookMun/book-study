## JUnit


## - JUnit 5 모듈 구성

---

**구성**

- **JUnit 플랫폼** : 테스팅 프레임워크를 구동하기 위한 런처와 테스트 엔진을 위한 API 제공
- **JUnit 주피터** (Jupiter) : JUnit 5를 위한 테스트 API와 실행 엔진을 제공
- **JUnit 빈티지** (Vintage) : JUnit 3과 4로 작성된 테스트를 JUnit 5 플랫폼에서 실행하기 위한 모듈을 제공

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/6f3985ec-4857-4fe7-bff4-ff2bb7e337b6/3dc9ca10-f7e1-41a0-a48c-89e3975bf2b7/Untitled.png)

**의존성 추가**

[Maven]

```xml
<dependencies>
...
	<dependency>
		<groupId>org.junit.jupiter</groupId>
		<artifactId>junit-jupiter</artifactId>
		<version>5.5.0</version>
		<scope>test</scope>
	</dependency>
...
</dependencies>
```

[gradle]

```
dependencies {
	...
	testImplementation('org.junit.jupiter:junit-jupiter:5.5.0');
	
	...
}
```

[참고: springboot (gradle 기준)]

```
dependencies {
	...
	testImplementation 'org.springframework.boot:spring-boot-starter-test'
	
	...
}
```

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/6f3985ec-4857-4fe7-bff4-ff2bb7e337b6/106f7544-b64a-42d8-a2aa-591db16890b1/Untitled.png)

## - 테스트 메서드 작성

---

**JUnit 프레임워크 사용방법 - 기본 구조**

1. 테스트 클래스 작성
2. 테스트를 실행할 메서드 위에 @Test 어노테이션 추가

※ 주의 : 테스트를 수행하는 메서드의 scope가 private이 되면 안된다.

```java
public class SampleTest {
	
		@Test
		void test() {
				int sample = 1;
				assertEquals(1, sample);
		}
}
```

## - 주요 단언 메서드

---

■ Assertions 클래스를 통해 제공되는 다양한 정적 메서드

- assertEquals(expected, actual)
- assertNotEquals(unexpected, actual)
- assertSame(Object expected, Object actual)
- assertNotSame(Object unexpected, Object actual)
- assertTrue(boolean condition)
- assertFalse(boolean condition)
- assertNull(Object actual)
- assertNotNull(Object actual)
- fail()

[참고]

- fail() 메서드는 테스트에 실패했음을 알릴 때 사용
- 특정 Exception 타입의 발생 유무가 검증 대상일 경우
    - assertThrows(Class<T> expectedType, Executable executable)
    - assertDoesNotThrow(Executable executable)
- 정적 메서드가 실패하면 익셉션이 발생하기 때문에 이후 검증 메서드를 진행하지 않는다.

  → 여러개의 메서드를 검증하고 이를 확인하고 싶다면 **assertAll()** 메서드를 사용


```java
/**
		assertThrows : executable을 실행한 결과로 지정한 타입의 익셉션이 발생하는지 검사
 */
...

IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
                () -> {
                    throw new IllegalArgumentException("test");
                });

assertTrue(thrown.getMessage().contains("test"));		

...
```

```java
// 첫번째 코드의 검증 실패로 인하여 두번째 코드의 검증은 수행되지 않음
assertEquals(3, 5 / 2);
assertEquals(4, 2 * 2);

// 검증에 실패한 코드가 존재할 경우 그 목록을 제공
assertAll(
        () -> assertEquals(3, 5 / 2),
        () -> assertEquals(4, 2 * 2),
        () -> assertEquals(6, 11 / 2)
);
```

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/6f3985ec-4857-4fe7-bff4-ff2bb7e337b6/94e506e8-58d5-42cc-a4ea-e1e672431be5/Untitled.png)

## - 라이프사이클

---

- **JUnit 테스트 메서드의 코드 진행 순서** (각 테스트 메서드별 동일진행)
1. 테스트 메서드를 포함한 객체 생성 (테스트 클래스 객체 생성)
2. (존재하면) @BeforeEach 애노테이션  메서드 실행
3. @Test 애노테이션 메서드 실행
4. (존재하면) @AfterEach 애노테이션 메서드 실행

※ 주의 - @BeforeEach, @AfterEach 메서드 모두 private scope를 사용하면 안됨.

```java
public class JUnit5LifeCycleTest {

    public JUnit5LifeCycleTest() {
        System.out.println("new LifeCycle");
    }

    @BeforeEach
    void setUp() {
        System.out.println("setUp");
    }

    @Test
    void a() {
        System.out.println("a");
    }

    @Test
    void b() {
        System.out.println("b");
    }

    @AfterEach
    void tearDown() {
        System.out.println("tearDown");
    }
}
```

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/6f3985ec-4857-4fe7-bff4-ff2bb7e337b6/d4816a41-85cb-4ed2-b489-e8a654ed4df4/Untitled.png)

[참고]

- @BeforeAll - 모든 테스트 메서드가 실행되기전 한번만 사용
- @AfterAll - 모든 테스트 메서드를 실행한 뒤 한번만 사용
- 위 두 어노테이션은 정적 메서드에 적용

```java
@BeforeAll
static void beforeAll() {
    System.out.println("beforeAll");
}

@AfterAll
static void afterAll() {
    System.out.println("afterAll");
}
```

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/6f3985ec-4857-4fe7-bff4-ff2bb7e337b6/c044ec4f-555f-4885-8f47-92f6852aeb9a/Untitled.png)

## - 실행 순서 의존도와 필드 공유

---

※ 주의

- 테스트 메서드는 서로 독립적으로 동작

  → 한 테스트 메서드 결과에 따라 다른 테스트 메서드의 실행 결과가 달라지면 안된다.

  **→ 서로 필드를 공유하거나 테스트의 실행순서를 가정하면 안됨 !!!**

  (JUnit이 테스트 메서드간 실행순서를 지정하는 방법을 제공하지만 유지보수를 어렵게 만듬.)


## - 추가 애노테이션 : @DisplayName, @Disabled

---

- @DisplayName : 테스트 표시이름 개별설정
- @Disabled : 특정 메서드의 테스트 실행 제외
- 그외 애노테이션 - 부록 참고

## - 모든 테스트 실행하기

---

- mvnw )  mvn test
- gradlew) gradlew test

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/6f3985ec-4857-4fe7-bff4-ff2bb7e337b6/0d79cfa4-1273-46b0-be79-b93ea53784f6/Untitled.png)