package Part2_Ch02;

public class TwoDimensionTest {

    public static void main(String [] args) {

        // 2차원 배열
        int [][] arr = {{1, 2, 3}, {1, 2, 3, 4}};

        int i, j;
        for(i = 0; i<arr.length; i++) { // 행의 길이 만큼 반복
            for(j = 0; j<arr[i].length; j++) { // 열의 길이 만큼 반복
                System.out.println("\t" + arr[i].length);
            }
        }
    }

}
