<h3>01. 여러 내부 클래스의 정의와 유형</h3>

* 내부 클래스란? (inner class) (= 중첩클래스)

  * 클래스 내부에 선언한 클래스

  * 해당 클래스를 감싸고 있는 외부 클래스와 밀접한 연관이 있음

  * 다른 외부 클래스에서 사용할 일이 거의 없을 때 내부 클래스로 선언하여 사용

  * 내부 클래스 종류

    * 인스턴스 내부 클래스

    * 정적(static) 내부 클래스

    * 지역(local) 내부 클래스
  
    * 익명(anonymous) 내부 클래스

<br>

* <u>인스턴스 내부 클래스</u>

  * private로 선언 권장

  * 외부 클래스가 생성된 이후에 생성

  * private가 아닌 내부 클래스는 다른 외부 클래스에서 생성 가능

  * 인스턴스 내부 클래스에서 자신의 정적 변수/메서드 선언/사용 불가능

```
OutClass outClass = new OutClass();
OutClass.InClass inClass = outClass.new InClass();
```

<br>

```
Class OutClass {

  private InClass inClass; // 내부 클래스 변수 선언
  
  public OutClass() {
    inClass = new InClass(); // 내부 클래스 생성
  }
  
  clss InClass { // 내부 클래스 작성
    void inTest() { System.out.println("InClass inTest 실행"); }
  }
  
  public void usingClass() {
      inClass.inTest(); // 내부 클래스 변수 이용하여 메서드 호출
      System.out.println("usingClass 호출");
    }
    
}

public class InnerTest {

  public static void main(String [] args) {
    OutClass outClass = new OutClass();
    // 혹은 외부 클래스 이용하여 내부 클래스 생성
    // OutClass.InClass inClass = outClass.new InClass();
    outClass.usingClass(); // 내부 클래스 기능 사용
  }
  
}
```

<br>

* <u>정적 내부 클래스</u>

  * 외부 클래스 생성과 무관하게 사용 가능

  * 정적 변수/메서드 사용

  * 정적 클래스의 일반 메서드 : 외부 클래스의 인스턴스 변수 사용 불가능

  * 정적 내부 클래스의 static 메서드 : 외부 클래스의 인스턴스 변수, 내부 클래스의 인스턴스 변수 사용 불가능
```
class OutClass  {

  static class InStaticClass {
    
    void inTest() { // 정적 클래스의 일반 메서드
      System.out.println("정적 클래스의 일반 메서드 호출");
      System.out.println("외부 클래스의 인스턴스 변수 사용 불가능");
    }
    
    static void sTest() { // 정적 클래스의 static 메서드
      System.out.println("외부 클래스의 인스턴스 변수 사용 불가능");
      System.out.println("내부 클래스의 인스턴스 변수 사용 불가능");
  }
  
}

public class InnerTest {

  public static void main(String [] args) {
  
  // 외부 클래스 생성하지 않고 바로 정적 내부 클래스 생성 가능
  OutClass.InStaticClass sInClass = new OutClass.InStaticClass();
  sInClass.inTest();
  OutClass.InStaticClass.sTest();
  
  }
  
}

```

<br>

* <u>지역 내부 클래스</u>

  * 메서드 내부에서 정의하여 사용하는 클래스

  * 메서드 호출이 끝나면 메서드에 사용된 지역변수의 유효성 없어짐

  * 지역 내부 클래스에서 사용하는 메서드의 지역 변수나 매개 변수는 final로 선언됨

```
class Outer {
  
  int outNum = 100;
  static int sNum = 200;
  
  Runnable getRunnable(int i) {
    
    int num = 100;
    
    class MyRunnalbe implements Runnable {
      
      int localNum = 10;
      
      @Override
      public void run() {
        // num = 200; i = 100; // 에러 발생 (지역 변수, 매개 변수 모두 상수 취급 됨)
        // System.out.println -> i, num, localNum, outNum, Outer.sNum 사용 가능
      }
      
      return new MyRunnable();
     }
    
  }
  
}

public class LocalInnerTest {

  public static void main(String [] args) {
  
    Outer out = new Outer();
    Runnable runner = out.getRunnable(10);
    runner.run();
  }

}
```

<br>

* <u>익명 내부 클래스</u>

  * 이름이 없는 클래스

  * 클래스 이름은 생략하고 하나의 인터페이스/추상클래스 구현하여 반환

  * 위젯의 이벤트 핸들러에 활용됨

```
class Outter2 {

  Runnable getRunnable(int i) {
    
    int num = 100;
    
    return new Runnable() {
  
      @Override
      public void run() {
        // num = 200; i = 10; // final -> 에러
        // System.out.println -> i, num 가능  
      }    
    };
  }
  
  Runnable runner = new Runnable() {
  
    @Override
    public void run() {
      System.out.println("Runnable이 구현된 익명 클래스");
    }
  };
  
}

public class AnnoymousInnerTest {

  public static void main(String [] args) {
  
    Outter2 out = new Outer2();
    
    Runnable runnable = out.getRunnable(10);
    runnable.run();
    
    out.runner.run();
    }
    
}
```

<br>

<h3><u>02. 람다식(Lambda expression)</u></h3>

* 함수형 프로그래밍과 람다식

  * 자바는 객체 지향 프로그래밍

  * 자바 8부터 함수형 프로그래밍 방식을 지원, 이것을 람다식이라고 함

  * <b>함수의 구현과 호출만으로 프로그래밍이 행되는 방식</b>
  
  * 함수형 프로그래밍(Functional Programming = FP)

    * 순수 함수를 구현하고 호출함으로 외부 자료에 부수적인 영향 주지 않도록 구현하는 방식

    * 순수 함수란 매개변수만을 사용하여 만드는 함수

    * 입력받는 자료 이외에 외부 자료를 사용하지 않음

    * 여러 자료가 동시에 수행되는 병렬처리가 가능

    * 함수의 기능이 자료에 독립적임을 보장

    * 동일한 자료에 대해 동일한 결과 보장

    * 다양한 자료에 대해 같은 기능 수행 가능

<br>

* <b>람다식 문법</b>

  * (매개변수) -> { 실행문; }

1) 객체 지향 프로그래밍 vs 함수형 프로그래밍
2) 매개변수가 하나인 경우 자료형과 괄호 생략 가능
3) 매개변수가 두 개 이상이면 괄호 생략 불가능
4) 실행문이 한 문장인 경우 중괄호 생략 가능
5) 실행문이 한 문장이라도 return문(반환문)은 중괄호 생략 불가능
6) 실행문이 한 문장의 반환문인 경우 return과 중괄호 모두 생략 가능

<br>

```
// 1) 객체 지향 프로그래밍 vs 함수형 프로그래밍
int add(int x, int y) { return x+y; }
(int x, int y) -> { return x+y; }

// 2) 매개변수가 하나인 경우 자료형과 괄호 생략 가능
str -> { System.out.println(str); }

// 3) 매개변수가 두 개 이상이면 괄호 생략 불가능
// x,y -> { System.out.println(x+y); } // 오류

// 4) 실행문이 한 문장인 경우 중괄호 생략 가능
str -> System.out.println(str);

// 5) 실행문이 한 문장이라도 return문(반환문)은 중괄호 생략 불가능
// str -> return str.length(); // 오류

// 6) 실행문이 한 문장의 반환문인 경우 return과 중괄호 모두 생략 가능
(x,y) -> x+y;
str -> str.length;
```

<br>

<h3>03. 함수형 인터페이스와 람다식 구현하여 사용하기</h3>

* 함수형 인터페이스 선언하기

  * 람다식을 선언하기 위한 인터페이스

  * 익명 함수와 매개변수만으로 구현됨 -> 인터페이스는 단 하나의 메서드만을 선언해야함

  * @FunctionalInterface annotation : 함수형 인터페이스를 의미, 내부에 여러 개 메서드 선언 시 에러 발생

```
@FunctionalInterface
public interface MyNumber {
  int getMax(int num1, int num2);
}

public class TestMyNumber {
  
  public static void main(String [] args) {
    MyNumber max = (x, y)-> (x>=y) ? x:y; 
    System.out.println(max.getMax(10, 20));
  }
  
}
```

<br>

<h3>04. 객체지향 프로그래밍 vs 람다식 구현</h3>

* 문자열 두 개를 연결하여 출력

* 인터페이스 선언

```
public interface StringConcat {
  public void makeString(String s1, String s2);
}
```

<br>

* 객체 지향 프로그래밍으로 구현

```
public class StringConCatImpl implements StringConcat {
  @Override
  public void makeString(String s1, String s2) {
    System.out.println(s1 + ", " + s2);   
  }
}

public class TestStringConcat {
  
  public static void main(String [] args) {
    String s1 = "Hello";
    String s2 = "World";
    StringConCatImpl concat = new StringConCatImpl();
    concat.makeString(s1, s2);
  }
  
}
```

<br>

* 람다식으로 구현

```
public class TestStringConcat {
  
  public static void main(String [] args) {
    StringConcat concat = (s, v) -> System.out.println(s + ", " + v);
    concat.makeString(s1, s2);
  }
  
}
```

<br>

* 익명 객체를 생성하는 람다식

  * 람다식을 구현하면 익명 내부 클래스가 만들어지고, 이를 통해 익명 객체가 생성됨

  * 익명 내부 클래스에서와 같이 람다식 내부에서도 외부 지역 변수 값을 변경하면 오류 발생

<br>

* <u>함수를 변수처럼 사용하는 람다식</u>

* 인터페이스형 변수에 람다식 대입

```
interface PrintString { void showString(String str); }

PrintString lambdaStr = s -> System.out.println(s); // 람다식을 변수에 대입
lambdaStr.showString("hello lambda_1");
```

<br>

* 매개변수로 전달하는 람다식

```
showMyString(lambdaStr);

public static void showMyString(PrintString p) {
  p.showString("hello lambda_2");
}
```

<br>

* 반환 값으로 쓰이는 람다식

```
public static PrintString returnString() {
  return s -> System.out.println(s + "world");
}

PrintString reStr = returnString();
reStr.showString("hello");
```