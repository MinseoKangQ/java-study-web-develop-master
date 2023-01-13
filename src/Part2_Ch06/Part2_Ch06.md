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

<br>

<h3>05. 스트림(Stream)</h3>

* 스트림이란?

  * <u><b>자료의 대상관 관계없이 동일한 연산을 수행</b></u>
  
    * 배열, 컬렉션을 대상으로 연산 수행

    * 일관성 있는 연산으로 자료 처리를 쉽고 간단히 함

    * 자료 처리에 대한 추상화가 구현되었음

  * <u><b>한 번 생성하고 사용한 스트림은 재사용 불가능</b></u>
  
    * 자료에 대한 스트림 생성하여 연산 수행 시 스트림은 소모됨

    * 다른 연산 수행하려면 스트림을 다시 생성해야함

  * <u><b>스트림 연산은 기존 자료를 변경하지 않음</b></u>

    * 자료에 대한 스트림 생성 시 스트림이 사용하는 메모리 공간은 별도로 생성됨

    * 연산이 수행되어도 기존 자료에 대한 변경은 발생하지 않음

  * <u><b>스트림 연산 = 중간 연산 / 최종 연산</b></u>

    * 중간 연산은 여러 개의 연산 적용 가능
    
    * 최종 연산은 마지막에 한 번만 적용됨

    * 최종 연산이 호출되어야 중간 연산에 대한 수행이 이뤄지고 결과가 만들어짐

    * 중간 연산에 대한 결과를 연산 중에 알 수 없음 = 지연 연산

<br>

* 스트림 생성 및 사용

```
public class IntArrayTest {

  public static void main(String [] args) {
    
    int [] arr = { 1, 2, 3, 4, 5 };
    
    int sumVal = Arrays.stream(arr).sum();
    long count = Arrays.stream(arr).count();
    
    System.out.println(sumVal);
    System.out.println(count);
    
  }

}
```

<br>

* 중간 연산과 최종 연산

  * 중간 연산과 최종 연산에 대한 구현은 람다식 활용 

  * 중간 연산
    
    * ex) filter()(조건에 맞는 요소 추출), map()(요소 변환), sorted() 등

    * 최종 연산이 호출될 때 중간 연산이 수행, 이후 결과가 생성

  * 최종 연산

    * ex) forEach(), count(), sum() 등

    * 스트림이 관리하는 자료를 하나씩 소모해가며 연산 수행

    * 최종 연산 후에 스트림은 더 이상 다른 연산 적용 불가능

```
// 문자열 리스트에서 문자열의 길이가 5 이상인 요소 출력
sList.stream().filter(s->s.length() >= 5).forEach(s->System.out.print(s + " "));

// 고객 클래스 배열에서 고객 이름만 출력
customerList.stream().map(c->c.getName()).forEach(s->System.out.println(s));
```

<br>

* ArrayList 객체에 스트림 생성하고 사용하기

```
public class ArrayListStreamTest {

  public static void main(String [] args) {
    
    List<String> sList = new ArrayList<String>();
    sList.add("A");
    sList.add("CABCDDD");
    sList.add("BBBF);
    
    Stream<String> stream = sList.stream();
    stream.forEach(s->System.out.print(s + " "));
    System.out.println();
    
    sList.stream().sorted().forEach(s->System.out.println(s + " "));
    sList.stream().map(s->s.length()).forEach(n->System.out.println(n));
    sList.stream().filter(s->s.length() >= 5).forEach(n->System.out.println(n));
    
   }
   
}
```

<br>

```

public class IntArrayStreamTest {

  public static void main(String [] args) {
  
    int [] arr = { 1, 2, 3, 4, 5 };
    Arrays.stream(arr).forEach(n->System.out.println(n + " "));
    
    int sum = Arrays.stream(arr).sum();
    System.out.println(sum);
    
    List<Integer> list = new ArrayList<Integer>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);
    
    int sum2 = list.stream().mapToInt(n->n.intValue()).sum();
    System.out.println(sum2);
  
  }

}
```

<br>

<h3>06. 연산 수행에 대한 구현을 할 수 있는 reduce() 연산</h3>

* reduce() 연산

  * 정의된 연산이 아닌 프로그래머가 직접 구현한 연산 적용

  * 최종 연산으로 스트림의 요소를 소모하여 연산 수행

  * reduce() 메서드의 두 번째 요소로 전달되는 람다식에 따라 다양한 기능 수행 가능

  * 람다식을 직접 구현하거나 람다식이 긴 경우 BinaryOperator를 구현한 클래스 사용

  ```
  T reduce(T identify, BinaryOperator<T> accumulator)
  
  // 배열의 모든 요소의 합을 구하는 연산
  Arrays.stream(arr).reduce(0, (a,b)->a+b));
  ```

<br>

<h3>08. 예외 처리의 필요성, 자바에서 제공되는 클래스들</h3>

* 프로그램에서의 오류

  * 컴파일 오류(Complie Error)
  
    * 프로그램 코드 작성 중 발생하는 문법적 오류

    * 개발 환경에서 대부분 detection 가능
  
  * 실행 오류(Runtime Error)

    * 실행 중인 프로그램이 의도치 않은 동작을 하거나 프로그램이 중지되는 오류

    * 실행 오류는 비정상 오류가 발생 시 심각한 장애 유발

<br>

* 예외 처리의 중요성

  * 프로그램의 비정상 종료를 피해 시스템이 원활히 실행되도록 함

  * 실행 오류가 발생 시 오류 과정 전체를 재현하는 것이 어려움

  * 오류 발생 시 log 남겨 그 원인을 파악하여 버그 수정하는 것이 중요

<br>

* 오류와 예외 클래스

  * 시스템 오류(Error) 

    * 가상 머신에서 발생

    * 프로그래머가 처리 불가능한 오류

    * 동적 메모리가 없는 경우 (ex. 스택 메모리 오버플로우 등)

  * 예외(Exception) 

    * 프로그램에서 제어 가능한 오류
  
    * 읽어들이려는 파일이 존재하지 않는 경우, 네트워크나 DB연결이 작동하지 않는 경우 등

    * 자바는 안정성이 중요함

    * 프로그램에서 발생하는 오류에 대해 문법적인 예외 처리가 필요

<br>

* 예외 클래스들

  * 모든 예외 클래스의 최상의 클래스는 Exception 클래스

  * 자바에서는 다양한 예외들에 대해 해당 처리를 위한 클래스가 제공됨

  * ArithmeticException 
  
  * NullPointException
  
  * ArrayIndexOutOfBoundsException

  * FileNotFoundException

  * ClassNotFoundException

  * InterruptedException

<br>

<h3>09. 예외 처리하기와 미루기</h3>

* try-catch 문

```
  try { 예외 발생 가능 코드 }
  catch(처리할 예외 타입 e) { try 블록에서 예외 발생 시 예외 처리 부분 }
```

<br>

* try-catch-finally 문
  
  * finally 블럭에서 파일/네트워크 닫는 등의 리소스 해제 구현

  * try {} 블럭 수행 시, finally 블럭 항상 수행

  * 여러 개의 예외 블럭이 존재하는 경우, 각각에서 리소스 해제하지 않고 finally 블록에서 해제하도록 구현

<br>

* try-with-resources 문

  * 리소스 사용하는 경우 close() 하지 않아도 자동으로 해제

  * 자바 7부터 제공되는 구문

  * 리소스를 try() 내부에서 선언해야 함

  * close()를 명시적으로 호출하지 않아도 try {} 블록에서 열린 리소스는 정상적인 경우 혹은 예외가 발생한 경우 모두 자동으로 해제됨

  * 해당 리소스 클래스가 AutoCloseable 인터페이스 구현해야함

  * 자바 9부터 리소스는 try() 외부에서 선언하고 변수만을 try(obj)와 같이 사용 가능

<br>

* 예외 처리 미루기

  * try-catch 블록으로 처리하는 방법

  * 사용하는 부분에서 처리하는 방법 (by throws)

<br>

* 하나의 try {} 블록에서 예외가 여러개 발생하는 경우

  * 예외를 묶어서 한번에 처리 가능 (by | 연산자)

  * 각각의 예외를 따로 처리 가능

  * Exception 클래스로 default 처리 시 Exception 블록은 맨 마지막에 위치해야 함

<br>

<h3>10. 사용자 정의 예외 클래스와 그 활용</h3>

* 사용자 정의 예외 클래스 구현하기

  * 자바에서 제공되는 예외 클래스 외에 프로그래머가 직접 작성해야 하는 예외가 있을 수 있음

  * 기존 예외 클래스 중 가장 유사한 예외 클래스에서 상속받아 사용자 정의 예외 클래스 작성

  * 기본적으로 Exception 클래스 상속해서 작성 가능

  * ex. 패스워드에 대한 예외 처리

<br>

<h3>11. 오류 로그 남기기 - java.util.logging.Logger 활용</h3>

* logging

  * 시스템 운영에 대한 기록

  * 오류 발생 시 해당 오류에 대한 기록 남겨 디버깅 용이하게 함

  * 로그 파일에 기록하는 코드 추가 -> 필요한 정보가 로그로 남을 수 있도록 함

  * 로그의 적당함도 중요

<br>

* java.util.logging

  * 자바에서 기본적으로 제공하는 log package
  
  * 파일이나 콘솔에 로그 내용 출력 가능

  * jre/lib/logging.properties 파일 편집하여 로그의 출력방식/레벨 변경 가능

  * logging 패키지에서 제공하는 로그 레벨은 severe, warning, info, config, fine, finer, finest

  * 오픈소스로 log4j 많이 사용함

<br>

<h3>20. 자바에서 Thread 만들기</h3>

* Thread란?

  * Process : 실행 중인 프로그램이 실행되면 OS로부터 메모리 할당받아 프로세스 상태가 됨

  * Thread : 하나의 프로세스는 하나 이상의 Thread 가짐, 실제 작업의 수행 단위는 Thread

<br>

* multi-threading

  * 여러 Thread가 동시에 수행되는 프로그래밍

  * 여러 작업이 동시에 실행되는 효과

  * Thread는 자신만의 작업 공간을 가짐 -> context

  * 각 Thread에서 공유하는 자원 존재 가능 (ex. static instance)
  
  * Race condition 발생 가능 (여러 Thread가 자원을 공유하여 작업이 수행되는 경우 자원을 서로 차지하려고 하는 것)

  * 여러 Thread가 공유하는 자원 중 경쟁이 발생하는 부분 = critical section
  
  * Critical section에 대한 동기화(순차적 수행) 구현하지 않으면 오류 발생 가능성 존재

<br>

* 자바 Thread 만들기

  * Thread 클래스 상속하여 만들기

  * Runnable 인터페이스 구현하여 만들기 (이미 다른 클래스를 상속한 경우 사용 - 자바는 다중 상속 허용하지 않기 때문)

<br>

<h3>21. Thread 클래스의 여러 메서드들</h3>

* Thread 우선순위

  * Thread.MIN_PRIORITY(=1) ~ Thread.MAX_PRIORITY(=10)

  * 디폴트 우선순위 : Thread.NORMAL_PRIORITY(=5)

  * 우선 순위가 높은 Thread가 CPU 배분을 받을 확률이 높음 (<u>but, 보장하지는 않음</u>)

  * setPriority()/getPriority()

<br>

* <b><u>join()</u></b>

  * 동시에 두 개 이상의 Thread 실행 시 다른 Thread 결과를 참조하여 실행할 경우 사용

  * join() 함수를 호출한 Thread가 not-runnable 상태가 됨

  * 다른 Thread의 수행이 끝나면 runnable 상태로 돌아옴 

<br>

* <b><u>interrupt()</u></b>

  * 다른 Thread에 예외를 발생시키는 interrupt 보냄

  * Thread가 join()/sleep()/wait() 에 의해 not-runnable 상태일 경우 interrupt() 호출하면 다시 runnable 상태가 될 수 있음

<br>

* Thread 종료하기

  * 무한 반복일 경우 while(flag)의 flag 변수 값을 false로 바꾸어 종료

<br>

<h3>22. 멀티 Thread 프로그래밍에서의 동기화</h3>

* Critical Section과 Semaphore

  * Critical Section : 두 개 이상의 Thread가 동시에 접근하는 경우 문제 발생 가능성이 있기 때문에 동시에 접근이 불가능한 영역

  * Semaphore : 특별한 형태의 시스템 객체, get/release 두 개의 기능

  * 한 순간 단 하나의 Thread만 semaphore 얻을 수 있고, critical section에 들어갈 수 있음

  * 나머지 Thread들은 대기(blocking) 상태가 됨

<br>

* <b><u>동기화(synchronization)</u></b>

  * 두 개의 Thread가 같은 객체에 접근할 경우, 동시에 접근하면 오류 발생

  * 동기화는 임계영역에 접근한 경우 공유자원을 lock -> 다른 Thread 접근을 제어

  * 동기화 잘못 구현 시 deadlock 가능성 존재

<br>

* synchronized 메서드나 synchronized 블럭 사용

  * synchronized 블럭 : 현재 객체 또는 다른 객체를 lock
  
  ```
  synchronized(참조형 수식) { 수행문; }
  ```
  
  * synchronized 메서드
  
    * 객체의 메서드에 synchronized 키워드 사용

    * 현재 해당 메서드가 속해있는 객체에 lock

    * 되도록 synchronized 메서드에서 다른 synchronized 메서드는 호출하지 않도록 해야함

<br>

<h3>23. wait()/notify() 메서드를 활용한 동기화 프로그래밍</h3>

* 리소스가 어떤 조건에서 더 이상 유효하지 않은 경우, 리소스를 기다리기 위해 Thread가 wait 상태가 됨

* wait() 상태가 된 Thread는 notify()가 호출될 때 까지 기다림

* 유효한 자원이 생기면 notify()가 호출되고 wait() 상태인 Thread 중 무작위로 하나의 Thread 재시작

* notifyAll() 호출되는 경우 wait() 하고 있는 모든 Thread가 재시작 됨

* 유효한 리소스만큼의 Thread만 수행될 수 있고 자원을 갖지 못한 Thread는 다시 wait() 상태가 됨

* <b><u>자바에서는 notifyAll() 메서드 사용 권장</u></b>