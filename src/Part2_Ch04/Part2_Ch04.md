<h3>01. Object 클래스 - 모든 클래스의 최상위 클래스</h3>

* java.lang 패키지

  * 자동으로 import 됨 (import.java.lang.*;)

  * 기본 클래스들이 속한 패키지 (ex. String, Integer, System 등)

<br>

* 모든 클래스는 Object 클래스를 상속받음

  * java.lang.Object

  * 모든 클래스는 Object 클래스에서 상속받음

  * Object 클래스 메서드 중 일부는 재정의하여 사용 가능

<br>

* <u>toString() 메서드</u>

  * 객체의 정보를 String으로 바꾸어 사용 시 쓰임
  
 ```
 class Book {
  ...
  ...
  public String toString() { return title + "," + author; }
 }
 
 public class BookTest {
  public static void main(String [] args) {
    Book book = new Book("abc", "def"); // 객체 생성
    System.out.println(book);
  }
 }
 ```

<br>

<h3>02. Object 클래스의 메서드 활용</h3>

* equals() 메서드

  * 두 인스턴스의 주소 값을 비교해 true/false 반환

  * 두 인스턴스가 논리적으로 동일함으로 재정의 가능 (ex. 같은 학번, 사번, 아이디 등)

<br>

* hashCode() 메서드

  * hashCode()는 인스턴스의 저장 주소 반환
  
  * 힙 메모리에 인스턴스가 저장되는 방식이 hash 방식

  * hash : 정보를 저장/검색하는 자료구조

  * <b><u>논리적으로 동일함을 나타내려고 equals() 메서드 재정의 하였다면 hashCode() 메서드 또한 재정의 필요</u></b>

  * hashCode() 메서드를 재정의 한 경우 원래의 hashCode를 알아내려면

 ```
System.identityHashCode(변수명)
 ```

<br>

* clone() 메서드

  * 객체의 원본을 복제 시 사용하는 메서드

  * 사용 시 객체의 정보가 동일한 또 다른 인스턴스가 생성되는 것 -> 객체 지향 프로그래밍 관점에서 위배될 수 있음

  * implements Cloneable 명시해줘야 함

```
// Student.java
public class Student implements Cloneable {
  ..
  @Override
  protected Object clone() throws CloneNotSupportedException {
    return super.clone();
  }
}

// EqualTest.java
Student Lee3 = (Student)Lee.clone();
```

<br>

<h3>03. String, StringBuilder, StringBuffer 클래스, text block</h3>

* String 클래스

  * 힙 메모리에 인스턴스로 생성 : 생성될 때 마다 다른 주소 값 가짐

  * 상수 풀(constant pool)에 있는 주소 참조 : 모두 같은 주소 값 가짐

  * 한 번 생성된 String은 불변
  
  * String 연결 (ex. concat) 시 새로운 문자열이 생성 -> 메모리 낭비 발생  

```
// 1
String str1 = new String("abc");

// 2
String str2 = "abc";
```

<br>

* StringBuilder, StringBuffer 활용하기

  * 내부적으로 <u>가변적인 char[]</u> 멤버 변수로 가짐
  
  * 문자열 연결/변경 시에 사용하면 유용

  * StringBuilder - 단일 스레드 프로그램

  * StringBuffer - 멀티 스레드 프로그램 (동기화 보장)

<br>

* text block 사용 (java 13)

  * 문자열을 """ """ 사이에 이어서 만들기 가능

  * html, json 문자열 만들 때 유용

<br>

<h3>04. Class 클래스 사용하기</h3>

* Class 클래스

  * 자바의 모든 클래스와 인터페이스는 컴파일 후 class 파일 생성

  * Class 클래스는 컴파일된 class 파일을 로드하여 객체를 동적으로 로드, 정보를 가져오는 메서드 제공

```
// Class.forName("클래스 이름") 메서드로 클래스르 동적으로 로드 가능
Class c = Class.forName("java.lang.String");

// 클래스 이름으로 직접 클래스 가져오기
Class c = String.class;

// 생성된 인스턴스에서 Class 클래스 가져오기
String s = new String();
Class c = s.getClass(); // Object 메서드
```

<br>

* 동적 로딩

  * 컴파일 시 데이터 타입 binding (X)
  
  * 실행(runtime) 시 데이터 타입 binding (O)

  * 실행 시 원하는 클래스 로딩하여 binding 할 수 있는 장점

  * 동적 로딩 시 오류가 발생하면 프로그램 다운 가능성 존재

<br>

* Class의 newInstance() 메서드로 인스턴스 생성

  * new 키워드 사용하지 않고 클래스 정보를 활용하여 인스턴스 생성 가능

<br>

* 클래스 정보 알아보기

  * <b><u>reflection 프로그래밍</u></b> : Class 클래스 사용해 클래스의 정보를 알 수 있고, 인스턴스 생성이 가능하고, 메서드를 호출하는 방식의 프로그래밍

  * 로컬 메모리에 객체가 없는 경우 / 원격 프로그래밍 / 객체의 타입을 알 수 없는 경우에 사용

  * java.lang.reflection 패키지에 있는 클래스 활용하여 프로그래밍
  
  * 일반적으로 자료형을 알고 있는 경우에는 사용하지 않음