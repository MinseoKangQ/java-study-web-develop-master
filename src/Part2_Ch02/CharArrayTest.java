package Part2_Ch02;

public class CharArrayTest {

    public static void main(String [] args) {

        // 문자형 배열
        char [] alphabets = new char[26];
        char ch = 'A';

        for(int i = 0; i<alphabets.length; i++) {
            alphabets[i] = ch++;
        }

        for(char alpha : alphabets) {
            System.out.println(alpha + ", " + (int)alpha);
        }

    }
}
