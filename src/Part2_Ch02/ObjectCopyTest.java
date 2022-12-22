package Part2_Ch02;

public class ObjectCopyTest {

    public static void main(String[] args) {

        // 객체 배열
        Book[] library = new Book[5];
        Book[] copyLibrary = new Book[5];

        library[0] = new Book("강1", "안녕");
        library[1] = new Book("강2", "안녕");
        library[2] = new Book("강3", "안녕");
        library[3] = new Book("강4", "안녕");
        library[4] = new Book("강5", "안녕");

        copyLibrary[0] = new Book();
        copyLibrary[1] = new Book();
        copyLibrary[2] = new Book();
        copyLibrary[3] = new Book();
        copyLibrary[4] = new Book();

        // 깊은 복사
        for(int i = 0; i<library.length; i++) {
            copyLibrary[i].setAuthor(library[i].getAuthor());
            copyLibrary[i].setTitle(library[i].getTitle());
        }

        System.arraycopy(library, 0, copyLibrary, 0, 5);

        System.out.println("== library == ");
        for(Book book : library) {
            System.out.println(book);
            book.showInfo();
        }

        System.out.println("== copy library == ");
        for(Book book : copyLibrary) {
            System.out.println(book);
            book.showInfo();
        }

        // 얕은 복사
        System.out.println();
        library[0].setAuthor("강강");

        System.out.println("== library == ");
        for(Book book : library) {
            System.out.println(book);
            book.showInfo();
        }

        System.out.println("== copy library == ");
        for(Book book : copyLibrary) {
            System.out.println(book);
            book.showInfo();
        }

    }
}
