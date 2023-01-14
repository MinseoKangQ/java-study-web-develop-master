<h3>01. 객체지향의 등장</h3>

* 절차 지향 언어

  * 간단한 로직을 순차적으로 처리하여 결과 얻음

  * 프로그램 복잡도의 증가로 인한 비효율 발생

  * ex. C

  * 효과적인 개발 방식으로 객체 지향 개발 시작


<br>

* 객체 지향 언어

  * Object(객체) = 사물

  * Method = 행위

  * Variable(변수) = 속성

  * ex. Java

    * 어떠한 운영체제에서도 자바 가상 머신만 있으면 독립적으로 실행될 수 있도록 설계
    
    * 여러 플랫폼에서 호환성 제공

<br>

* 객체의 3가지 요소

  * 상태 유지 (by Variable)

  * 기능 제공 (by Method)

  * 고유 식별자 제공

<br>

* 물리 객체와 개념 객체

  * 물리 객체
    
    * 실제로 사물이 존재

    * 이를 클래스로 정의한 객체 의미

  * 개념 객체
  
    * 웹 시스템에서 Service에 해당됨, Business logic을 처리하는 부분을 의미

    * Business logic에서는 여러 객체가 서로 상호작용 하도록 함

    * 객체가 제공하는 오퍼레이션 Method를 통해 객체의 속성을 변경

<br>

<h3>02. 객체지향의 4대 특성</h3>

1) 캡슐화 

   * 객체의 속성(Variable) 보호하기 위해 사용

   * 각각의 Method는 서로 관련성 있어야하고, 상대되는 기능을 제공해야 함

   * Method에 필요한 값들은 매개변수의 형태로 전달되어야 함

   * Getter/Setter Method

   * CRUD Method

   * Business Logic Method

   * 객체의 생명 주기 처리 Method (ex. destroy(), disconnect(), quit() 등)

   * 객체의 영구성 관리 Method

   * 장점 : 추상화 제공, 재사용성 향상, 유지보수 효율성 향상

   * 무결성 : 변수(private), Method(public)

<br>

2) 상속

   * 하위로 내려갈 수록 구체화

   * 장점 : 프로그램 구조에 대한 이해도/재사용성/확장성/유지보수성 향상

<br>

3) 다형성

   * 하나의 개체가 여러 형태로 변화하는 것

   * 오버라이딩을 통해 실현

<br>

4) 추상화

   * 객체지향에서의 추상화는 모델링

   * 공통적인 부분, 특정 특성을 분리하여 재조합하는 부분

   * 다형성, 상속 모두 추상화에 속함

<br>

<h3>03. 객체지향 설계 5원칙 SOLID</h3>

* 결합도와 응집도

  * 좋은 소프트웨어 설계 시 결합도는 낮고, 응집도는 높아야 함

<br>

  * 결합도(Coupling)

    * 클래스 간의 상호 의존도를 나타냄

    * 결합도가 낮으면 객체 재사용 및 유지보수 유리

<br>

  * 응집도(Cohesion)

    * 하나의 모듈 내부에 존재하는 구성 요소들의 기능적 관련성

    * 응집도가 높으면 모듈은 하나의 책임에 집중하고 독립성 높아짐

    * 재사용 및 유지보수 유리

<br>

1) SRP(Single Responsibility Principle) 단일 책임 원칙

   * 어떠한 클래스를 변경하는 이유는 단 하나여야 함

<br>

2) OCP(Open Closed Principle) 개방 폐쇄 원칙

   * 자신의 확장에는 Open, 주변의 변화에는 Closed

   * ex. JDBC, Mybatis, Hibernate, JAVA에서의 Stream 등

<br>

3) LSP(Liskov Substitution Principle) 리스코프 치환 원칙

   * 서브 타입은 언제나 자신의 상위 타입으로 교체할 수 있어야 함

<br>

4) ISP(Interface Segregation Principle) 인터페이스 분리 원칙

   * 클라이언트는 자신이 사용하지 않는 Mehtod에 의존하면 안됨

   * 프로젝트 요구 사항과 설계에 따라 SRP(단일 책임 원칙) / ISP(인터페이스 분리 원칙) 선택

<br>

5) DIP(Dependency Inversion Principle) 의존 역전 원칙

  * 자신보다 변하기 쉬운 것에 의존하면 안됨

<br>

<h3>04. POJO JAVA</h3>

* POJO JAVA란?

  * POJO = Plain Old Java Object

  * 순수한 자바 오브젝트

<br>

* POJO 특징

  1) 특정 규약에 종속되지 않음

     * 특정 Library, Module에서 정의된 클레스를 상속받아 구현하지 않아도 됨

     * POJO가 되기 위해서는 외부의 의존성을 두지 않고, 순수한 JAVA로 구성 가능해야 함

  2) 특정 환성에 종속되지 않음

     * 특정 Business logic을 처리하는 부분에 외부 종속적인 http request, session 등은 POJO를 위배한 것임

     * @Annotation 기반으로 설정하는 부분도 엄연히 POJO라고 부를 수 없음

<br>

* Spring, Hibernate : 두 프레임워크는 객체지향적인 설계, POJO를 지향