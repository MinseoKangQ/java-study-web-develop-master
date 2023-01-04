<h3>01, 02. 여러가지 자료구조</h3>

* 자료구조(Data Structure)란 무엇인가?

  * 프로그램에서 사용할 데이터를 메모리 상에서 관리하는 여러 구현 방법들

  * 효율적인 자료구조 -> 성능 좋은 알고리즘

  * 자료의 효율적인 관리와 프로그램 수행속도는 밀접한 관련

<br>

* 자료구조의 종류

  1) 선형 자료구조
     * 배열(Array) - 선형으로 자료 관리 / 정해진 크기의 메모리를 할당받아 사용 / 자료의 물리적 위치와 논리적 위치 동일
    
     * 연결 리스트(LinkedList) - 선형으로 자료 관리 / 자료 추가 시 메모리 할당받음 / 자료는 링크로 연결 / 자료의 물리적 위치와 논리적 위치 동일하지 않을 수 있음

     * 스택(Stack) - 가장 나중에 입력된 자료가 가장 먼저 출력 (LIFO)

     * 큐(Queue) - 가장 먼저 입력된 자료가 가장 먼저 출력 (FIFO)

  <br>
  
  2) 비선형 자료구조
      * 트리(Tree) - 부모 노드와 자식 노드간의 연결로 이루어진 자료구조

      * 힙(Heap) - 우선 큐(Priority queue) 구현 (Max heap / Min heap)

      * 이진 트리(Binary Tree) - 부모노드에 자식노드가 두 개 이하인 트리

      * 이진 검색 트리(Binary Search Tree) - 자료의 중복 허용 X / 왼쪽 자식 노드는 부모 노드보다 작은 값, 오른쪽 자식 노드는 부모 노드보다 큰 값 / 자료 검색 시간은 평균적으로 log(n) / inorder traversal 탐색 시 자료 정렬됨

      * 그래프(Graph) - 정점과 간선들의 유한 집합 G = (V, E) / 정점(=노드), 간선(=링크) / 방향, 무방향 / 구현 방법(인접 행렬, 인접 리스트) / 탐색 방법(BFS, DFS)

      * 해싱(Hashing) - 자료 검색을 위한 자료 구조 / key(유일) & value / O(1) / 저장되는 메모리 구조 = 해시테이블(슬롯, 버켓)

      * jdk 클래스 : TreeSet, TreeMap (Tree로 시작하는 클래스 정렬 지원), HashMap, Properties

<br>

<h3>03. 배열(Array) 구현하기</h3>

* Array 특징

    * 동일한 데이터 타입을 순서에 따라 관리하는 자료 구조

    * 크기가 정해짐
  
    * 요소 추가/제거 시 다른 요소들의 이동 필요
    
    * 배열의 i번째 요소를 찾는 인덱스 연산이 빠름
    
    * jdk 클래스 : <u>ArrayList, Vector</u>

<br>

<h3>04. 연결리스트(LinkedList) 구현하기</h3>

* LinkedList 특징

    * 동일한 데이터 타입을 순서에 따라 관리하는 자료 구조

    * 노드 + 링크(포인터)

    * 크기가 정해지지 않음

    * 자료가 추가될 때 노드 만큼의 메모리를 할당 받고 이전 노드의 링크로 연결
  
    * 연결리스트의 i번째 요소를 찾는 데 걸리는 시간은 요소의 개수에 비례
    
    * O(n)

    * jdk 클래스 : <u>LinkedList</u>

<br>

<h3>05. 스택(Stack) 구현하기</h3>

* Stack의 특징

    * 맨 마지막 위치(top)에서만 자료룰 추가/삭제/꺼내기 가능

    * Last In First Out (후입선출) 구조

    * 가장 최근 자료를 찾거나 히스토리를 유지하고 이를 무를 때 사용 가능

    * 함수 메모리 호출 순서에 따른 stack 구조

    * jdk 클래스 : <u>Stack</u>

<br>

<h3>06. 큐(Queue) 구현하기</h3>

* Queue의 특징

    * 맨 앞(front)에서 자료 꺼내기/삭제, 맨 뒤(rear)에서 자료 추가

    * First In First Out (선입선출) 구조
    
    * 순차적으로 입력된 자료를 순서대로 처리 시 사용하는 자료구조

    * 콜 센터의 문의 전화, 메세지 큐 등에 활용됨

    * jdk 클래스 : <u>ArrayList</u>

<br>

<h3>07. 무엇이든 담을 수 있는 제네릭(Generic) 프로그래밍</h3>

* 제네릭 자료형 정의

    * 클래스에서 사용하는 변수의 자료형이 여러 개 일 가능성, 해당 메서드는 동일한 경우, 클래스의 자료형을 특정하지 않고 추후 해당 클래스를 사용할 때 지정할 수 있도록 선언하는 것

    * 실제 사용되는 자료형 변환은 컴파일러에 의해 검증됨 -> 안정적임

    * 컬렉션 프레임워크에서 많이 사용됨

    * 자료형 매개변수 T(=type parameter) : 이 클래스를 사용하는 시점에 실제 사용할 자료형 지정, static 변수 사용 불가능

    * E(=element), K(=key), V(=value)


 ```
public class GenericPrinter<T> { // GenericPrinter은 제네릭 자료형
    
    private T material;
    
    public void setMaterial(T material) { 
        this.material = material;
    }
    
    public T getMaterial() {
        return material;
    }
    
    public String toString() {
        return material.toString();
    }
    
}
 ```

<br>

* 다이아몬드 연산자 <>

    * 다이아몬드 연산자 내부에서 자료형 생략 가능

    * 제네릭에서 자료형 추론 (자바 10 이후)
    
    * 사용 예시

```
ArrayList list = new ArrayList<>();

ArrayList list = new ArrayList()
=> var list = new ArrayList();
```

<br>


<h3>08. T extends 클래스 사용하기</h3>

* 상위 클래스의 필요성

    * T 자료형의 범위 제한

    * 상위 클래스에서 선언/정의하는 메서드 활용 가능

    * 상속을 받지 않으면 T는 Object로 변환된어 Object 클래스가 기본으로 제공하는 메서드만 사용 가능

<br>

<h3>09. 제네릭 메서드 활용하기</h3>

* 제네릭 메서드란?
    
    * 자료형 매개변수를 메서드의 매개변수나 반환 값으로 가지는 메서드는 자료형 매개 변수가 하나 이상인 경우도 존재
    
    * 제네릭 클래스가 아니어도 내부에 제네릭 메서드 구현하여 사용 가능

    * public <자료형 매개 변수> 반환형 메서드 이름(자료형 매개변수..) {}

```
public class Point<T, V> {

    T x; V y;
    
    Point(T x, V y) {
        this.x = x;
        this.y = y;
    }
    
    public T getX() { return x; }
    public V getY() { return y; }
    
}
```

<br>

<h3>10. 자바에서 제공되는 자료구조 구현 클래스들 - 컬렉션 프레임워크</h3>

* 컬렉션 프레임워크

    * 프로그램 구현에 필요한 자료구조를 구현해 놓은 JDK 라이브러리

    * java.util 패키지에 구현되어 있음

    * 개발에 소요되는 시간을 절약하며 최적화 된 알고리즘 사용 가능

    * 구현 클래스와 인터페이스의 활용에 대한 이해 필요

    * ArrayList, Vector, LinkedList, Stack, Queue ⊂ List

    * HashSet, TreeSet ⊂ Set

    * List, Set ⊂ Collection

    * Properties ⊂ Hashtable

    * Hashtable, HashMap, TreeMap ⊂ Map

<br>

* Collection 인터페이스

    * 하나의 객체를 관리하기 위한 메서드가 선언된 인터페이스

<br>

* List 인터페이스

    * 객체를 순서에 따라 저장하고 관리하는데 필요한 메서드가 선언된 인터페이스

    * 자료구조 리스트(배열, 연결리스트) 구현을 위한 인터페이스

    * 중복 허용

<br>

* Set 인터페이스

    * 순서와 관계없음, 정복 허용하지 않음, 유일한 값을 관리하는데 필요한 메서드 선언됨

    * ex. 아이디, 주민번호, 사번 등 관리

    * 저장된 순서와 출력되는 순서는 다를 수 있음

<br>

* Map 인터페이스

    * 쌍으로 이루어진 객체를 관리하는데 사용하는 메서드들이 선언된 인터페이스

    * 객체는 key-value의 쌍으로 이루어짐
    
    * key는 중복 허용하지 않음

<br>

<h3>11. 순차적으로 자료를 관리하는 List 인터페이스를 구현한 클래스와 그 활용

<br>

<h3>12. Collection 요소를 순회하는 Iterator</h3>

* 요소의 순회란?

    * 컬렉션 프레임워크에 저장된 요소들을 하나씩 차례대로 순회하는 것
    
    * 순서가 있는 List 인터페이스는 Iterator 사용하지 않고 get(i) 메서드 활용

    * Set 인터페이스는 get(i) 메서드가 제공되지 않으므로 Iterator 활용하여 객체 순회

<br>

* Iterator 사용하기

    * boolean hasNext() : 이후에 요소가 더 존재하는지 확인하는 메서드, 요소 존재 시 true 반환

    * E next() : 다음 요소를 반환 

    * 사용 예시

```
Iterator<Member> ir = arrayList.iterator();
while(ir.hasNext()) {
    Member member = ir.next();
    int tempId = member.getMemberId();
    System.out.println(tempId);    
}
```

<br>

<h3>13. 중복되지 않게 자료를 관리하는 Set 인터페이스를 구현한 클래스와 그 활용</h3>

* HashSet 클래스

    * <u>멤버의 중복 여부를 체크하기 위해 인스턴스의 동일성 확인 필요</u>

    * 동일성 구현을 위해 equals()와 hashCode 메서드 재정의 필요

```
@Override
public int hashCode() { return memberId; }

@Override
public boolean equals(Object obj) {
    
    if(obj instanceof Member) {
        Member member = (Member)obj;
        if(this.memberId == member.memberId) return true;
        else return false;
    }
    return false;

}
```

<br>

<h3>14. 정렬을 위해 Comparable과 Comparator 인터페이스 구현하기</h3>

* TreeSet 클래스 활용하기

    * 객체의 정렬에 사용하는 클래스

    * Set 인터페이스 구현 -> 중복 허용하지 않음, 오름차순/내림차순으로 객체 정렬 가능

    * 내부적으로 이진검색트리(binary search tree)로 구현됨

    * 이진검색트리에 저장하기 위해 각 객체 비교해야 함

    * 비교 대상이 되는 객체에 Comparable이나 Comparator 인터페이스를 구현해야 TreeSet에 추가 가능

    * String 클래스는 이미 Comparable 인터페이스가 구현되어 있음
    
    * 사용 예시

```
// Member.java
public class Member implements Comparable<Member> {

    @Override
    public int compareTo(Member member) {
        // return (this.memberId - member.memberId); // 오름차순
        return (this.memberId - member.memberId) * (-1); // 내림차순
    }

}

// ComparatorTest.java
class MyCompare implements Comparator<String> {

    @Override
    public int compare(String s1, String s2) {
        return (s1.compareTo(s2)) * (-1);
    }
    
}

public class ComparatorTest {

    public static void main(String [] args) {
        
        Set<String> set = new TreeSet<String>(new MyCompare());
        set.add("aaa"); 
        set.add("bbb"); 
        set.add("ccc");
        System.out.println(set);
    }
    
}
```

<br>

<h3>15. 쌍(pair)로 자료 관리하는 Map 인터페이스를 구현한 클래스와 그 활용</h3>

* HashMap 클래스 활용하기

    * key와 value를 쌍으로 관리하는 메서드 구현

    * 검색을 위한 자료구조

    * key로 값을 저장하고, key로 값을 꺼내옴 (by hash 알고리즘)
    
    * key가 되는 객체는 중복 불가능, 객체의 유일성 비교를 위해 equals()와 hashCode() 메서드 구현해야 함

<br>

* TreeMap 클래스

    * Map 인터페이스를 구현한 클래스

    * key에 대한 정렬 구현 가능

    * key가 되는 클래스에 Comparable이나 Comparator 인터페이스 구현함으로써 key-value 쌍의 자료를 key값 기준으로 정렬하여 관리 가능

<br>