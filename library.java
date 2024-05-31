import java.util.*;

class Book {
    private String title;
    private String author;
    private boolean available;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.available = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}

class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
            return;
        }

        System.out.println("Books available in the library:");
        for (Book book : books) {
            System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor() +
                    ", Available: " + (book.isAvailable() ? "Yes" : "No"));
        }
    }

    public void borrowBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && book.isAvailable()) {
                book.setAvailable(false);
                System.out.println("You have borrowed the book: " + book.getTitle());
                return;
            }
        }
        System.out.println("The book '" + title + "' is not available in the library.");
    }

    public void returnBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && !book.isAvailable()) {
                book.setAvailable(true);
                System.out.println("You have returned the book: " + book.getTitle());
                return;
            }
        }
        System.out.println("You haven't borrowed the book: " + title);
    }
}

public class Library {
    public static void main(String[] args) {
        Library library = new Library();

        // Add some books to the library
        library.addBook(new Book("Iron man 1", "Stan Lee"));
        library.addBook(new Book("Infinity War", "Ruso Brothers"));
        library.addBook(new Book("End Game", "Kevin Fiege"));
        library.addBook(new Book("Captain America: Civil War","Stan Lee"));
        library.addBook(new Book("Gaurdians of the Galaxy","James Gun"));

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n----- Welcome to CMRIT Library --------");
            System.out.println("\n----- Library Management System -----\n");
            System.out.println("1. Display available books");
            System.out.println("2. Borrow a book");
            System.out.println("3. Return a book");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    library.displayBooks();
                    break;
                case 2:
                    System.out.print("Enter the title of the book to borrow: ");
                    scanner.nextLine();  // Consume the newline character
                    String borrowTitle = scanner.nextLine();
                    library.borrowBook(borrowTitle);
                    break;
                case 3:
                    System.out.print("Enter the title of the book to return: ");
                    scanner.nextLine();  // Consume the newline character
                    String returnTitle = scanner.nextLine();
                    library.returnBook(returnTitle);
                    break;
                case 0:
                    System.out.println("Thank you for using the Library Management System.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 0);

        
    }
}
