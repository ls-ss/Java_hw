public class Book {
    private final String name;
    private final String authorName;

    public Book(String name, String authorName) {
        this.name = name;
        this.authorName = authorName;
    }

    @Override
    public String toString() {
        return name + " (" + authorName + ")";
    }
}
