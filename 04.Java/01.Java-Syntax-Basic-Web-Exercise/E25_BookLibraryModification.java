package Java_Basics_Exercise;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class E25_BookLibraryModification {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Library bookLibrary = new Library() {{
            setName("MyPreciousBooks");
            setBooks(new ArrayList<>());
        }};

        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        int booksCount = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < booksCount; i++) {
            String[] input = scanner.nextLine().split(" ");

            Book book = new Book() {{
                setTitle(input[0]);
                setAuthor(input[1]);
                setPublisher(input[2]);
                setReleaseDate(LocalDate.parse(input[3], df));
                setISBN(input[4]);
                setPrice(Double.parseDouble(input[5]));
            }};

            bookLibrary.getBooks().add(book);
        }

        LocalDate earliestReleaseDate = LocalDate.parse(scanner.nextLine(), df);

        Book[] sortedBooks = bookLibrary.getBooks()
                .stream()
                .filter(a -> a.getReleaseDate().isAfter(earliestReleaseDate))
                .sorted((a, b) -> {
                    int compareResult = a.getReleaseDate().compareTo(b.getReleaseDate());

                    if (compareResult == 0) {
                        compareResult = a.getTitle().compareTo(b.getTitle());
                    }

                    return compareResult;
                })
                .toArray(Book[]::new);

        for (Book book : sortedBooks) {
            System.out.printf("%s -> %s%n", book.getTitle(), df.format(book.getReleaseDate()));
        }
    }
}

class Book {
    private String Title;

    private String Author;

    private String Publisher;

    private LocalDate ReleaseDate;

    private String ISBN;

    private Double Price;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getPublisher() {
        return Publisher;
    }

    public void setPublisher(String publisher) {
        Publisher = publisher;
    }

    public LocalDate getReleaseDate() {
        return ReleaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        ReleaseDate = releaseDate;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }
}

class Library {
    private String name;

    private ArrayList<Book> books;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }
}