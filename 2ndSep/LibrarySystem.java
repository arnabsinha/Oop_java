// 1. Encapsulation
class Book {
    private String title;
    private String author;
    private int copiesAvailable;

    public Book(String title, String author, int copiesAvailable) {
        this.title = title;
        this.author = author;
        this.copiesAvailable = copiesAvailable;
    }

    // Getters and Setters
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public synchronized int getCopiesAvailable() { return copiesAvailable; }

    public synchronized boolean borrowBook() {
        if (copiesAvailable > 0) {
            copiesAvailable--;
            System.out.println(Thread.currentThread().getName() +
                " borrowed: " + title + " (Remaining: " + copiesAvailable + ")");
            return true;
        } else {
            System.out.println(Thread.currentThread().getName() +
                " tried to borrow: " + title + " but no copies left!");
            return false;
        }
    }

    public synchronized void addCopies(int count) {
        copiesAvailable += count;
        System.out.println(count + " copies of " + title + " added. (Total: " + copiesAvailable + ")");
    }
}

// 2. Inheritance
abstract class User {
    protected String name;
    protected int userId;

    public User(String name, int userId) {
        this.name = name;
        this.userId = userId;
    }

    // 3. Polymorphism (overridden in subclasses)
    public abstract void performAction(Book book);
}

class Student extends User implements Runnable {
    public Student(String name, int userId) {
        super(name, userId);
    }

    // Method overriding
    @Override
    public void performAction(Book book) {
        book.borrowBook();
    }

    // Method overloading
    public void borrowBook(Book book, String author) {
        if (book.getAuthor().equals(author)) {
            book.borrowBook();
        } else {
            System.out.println(name + " could not borrow, author mismatch!");
        }
    }

    @Override
    public void run() {
        // Each student thread borrows the same book
        performAction(LibrarySystem.sharedBook);
    }
}

class Librarian extends User {
    public Librarian(String name, int userId) {
        super(name, userId);
    }

    // Method overriding
    @Override
    public void performAction(Book book) {
        book.addCopies(2); // Librarian updates copies
    }
}

// 4. Multithreading with Library System
public class LibrarySystem {
    // Shared book across all threads
    static Book sharedBook = new Book("Java Programming", "James Gosling", 2);

    public static void main(String[] args) {
        // Create users
        Student s1 = new Student("Alice", 101);
        Student s2 = new Student("Bob", 102);
        Librarian librarian = new Librarian("Mr. Smith", 201);

        // Create student threads
        Thread t1 = new Thread(s1, "Student-Alice");
        Thread t2 = new Thread(s2, "Student-Bob");

        // Start threads (students borrow simultaneously)
        t1.start();
        t2.start();

        // Wait for student threads to finish
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Librarian adds copies
        librarian.performAction(sharedBook);

        // Student borrowing with overloaded method
        s1.borrowBook(sharedBook, "James Gosling");
    }
}
