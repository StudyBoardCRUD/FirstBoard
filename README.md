# CRUD-board-basic
## 학습 내용 정리
* * *
### 19.12.16 
* * * 
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

* * *
### 19.12.17 
* * * 
#### Spring의 Annotation - 1
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
    
#### JPA 사용하기 - 1
* Repository 만들기
    * repository로 사용 할 interface를 만들어 준 뒤 JpaRepository interface를 상속받아 구현한다.
    
* * *
### 19.12.18 
* * * 
#### Spring의 Annotation - 2
* @ResponseStatus의 용도와 사용방법
    * 사용자에게 원하는 http status code와 reason을 반환
      예외처리 함수 앞에 사용하여 오류 발생시 확정된 오류값을 전달한다.
      ```java
        @RestController
        @RequestMapping("/hello")
        public class HelloController {

            @GetMapping("/")
            @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "my page URL changed..")
            public void getMethod() {
            }
        }      
        ```
      
* @Converter의 용도와 사용방법
    * 변환이 필요한 데이터(Ex. 주민등록번호, 이메일, 패스워드... 등등)을 변환시켜줄때 사용하는 기능
      
#### JPA 사용하기 - 2
* JPA의 정의
    * Java Persistence API의 약자
    * Persistence라는 단어는 Java DTO(Data Transfer Object)에게 '없어지지 않고 오랫동안 지속'되는 '영속성(persistence)'을 부여해준다는 의미.
      즉, 데이터를 DB상에 영구적으로 저장해주는 API 
    * 기존 JDBC만을 이용하는 경우 반복적이며 비슷한 SQL문을 많이 만들어야하고, 데이터베이스의 테이블과 자바 객체간의 매핑하는 소모적인 작업을 지속해야 한다.
      JPA를 사용하게 되면 SQL문을 개발자가 만들지 않기 때문에 객체 중심적인 개발로 생산성과 유지보수의 능률이 크게 오르고, 특정 DBMS 문법에 종속적이지 않은 개발이 가능
      또한 JPA의 영속성 컨텍스트는 효율적인 SQL처리에 크게 기여하여 성능상의 이점도 취할 수 있다.
      
* Entity 만들기
    * Entity란?
        * DB에서 영속적으로 저장된 데이터를 자바 객체로 매핑하여 '인스턴스의 형태'로 존재할 수 있게 해주는 데이터
    * Java에서 Entity Class를 작성하는 방법 (차후 게시판 실제 예제로 변경 진행)
        * ```java
             @Entity
             @Table(name = "product")
             @Getter
             @Setter
             public class Product {
                 @Id
                 @GeneratedValue(strategy = GenerationType.IDENTITY)
                 private Long id;
                 @Column(length = 100, nullable = false)
                 private String name;
                 @Column(nullable = false)
                 private int price;
             
                 @ManyToOne
                 @JoinColumn(name ="category_id",nullable = false)
                 private Category category;
             
                 @OneToMany(mappedBy = "product")
                 private Set<Cart> carts;
             }
          ```
* JPA의 Annotation
    * @Entity - Entity클래스임을 명시합니다.
    * @Table(name = "table name") - 매핑할 테이블 명을 지정합니다.
    * @Id - 기본키임을 나타냅니다. 모든 Entity클래스는 @Id설정이 필요합니다. 기본키가 복합키로 된 경우는 @Embeddedid를 사용합니다.
    * @GeneratedValue(strategy = GenerationType.IDENTITY) - JPA가 기본키 생성을 하도록 합니다. 
    * @Column -  Entity클래스의 모든 필드는 데이터베이스의 컬럼과 매핑되어 따로 명시하지 않아도 됩니다. 하지만 매핑될 컬럼명이 다르거나, default값이 다른경우에 사용합니다. (이름은 카멜표기법이 소문자 스네이크 표기법으로 전환되고, length는 255, nullable은 true가 default 값입니다.)
    * @JoinColumn - name에 명시한 category_id라는 컬럼명으로Category에 대한 외래키 설정이 됩니다. 참조 되는 컬럼은 Catrgory Entity클래스에서 @Id가 명시된 필드입니다.
    * @OneToOne - 다른 Entity클래스와의 외래키 다대일(N:1)관계를 명시합니다. 
    * @ManyToOne - 다른 Entity클래스와의 외래키 다대일(N:1)관계를 명시합니다. 
    * @OneToMany - 다른 Entity클래스와 일대다(1:N)관계를 명시합니다. mappedBy에는 제네릭스로 명시된 Cart Entity가 외래키 설정에서 사용한 참조변수 이름입니다. 반대편이 Many 설정일 경우에는 반드시 컬렉션프레임워크(List나 Set)을 사용합니다.  방향성에 대한 자세한 내용은 다음 포스팅을 참고하시기 바랍니다. ☞ JPA Entity간의 방향 설정하기
    
### 19.12.20 
* * * 
#### Spring 이론
* [DI(Dependency Injection)이란 무엇인가?](https://gmlwjd9405.github.io/2018/11/09/dependency-injection.html)
    * 객체 자체가 아니라 Framework에 의해 객체의 의존성이 주입되는 설계 패턴
        * 의존성이 동적으로 주입되므로, 여러 객체간의 결합이 줄어든다.
        * DI는 spring에서 지원하는 IoC의 형태
    * example
        ```java
        /*
            PetOwner 객체는 AnimalType 객체(Dog)에 의존한다.
            PetOwner 생성자에서 new Dog();를 통해 Dog에 의존성을 가진다.
            이 접근법의 문제점(의존성이 위험한 이유)
            PetOwner 객체는 AnimalType 객체의 생성을 제어하기 때문에 두 객체 간에는 긴밀한 결합(tight coupling)이 생기고, tight coupling에 따라 AnimalType 객체를 변경하면 PetOwner객체도 변경된다.
            즉, 하나의 모듈이 바뀌면 의존한 다른 모듈까지 변경 되어야 한다.
            또한 두 객체 사이의 의존성이 존재하면 Unit Test 작성이 어려워 진다.
        */
        public class PetOwner{
            private AnimalType animal;
        
            public PetOwner() {
                this.animal = new Dog();
            }
        }
        ```
      
        ```java
        /*
          인터페이스를 이용하여 구현을 분리시키고, 메인 로직에서 의존성을 주입시킨다.      
        */
        public interface AninalType {
          public void sound();
        }
      
        public class Cat implements AninalType {
          String myName;
          public void setMyName(String name) {
              this.myName = name;
          }
          public void sound() {
              System.out.println("Cat: " + myName + 
               "-Meow");
          }
        }
      
        public class Cat implements AninalType {
          String myName;
          public void setMyName(String name) {
              this.myName = name;
          }
          public void sound() {
              System.out.println("Cat: " + myName + 
               "-Meow");
          }
        }
      
        public class PetOwner {
          public AnimalType animal;
          public PetOwner(AninalType animal) {
              this.animal = animal;
          }
          public void play() {
              animal.sound();
          }
        }
      
        public class MainApp {
          public static void main(String[] args) {
              /* main함수에서 Container를 생성 */ 
              // 설정 파일은 인자로 넣고, 해당 설정 파일에 맞게 bean들을 만든다.
              ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/di/beans/animal.xml");
              // getBean()을 통해 bean의 주소값을 가져온다.  
              PetOwner person = (PerOwner) context.getBean("petOwner");
              person.play();
              context.close();
          } 
        }
        ```

* [생성자 주입을 사용해야 하는 이유, 필드인젝션이 좋지 않은 이유](https://yaboong.github.io/spring/2019/08/29/why-field-injection-is-bad/)
    * 스프링에서 DI 방법 세가지
        ```java
          //Filed Injection
          @Service
          public class StudentServiceImpl implements StudentService {
          
              @Autowired
              private CourseService courseService;
          
              @Override
              public void studentMethod() {
                  courseService.courseMethod();
              }
          
          }
      
          //Setter Base Injection
          @Service
          public class StudentServiceImpl implements StudentService {
          
              private CourseService courseService;
          
              @Autowired
              public void setCourseService(CourseService courseService) {
                  this.courseService = courseService;
              }
          
              @Override
              public void studentMethod() {
                  courseService.courseMethod();
              }
          }
      
          //Constructor Base Injection
          @Service
          public class StudentServiceImpl implements StudentService {
          
              private final CourseService courseService;
          
              @Autowired
              public StudentServiceImpl(CourseService courseService) {
                  this.courseService = courseService;
              }
          
              @Override
              public void studentMethod() {
                  courseService.courseMethod();
              }
          }
        ```
 * Constructor Base Injection 의 장점
    * NullPointerException 을 방지할 수 있다.
    * 주입받을 필드를 final 로 선언 가능하다.
    * (Spring에서의 장점) 생성자 주입을 이용한 순환참조를 컴파일타임에 확인하여 방지 할 수 있다.
    * 테스트 코드를 작성하기 좋다.
    
    
### 19.12.21 
* * * 
#### Exception
* [사용자 정의 예외](https://edu.goorm.io/learn/lecture/41/%EB%B0%94%EB%A1%9C%EC%8B%A4%EC%8A%B5-%EC%83%9D%ED%99%9C%EC%BD%94%EB%94%A9-%EC%9E%90%EB%B0%94-java/lesson/39283/%EB%82%98%EB%A7%8C%EC%9D%98-%EC%98%88%EC%99%B8-%EB%A7%8C%EB%93%A4%EA%B8%B0)
    * checked or unchecked
        * checked - API 호출자가 오류에 대한 답변을 받아서 처리가 가능 할 경우 사용
                    Exception을 상속받아 구현한다.
                    checked exception이기 때문에 try - catch 구문을 이용해 API 호출자가 이용할 수 있는 에러반환 처리를 제공해야한다.
        * unchecked - API 호출자가 오류에 대한 답변을 받아도 따로 처리가 불가능한 경우
                      RuntimeException을 상속받아 구현한다.
                      ex) convertToDatabaseColumn의 암호화 과정 중 오류가 발생했을 경우 이는 서버단의 문제이기 때문에 프론트에서는 처리가 불가능하다. 이런경우 unchecked로 에러를 처리해야한다.
                      
    * 표준 예외 클래스를 이용해서 많은 예외 상황을 표현하는게 가능하다.
      하지만 예의를 직접 만들어 줌으로써 어떤 상황에서 unchecked가 발생하였고, 어떻게 추적할 것인지에 대해명확히 정의할 수 있다.
      
    * 사용자 정의 예외의 장점은 클래스 변수를 이용하여 추가적인 변수를 이용하여 에러상황에서 좀 더 상세한 파라미터 및 상황에 대한 로그를 남길 수 있다는 장점이 있다.
        * example
          ```java
          class DivideException extends Exception {
              public int left;
              public int right;
          
              DivideException(){
                  super();
              }
              DivideException(String message, int left, int right){
                  super(message);
                  this.left = left;
                  this.right = right;
              }
          }
          class Calculator{
              int left, right;
              public void setOprands(int left, int right){
                  this.left = left;
                  this.right = right;
              }
          
              public void divide() throws DivideException{
                  if(this.right == 0){
                      throw new DivideException("0으로 나누는 것은 허용되지 않습니다.");
                  }
                  System.out.print(this.left/this.right);
              }
          }
          
          class Main {
          
              public static void main(String[] args) {
                  Calculator c1 = new Calculator();
                  c1.setOprands(10, 0);
                  try {
                    c1.divide();
                  } catch(DivideException e) {
                    System.out.println(e.getMessage());
                    System.out.println(e.left);
                    System.out.println(e.right);
                  }
              }
          }
          ```
      
    * [sornalint info] MyOwnRuntimeException()을 생성하여 오류를 처리 할 것을 경고하였다.

