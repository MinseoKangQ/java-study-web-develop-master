package Part2_Ch06._06;

import java.util.Arrays;
import java.util.function.BinaryOperator;

// 인터페이스 이용하여 구현
class CompareString implements BinaryOperator<String> {

    @Override
    public String apply(String s1, String s2) {
        if(s1.getBytes().length >= s2.getBytes().length) return s1;
        else return s2;
    }
}

public class ReduceTest {

    public static void main(String [] args) {

        // 람다식으로 구현
        String greetings[] = {"안녕하세요!!!!", "hello", "Good Morning", "반갑습니다^^"};
        System.out.println(Arrays.stream(greetings).reduce("", (s1, s2) ->
        {   if(s1.getBytes().length >= s2.getBytes().length) return s1;
            else return s2;}));

        // 인터페이스 이용하여 구현
        String str = Arrays.stream(greetings).reduce(new CompareString()).get();
        System.out.println(str);

    }

}
