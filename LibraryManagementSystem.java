package schoolman;

class DynamicArray<T> {
    private final T[] array;
    private int count;
    private static final int CAPACITY = 100;

    @SuppressWarnings("unchecked")
    public DynamicArray() {
        array = (T[]) new Object[CAPACITY];
        count = 0;
    }

    public void add(T element) {
        if (count < CAPACITY) {
            array[count++] = element;
        }
    }

    public T remove(int index) {
        if (index >= 0 && index < count) {
            T removed = array[index];
            for (int i = index; i < count - 1; i++) {
                array[i] = array[i + 1];
            }
            array[--count] = null;
            return removed;
        }
        return null;
    }

    public T get(int index) {
        if (index >= 0 && index < count) {
            return array[index];
        }
        return null;
    }

    public int size() {
        return count;
    }
}

class Book {
    private final String title;
    private final String author;
    private final String price;

    public Book(String title, String author, String price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Price: " + price;
    }
}

class Library {
    private final DynamicArray<Book> books;

    public Library() {
        books = new DynamicArray<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public Book removeBook(int index) {
        return books.remove(index);
    }

    public Book getBook(int index) {
        return books.get(index);
    }

    public int getTotalBooks() {
        return books.size();
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        Book book1 = new Book("Kingdom", "Yusahira Hara", "$10.99");
        Book book2 = new Book("One Piece", "Eiichiro Oda", "$11.99");

        library.addBook(book1);
        library.addBook(book2);

        System.out.println("Total books: " + library.getTotalBooks());
        System.out.println("Book at index 0: " + library.getBook(0));
        System.out.println("Book at index 1: " + library.getBook(1));

        Book removed = library.removeBook(0);
        System.out.println("Removed book: " + removed);
        System.out.println("Total books after removal: " + library.getTotalBooks());
    }
}