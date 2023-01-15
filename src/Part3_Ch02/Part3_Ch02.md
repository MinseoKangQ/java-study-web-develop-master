<h3>01. 디자인 패턴이란?</h3>

* 디자인 패턴

    * 자주 사용하는 설계 패턴을 정형화하여 유형별로 최적의 방법으로 개발할 수 있도록 정해둔 설계

    * 알고리즘과 유사하지만 명확하게 정답이 있는 형태는 아님

    * 프로젝트 상황에 맞추어 적용 가능

<br>

* Gof 디자인 패턴 

  * GOF(Gang of Four)의 디자인 패턴

  * 객체지향 개념에 따른 설계 중 재사용 시 유용한 설계를 디자인 패턴으로 정리한 것

  * Gof의 디자인 패턴은 총 23개

<br>

* 디자인 패턴의 장점

  * 개발자 간의 원활한 소통

  * 소프트웨어 구조 파악에 용이
  
  * 재사용을 통한 개발 시간 단축

  * 설계 변경 요청에 대한 유연한 대처

<br>

* 디자인 패턴의 단점

  * 객체지향 설계/구현

  * 초기 투자 비용 부담

<br>

* <b><u>생성 패턴</u></b>

  * 객체를 생성하는 것과 관련된 패턴

  * 객체의 생성과 변경이 전체 시스템에 미치는 영향을 최소화

  * 코드의 유연성 높여줌
  
  * Factory Method

  * Singleton
  
  * Prototype

  * Builder

  * Abstract Factory

  * Chaining

<br>

* <b><u>구조 패턴</u></b>

  * 프로그램 내 자료구조/인터페이스 구조 등 프로그램 구조를 설계하는 데 활용 가능한 패턴

  * 클래스, 객체들의 구성을 통해 더 큰 구조 만들기 가능

  * 큰 규모의 시스템은 복잡한 구조를 가지는데, 이러한 구조를 개발/유지보수가 쉽게 만들어 줌

  * Adapter
  
  * Composite
  
  * Bridge

  * Decorator

  * Facade

  * Flyweight

  * Proxy

<br>

* <b><u>행위 패턴</u></b>

  * 반복적으로 사용되는 객체들의 상호작용을 패턴화

  * 클래스나 객체들이 상호작용하는 방법과 책임을 분산하는 방법을 제공

  * 행위 관련 패턴을 사용하여 독립적으로 일을 처리하고자 할 때 사용

  * Template Method

  * Interpreter
  
  * Iterator

  * Observer

  * Strategy

  * Visitor

  * Chain of responsibility

  * Command

  * Mediator

  * State

  * Memento

<br>

<h3>02. Singleton Pattern</h3>

* 어떠한 클래스(객체)가 유일하게 1개만 존재할 때 사용

* 서로 자원을 공유할 때 사용, ex. 프린터

* 실제 프로그래밍에서는 TCP socket 통신에서 서버와 연결된 connect 객체에 주로 사용

<br>

<h3>03. Adapter Pattern</h3>

* 호환성이 없는 기존 클래스의 인터페이스를 변환하여 재사용 가능케 함

* SOLID 중에서 개방 폐쇄 원칙(OCP) 따름

* ex. 변환기(110V -> 220V 혹은 220V -> 110V)

<br>

<h3>04. Proxy Pattern</h3>

* 무언가를 대신해서 처리하는 것 (대리인)

* Proxy Class를 통해서 대신 전달하는 형태로 설계

* 실제 Client는 Proxy로부터 결과 받음

* Cache의 기능으로도 활용 가능

* SOLID 중에서 개방 폐쇄 원칙(OCP)와 의존 역전 원칙(DIP) 따름

<br>

<h3>05. Decorator Pattern</h3>

* 기존 뼈대(클래스)는 유지하되, 이후 필요한 형태로 꾸밀 때 사용

* 확장 필요 시 상속의 대안으로도 활용

* SOLID 중에서 개방 폐쇄 원칙(OCP)와 의존 역전 원칙(DIP) 따름

<br>

<h3>06. Observer Pattern</h3>

* 변화가 일어났을 때, 미리 등록된 다른 클래스에 통보해주는 패턴 구현

* ex. eventListener

<br>

<h3>07. Facade Pattern</h3>

* 건물의 앞쪽 정면이라는 뜻

* 복잡한 의존 관계가 있을 때, 중간에 Facade 객체를 두고, 여기에서 제공하는 Interface만 활용해 기능을 사용하는 방식

* Facade는 자신이 가진 각 클래스의 기능을 명확히 알아야 함

<br>

<h3>08. Strategy Pattern</h3>

* 전략 패턴으로 불리며, 객체 지향의 꽃

* 유사한 행위들을 캡슐화

* 객체의 행위를 바꾸고 싶은 경우 직접 변경하는 것이 아니라, 전략만 변경하여 유연하게 확장

* SOLID 중에서 개방 폐쇄 원칙(OCP)와 의존 역전 원칙(DIP) 따름

* ex. Encoder