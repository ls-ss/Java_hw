import java.util.Arrays;

public class Reader {
    private final String name;
    private final int libraryCardNumber;
    private final String faculty;
    private final String dateOfBirth;
    private final String phoneNumber;

    public Reader(String name, int libraryCardNumber, String faculty, String dateOfBirth, String phoneNumber) {
        this.name = name;
        this.libraryCardNumber = libraryCardNumber;
        this.faculty = faculty;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return this.libraryCardNumber + " " + name + " " + phoneNumber;
    }

    public void getAllReaderInformation() {
        System.out.println("ФИО: " + name + ", Читательский билет №" + libraryCardNumber + ", Факультет: " + faculty +
                           ", Дата рождения: " + dateOfBirth + ", Телефон: " + phoneNumber + ";");
    }

    public void takeBook(int booksCount) {
        System.out.println(name + " взял: " + booksCount + " книги");
    }

    public void takeBook(Book book) {
        System.out.println(name + " взял книгу: " + book.toString());
    }

    public void takeBook(Book... books) {
        System.out.println(name + " взял книги: " + Arrays.toString(books));
    }

    public void returnBook(int booksCount) {
        System.out.println(name + " вернул: " + booksCount + " книги");
    }

    public void returnBook(Book book) {
        System.out.println(name + " вернул книгу: " + book.toString());
    }

    public void returnBook(Book... books) {
        System.out.println(name + " вернул книги: " + Arrays.toString(books));
    }
}
