# CRUD-board-basic
## 학습 내용 정리
### 19.12.16 
#### JavaBeans란?
* JavaBeans의 정의
 * JavaBeans란 자바로 작성된 소프트웨어 컴포넌트를 지칭하는 단어로 이 컴포넌트를 빈(Bean)이라고 부르며 썬사의 JavaBeans API에 정의된 스펙에 따라 만든다.
 * JavaBeans는 자바 관련 소프트웨어 개발에 있어 재사용이 가능한 표준 컴포넌트 모델이다.

* Beans의 정의
  * java 클래스들을 모아놓은 package 
  * Model, View, Controller(MVC패턴 구현)
    * Model - 저장소역할( setXxx(), getXxx() 구현) - java코딩 
    * View - GUI역할(클라이언트에게 보여줄 화면구성 구현 ) - jsp코딩
    * Controller - DAO(데이터처리 담당 - DB연동)역할 , 비즈니스 로직
  * 내부적으로 보이지 않게 처리해야하는 기능 구현 - java코딩, 서블릿문서
  
* Beans 규약
  1. 기본 생성자가 반드시 존재해야한다. (인자가없는 디폴트 생성자)
  2. 속성을 접급한고 꺼내올수있는 setXXX/getXXX메소드를 구성한다.
  3. 속성을 지정(private)해야하는데 속성 이름은 보통 html의 form태그안에서 input 태그의 name속성 값과 같게 정한다.

#### DAO와 DTO(=VO)의 차이점
* DAO의 정의
DAO는 Data Access Object를 의미한다.
즉, 말 그대로 Database에 접근하기위한 객체라고 보면 된다.
데이터 접근 로직과 비즈니스 로직을 분리하기위해 만들어낸 객체라고 생각하면 된다.

* DTO의 정의
DTO는 Data Transfer Object, VO는 Value Object의 약자이다.
계층간 데이터 교환을 위한 자바빈즈

여기서 '계층'이 의미하는 것은 Controller, View, Business Layer, Persistent Layer를 말하며,
각 계층간 데이터 교환을 위한 객체를 DTO 또는 VO라고 말한다. DTO와 VO의 차이점은 VO가 read only 속성을 가지는 것이다.

#### Lombok Annotation 정리
* @Getter
    * 입력되어 있는 요소들의 getter를 자동으로 생성한다.
* @Setter
    * 입력되어 있는 요소들의 setter를 자동으로 생성한다.
* @AllArgsConstructor
    * 모든 요소들의 값을 입력받는 constructor를 자동으로 생성한다.
* @NoArgsConstructor
    * 기본 constructor를 자동으로 생성한다.

#### Spock 
* [Spock으로 테스트코드를 짜보자](http://woowabros.github.io/study/2018/03/01/spock-test.html)
* Spock 이란?
    * 기존 Junit의 보일러 플레이트를 최대한 제거하고, 다양한 케이스를 테스트하기에 적합하게 개발된 기능
    * 테스트 코드를 작성하며 추가적으로 보완해나갈 예정


### 19.12.17 
#### Spring의 Annotation
* @RestController
    * 해당 함수를 REST controller로 만들어주는 기능
    
* @RequestMapping("value")
    * 입력되어있는 value를 컨트롤러 진입의 자원(resource)으로 지정하는 기능
    
* @GetMapping("value")
    * HTTP GET 요청을 특정 메서드에 맵핑하기위한 annnotation 이다.
    * @RequestMapping(method = RequestMethod.GET)의 역할을 대체 하면서, 더 가독성있게 처리해준다.
        * __공식 코드 주석 내용__
        * Annotation for mapping HTTP {@code GET} requests onto specific handler
        * methods.
        * <p>Specifically, {@code @GetMapping} is a <em>composed annotation</em> that
        * acts as a shortcut for {@code @RequestMapping(method = RequestMethod.GET)}.

* @RequestParam(value(or name) = "value", defaultValue = "default value", required = true/false)
    * 보내주는 파라미터의 key에 맞춰 value을 받아주는 기능.
    * required에 따라서 값의 필수 여부가 결정된다.
    
* @Autowired
    * 각 상황의 타입에 맞는 IoC컨테이너 안에 존재하는 Bean을 자동으로 주입한다.
    
* @Service
    * 해당 클래스의 용도를 명시적으로 알려주며, 동시에 해당 클래스를 Bean에 등록시킨다.
    * Service Layer의 용도는 데이터 호출, 연산 처리 등의 비즈니스로직이 주를 이룬다.
    * DDD를 적용하기 위해서는 서비스를 __애플리케이션 계층__, __도메인 계층__, __인프라 계층__ 으로 나누어 용도에 맞게 코드의 역할을 분할시켜준다. 

#### 요청의 반환
* ResponseEntity
    * HTTP의 표준규약 형식에 맞도록 데이터 형식 및 HTTPStatus를 반환하기 위해서 사용한다.
    * 올바른 응답 코드 및 데이터 구성 형식을 갖출수 있게 된다.
    * 표준 규약을 지킬 경우 frond <> back이 서로 에러상황에 맞춰 정상적인 처리를 유도 할 수 있다.
    
#### JPA 사용하기
* Repository 만들기
    * repository로 사용 할 interface를 만들어 준 뒤 JpaRepository interface를 상속받아 구현한다.