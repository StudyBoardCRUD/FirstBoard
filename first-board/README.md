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



### 4. Vue

화면(View)단 라이브러리

**1. 구동 방식**

View(HTML)에서 이벤트가 발생 → DOM Listeners(Vue 구성 요소)가 이벤트를 감지 → JavaScript 로직을 실행 → 데이터가 변했을 때 → Data Bindings(Vue 구성 요소)를 통해 View에 반영

**2. HTML만 사용한 View 개발 방식의 단점**

```html
...
<body>
    <div id="app"></div>
  
		<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
    <script>
        const div = document.querySelector("#app");
        let str = "hello world";
        div.innerHTML = str;

        str = "hello world!!!!";
        div.innerHTML = str;
    </script>
</body>
...
```

```str``` 값 처럼 변수의 값이 바뀌어도 바로 화면에 반영할 수 없고, 태그 정보를 가져와서(변수 ```div```) 다시 변수를 대입을 해줘야 화면에 반영할 수 있다.

**3. Reactivity**

* Vue의 핵심
* 데이터의 변화를 라이브러리에서 감지해서 화면에 자동으로 반영하는 것

**3.1 ```Object.defineProperty()```를 사용한 방법**

```html
...
<body>
    <div id="app"></div>

		<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
    <script>
      const div = document.querySelector('#app');
      let viewModel = {};

      Object.defineProperty(viewModel, 'str', {
        // 속성에 접근했을 때의 동작을 정의
        get: function() {
          console.log('접근');
        }
        // 속성에 값을 할당했을 때의 동적을 정의
        set: function(newValue) {
        	console.log('할당', newValue);
        	div.innerHTML = newValue;
      	}
      })
    </script>
</body>
...
```

**4. 컴포넌트**

인스턴스를 생성하면 Root 컴포넌트가 된다.

**4.1 컴포넌트 생성 방법1 - 전역에 생성하기**

```html
...
<body>
	<div id="app">
		<app-header></app-header>
	</div>

	<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
	<script>
		Vue.component('app-header', {
			template: '<h1>Header</h1>'
		});
	
		new Vue({
			el: '#app'
		});
	</script>
</body>
...
```

**4.2 컴포넌트 생성 방법2 - 지역에 생성하기**

```html
...
<body>
	<div id="app">
		<app-header></app-header>
	</div>

	<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
	<script>
		new Vue({
			el: '#app',
			components: {
				'app-header': {
					template: '<h1>Header</h1>'
				}
			}
		});
	</script>
</body>
...
```

**5. 컴포넌트 통식 방식**

컴포넌트는 각각 데이터를 관리하고, 컴포넌트 간 데이터를 주고 받기 위해서 props와 이벤트를 사용한다.

- props 속성 : 상위 컴포넌트 → 하위 컴포넌트
- 이벤트 발생 : 하위 컴포넌트 → 상위 컴포넌트

이러한 규칙을 사용하면 데이터의 흐름을 추적할 수 있다.

**5.1 props 속성**

reactivity가 반영되어서 상위 컴포넌트의 데이터가 변경되면 하위 컴포넌트의 데이터도 변경된다.

```html
...
<body>
	<div id="app">
		// <app-header v-bind:프롭스 속성 이름="상위 컴포넌트의 데이터 이름"></app-header>
		<app-header v-bind:propsdata="message"></app-header>
	</div>

	<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
	<script>
		var appHeader = {
			template: '<h1>{{ propsdata }}</h1>',
			props: ['propsdata']
		}

		new Vue({
			el: '#app',
			components: {
				'app-header': appHeader
			},
			data: {
				message: 'hi'
			}
		});
	</script>
</body>
...
```

```app-header``` 컴포넌트의 상위 컴포넌트는 Vue 인스턴스로, Vue 인스턴스에서 data 값을 변경하면 ```app-header``` 컴포넌트의 ```props``` 속성 값도 변경된다.

**5.2 event emit**

```html
...
<body>
	<div id="app">
		// <app-header v-on:하위 컴포넌트에서 발생한 이벤트 이름="상위 컴포넌트의 메서드"></app-header>
		<app-header v-on:pass="logText"></app-header>
	</div>

	<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
	<script>
		var appHeader = {
			template: '<button v-on:click="passEvent">click me</button>',
			methods: {
				passEvent: function() {
					this.$emit('pass');
				}
			}
		}

		new Vue({
			el: '#app',
			components: {
				'app-header': appHeader
			},
			methods: {
				logText: function() {
					console.log('hi');
				}
			}
		});
	</script>
</body>
...
```

```pass```라는 이벤트가 하위 컴포넌트에서 발생했을 때 ```logText```라는 상위 컴포넌트 메서드를 실행해준다.

**6. 같은 컴포넌트 레벨 간의 통신 방법**

상위 컴포넌트 ↔ 하위 컴포넌트 간 통신은 바로 가능하지만, 같은 레벨 컴포넌트 간의 통신은 바로 할 수 없다. 따라서 상위 레벨로 통신(event) 후, 하위 레벨로 통신(props)하는 방법을 사용한다.

```html
...
<body>
	<div id="app">
		<app-header v-bind:="num"></app-header>
		<app-content v-on:pass="deliverNum"></app-content>
	</div>

	<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
	<script>
		var appHeader = {
			template: '<div>header</div>',
			props: ['propsdata']
		}

		var appContent = {
			template: '<button v-on:click="passNum">click me</button>',
			methods: {
				passNum: function() {
					this.$emit('pass', 10);
				}
			}
		}

		new Vue({
			el: '#app',
			components: {
				'app-header': appHeader,
				'app-content': appContent
			},
			data: {
				num: 
			},
			methods: {
				deliverNum: function(value) {
					this.num = value;
				}
			}
		});
	</script>
</body>
...
```

**7. 라우터**

```html
...
<body>
	<div id="app">
		<div>
			<router-link to="/login">Login</router-link>
			<router-link to="/main">Main</router-link>
		</div>
		<router-view></router-view>
	</div>

	<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
	<script src="https://unpkg.com/vue-router/dist/vue-router.js"></script>
	<script>
		var LoginComponent = {
			template: '<div>login</div>'
		}

		var MainComponent = {
			template: '<div>main</div>'
		}

		var router = new VueRouter({
			mode: 'history', // url에서 # 제거
			// 페이지의 라우팅 정보
			routes: [
				// 로그인 페이지 정보
				{
					// 페이지의 url
					path: '/login',
					// 해당 url에서 표시될 컴포넌트
					component: LoginComponent
				},
				// 메인 페이지 정보
				{
					path: '/main',
					component: MainComponent
				}
			]
		});

		new Vue({
			el: '#app',
			router: router
		});
	</script>
</body>
...
```

- routes 속성에는 배열이 들어가고, 배열 안에는 페이지의 수만큼 객체가 포함된다
- ```<router-view>```
  - router가 가지고 있는 태그
  - Vue 인스턴스에 Router 인스턴스를 연결해야 사용할 수 있다
  - url이 변경되었을 때 url에 따라 뿌려지는 영역
- ```<router-link>```
  - router에서 페이지 이동을 위한 link 태그
  - 화면에는 ```<a>``` 태그로 변환돼서 나타남

**8. Axios**

HTTP 통신 라이브러리

```html
...
<body>
	<div id="app">
		<button v-on:click="getData">get user</button>
		<div>{{ users }}</div>
	</div>

	<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
	<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
	<script>
		new Vue({
			el: '#app',
			data: {
				users: []
			},
			methods: {
				getData: function() {
					var vm = this;
					axios.get('https://jsonplaceholder.typicode.com/users/')
						.then(function(response) {
							console.log(response);
							vm.users = response.data;
						})
						.catch(function(error) {
							console.log(error);
						});
				}
			}
		});
	</script>
</body>
...
```

**9. 템플릿 문법**

```html
...
<body>
	<div id="app">
		<p>{{ num }}</p>
		<p v-bind:id="uuid">{{ doubleNum }}</p>
	</div>

	<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
	<script>
		new Vue({
			el: '#app',
			data: {
				num: 10,
				uuid: 'abc1234'
			},
			computed: {
				doubleNum: function() {
					return this.num * 2;
				}
			}
			watch: {
				num: function(newValue) {
					this.fetchUserByNumber(newValue);
				}
			}
			methods: {
				fetchUserByNumber: function(num) {
					console.log(num);
				}
			}
		});
	</script>
</body>
...
```

- 데이터 바인딩 :  ```{{ data }}```
- 뷰 디렉티브 : ````v-````로 시작하는 속성

**10. Vue CLI**

Vue CLI로 생성한 프로젝트는 내부적으로 webpack이 동작해서 index.html ```<!-- built files will be auto injected --> ```부분에 main.js에 정의한 내용을 바탕으로 파일들을 하나로 합쳐 주입된다.

**10.1 싱글 파일 컴포넌트(.vue)**

HTML, JavaScipt, CSS를 한 파일에서 관리

**10.1.1 기본 구조**

```vue
<template>
	<!-- HTML -->
</template>

<script>
export default {
	// JavaScript - 인스턴스 옵션
}
</script>

<style>
	/* CSS */
</style>
```

**10.1.2 컴포넌트 명명법**

- kebab case or pascal case로 정의