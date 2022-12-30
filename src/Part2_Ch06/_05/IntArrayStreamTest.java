package Part2_Ch06._05;

import java.util.Arrays;
import java.util.stream.IntStream;

public class IntArrayStreamTest {

    public static void main(String [] args) {

        int [] arr = { 1, 2, 3, 4, 5 };

        for(int num : arr) {
            System.out.println(num);
        }

        System.out.println();

        // 스트림은 한 번 밖에 못 씀
        // 다시 쓰려면 스트림은 재생성 해야 함
        IntStream is = Arrays.stream(arr);
        is.forEach(n->System.out.println(n));


        // Arrays.stream(arr).forEach(n->System.out.println(n));

//        IntStream is = Arrays.stream(arr);
//        is. // 다양한 연산 가능
    }

}
