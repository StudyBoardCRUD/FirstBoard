# 학습 내용 정리


### 1. REST API
서로 다른 Front-end를 통해 다양한 환경(웹, 모바일)을 지원한다. 이들이 공통적으로 사용하는 기능을 하나의 Back-end로 제공할 수 있는데, 이 때 Back-end를  REST API를 사용해 만들어야 한다.

* REST = Representational State Transfer ( 표현 상태를 전달 )
* Resource 처리를 의미
* Resource 처리 방법 = CRUD
  * Create, Read, Update, Delete
  * 이는 HTTP 표준 메서드 POST, GET, PUT/PATCH, DELETE 와 연결된다
* Resource 종류
  * Collection
    * Collection을 처리하는 방법 : Read(List), Create
    * Collection Resource에 접근하는 방법
      * http://host/restaurants
  * Member
    * Member를 처리하는 방법 : Read(Detail), Update, Delete
    * Member Resource에 접근하는 방법
      * http://host/restaurants/1 ( resource id )
* API들을 REST API에 맞춰서 정의하면
  * 가게 목록을 얻을 때 : GET /restaurants
  * 가게 상세를 얻을 때 : GET /restaurants/{id}
  * 가게를 추가할 때 : POST /restaurants
  * 가게를 수정할 때 : PATCH(PUT) /restaurants/{id}
  * 가게를 삭제할 때 : DELETE /restaurants/{id}



### 2. Test Driven Development

**2-1. TDD의 3단계**

* Red
  * 실패하는 테스트 코드를 작성
* Green
  * 테스트가 실패하는 원인을 해결
* Refactoring
  * 테스트는 그대로 둔 상태에서 코드를 개선



### 3. Spock Framework

**3-1. Gradle 의존성 추가**

```text
testCompile('org.spockframework:spock-core:1.1-groovy-2.4')
testCompile('org.spockframework:spock-spring:1.1-groovy-2.4')
```



