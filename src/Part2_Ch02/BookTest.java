package Part2_Ch02;

public class BookTest {

    public static void main(String[] args) {

        // 객체 배열
        Book[] library = new Book[5];

        library[0] = new Book("강1", "안녕");
        library[1] = new Book("강2", "안녕");
        library[2] = new Book("강3", "안녕");
        library[3] = new Book("강4", "안녕");
        library[4] = new Book("강5", "안녕");

        for(Book book : library) {
            System.out.println(book);
            book.showInfo();
        }
    }
}
